package com.example.factory.controller;

import com.example.factory.dtos.NewSubassemblyDTO;
import com.example.factory.model.*;
import com.example.factory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/subassembly")
public class SubassemblyController {

    private final CustomerService customerService;
    private final MachineService machineService;
    private final AddressService addressService;
    private final SubassemblyService subassemblyService;
    private final OrderService orderService;
    private final PartService partService;

    @Autowired
    public SubassemblyController(CustomerService customerService, PartService partService, SubassemblyService subassemblyService, AddressService addressService, OrderService orderService, MachineService machineService) {
        this.customerService = customerService;
        this.machineService = machineService;
        this.addressService = addressService;
        this.subassemblyService = subassemblyService;
        this.orderService = orderService;
        this.partService = partService;
    }


    @GetMapping
    public List<Subassembly> getSubassemblies() {
        return subassemblyService.getSubassemblies();
    }

    @GetMapping("/page/{pageNumber}")
    public List<Subassembly> getSubassembliesByPage(@PathVariable int pageNumber) {
        return subassemblyService.getSubassembliesPageable(pageNumber);
    }

    @GetMapping("/{id}")
    public Subassembly getSubassemblyById(@PathVariable Long id) {
        return subassemblyService.getSubassemblyById(id);
    }

    @PostMapping
    public Subassembly addSubassembly(@RequestBody Subassembly subassembly) {
        try {
            return subassemblyService.addSubassembly(subassembly);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Subassembly updateSubassemblyById(@PathVariable Long id, @RequestBody Subassembly subassembly) {
        try {
            return subassemblyService.updateSubassembly(id, subassembly);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSubassembly(@PathVariable Long id) {
        subassemblyService.deleteSubassembly(id);
    }

    //Takes in a json with string field "subassemblyName" in parameter and
    //an array "partId" of Long's corresponding to a part's id. Example:
    //IMPORTANT THAT EXISTING PARTS DO NOT YET BELONG TO ANOTHER SUBASSEMBLY
    //    {
    //        "subassemblyName": "(name of subassembly here) ",
    //        "partId": [
    //                          14, <-(the id of part 14)
    //                          5, <-(the id of part 5)
    //                          22 <-(the id of part 22)
    //                     ]
    //    }
    @PostMapping("/addto/new")
    public Subassembly addExistingPartsToNewSubassembly(@RequestBody NewSubassemblyDTO newSubassemblyDTO) {
        try {
            Subassembly subassembly = new Subassembly();
            subassembly.setSubassemblyName(newSubassemblyDTO.getSubassemblyName());

            for (Long partId : newSubassemblyDTO.getPartId()) {
                Part part = partService.getPartById(partId);
                subassembly.getParts().add(part);
            }
            try {
                return subassemblyService.addSubassembly(subassembly);
            } catch(Exception e) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //Takes in id of sub-assembly in parameter and a json with an
    //array "partId" of Long's corresponding to a part's id. Example:
    //IMPORTANT THAT EXISTING PARTS DO NOT YET BELONG TO ANOTHER SUBASSEMBLY
    //    {
    //        "partId": [
    //                          14, <-(the id of part 14)
    //                          5, <-(the id of part 5)
    //                          22 <-(the id of part 22)
    //                     ]
    //    }
    @PostMapping("/{id}/addto/existing")
    public Subassembly addExistingPartsToExistingSubassembly(@PathVariable Long id,  @RequestBody NewSubassemblyDTO newSubassemblyDTO) {
        try {
            Subassembly subassembly = subassemblyService.getSubassemblyById(id);
            for (Long partId : newSubassemblyDTO.getPartId()) {
                Part part = partService.getPartById(partId);
                subassembly.getParts().add(part);
            }
            try {
                return subassemblyService.addSubassembly(subassembly);
            } catch(Exception e) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}
