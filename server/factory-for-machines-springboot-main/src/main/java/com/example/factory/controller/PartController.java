package com.example.factory.controller;

import com.example.factory.model.*;
import com.example.factory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/part")
public class PartController {

    private final CustomerService customerService;
    private final MachineService machineService;
    private final SubassemblyService subassemblyService;
    private final AddressService addressService;
    private final PartService partService;

    @Autowired
    public PartController(CustomerService customerService, SubassemblyService subassemblyService, AddressService addressService, PartService partService, MachineService machineService) {
        this.customerService = customerService;
        this.machineService = machineService;
        this.addressService = addressService;
        this.partService = partService;
        this.subassemblyService = subassemblyService;
    }

    @GetMapping
    public List<Part> getParts() {
        return partService.getParts();
    }

    @GetMapping("/page/{pageNumber}")
    public List<Part> getPartsByPage(@PathVariable int pageNumber) {
        return partService.getPartsPageable(pageNumber);
    }

    @GetMapping("/{id}")
    public Part getPartById(@PathVariable Long id) {
        return partService.getPartById(id);
    }

    @PostMapping
    public Part addPart(@RequestBody Part part) {
        try {
            return partService.addPart(part);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Part updatePartById(@PathVariable Long id, @RequestBody Part part) {
        try {
            return partService.updatePart(id, part);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletePart(@PathVariable Long id) {
        partService.deletePart(id);
    }


}
