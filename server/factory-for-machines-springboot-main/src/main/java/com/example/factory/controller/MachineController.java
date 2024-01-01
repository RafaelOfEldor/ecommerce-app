package com.example.factory.controller;

import com.example.factory.dtos.ExistingMachinesDTO;
import com.example.factory.dtos.ExistingSubassembliesDTO;
import com.example.factory.dtos.NewMachineDTO;
import com.example.factory.model.*;
import com.example.factory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/machine")
public class MachineController {

    private final CustomerService customerService;
    private final MachineService machineService;
    private final AddressService addressService;
    private final OrderService orderService;
    private SubassemblyService subassemblyService;

    @Autowired
    public MachineController(CustomerService customerService, SubassemblyService subassemblyService, AddressService addressService, OrderService orderService, MachineService machineService) {
        this.customerService = customerService;
        this.machineService = machineService;
        this.addressService = addressService;
        this.orderService = orderService;
        this.subassemblyService = subassemblyService;
    }


    @GetMapping
    public List<Item> getMachines() {
        return machineService.getMachines();
    }

    @GetMapping("/page/{pageNumber}")
    public List<Item> getMachinesByPage(@PathVariable int pageNumber) {
        try {
            return machineService.getMachinesPageable(pageNumber);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Item getMachinesById(@PathVariable Long id) {
        return machineService.getMachineById(id);
    }

    @PostMapping
    public Item addMachine(@RequestBody Item machine) {
        try {
            return machineService.addMachine(machine);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Item updateMachineById(@PathVariable Long id, @RequestBody Item machine) {
        try {
            return machineService.updateMachine(id, machine);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable Long id) {
        machineService.deleteMachine(id);
    }

    //Takes in id of order in parameter and a json with an array "machineId" of Long's corresponding to a machine's id.
    //Example:
    //      {
    //             "machineId": [
    //                           14, <-(the id of machine 14)
    //                           5, <-(the id of machine 5)
    //                           22 <-(the id of machine 22)
    //                           ]
    //      }
    @PostMapping("/order/{orderid}/addexistingmachines")
    public Order addExistingMachinesToOrder(@PathVariable Long orderid,  @RequestBody ExistingMachinesDTO existingMachineDTO) {
        try {
            Order order = orderService.getOrderById(orderid);

            for (Long machineId : existingMachineDTO.getMachineId()) {
                Item machine = machineService.getMachineById(machineId);
                order.getMachines().add(machine);
            }

            return orderService.addOrder(order);
        } catch (Exception e) {
            return null;
        }
    }

    //Takes in a json with string field "machineName" in parameter and
    //an array "subassemblyId" of Long's corresponding to a subassembly id. Example:
    //IMPORTANT THAT EXISTING SUBASSEMBLY DOES NOT YET BELONG TO ANOTHER Machine
    //    {
    //        "machineName": "(name of machine here) ",
    //        "itemQuantity" 1 <-(amount of items)
    //        "subassemblyId": [
    //                          51, <-(the id of subassembly 51)
    //                          52, <-(the id of subassembly 52)
    //                          53 <-(the id of subassembly 53)
    //                     ]
    //    }
    @PostMapping("/addto/new")
    public Item addExistingSubassemblyToNewMachine(@RequestBody NewMachineDTO newMachine) {
        try {
            Item machine = machineService.addMachine(new Item());
            machine.setMachineName(newMachine.getMachineName());
            machine.setItemQuantity(newMachine.getItemQuantity());

            for (Long subassemblyId : newMachine.getSubassemblyId()) {
                Subassembly subassembly = subassemblyService.getSubassemblyById(subassemblyId);
                machine.getSubassemblies().add(subassembly);
            }

            try {
                return machineService.addMachine(machine);
            } catch(Exception e){
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //Takes in id of machine in parameter and a json with an
    //array "subassemblyId" of Long's corresponding to a subassembly id. Example:
    //IMPORTANT THAT EXISTING SUBASSEMBLY DO NOT YET BELONG TO ANOTHER MACHINE
    //    {
    //        "subassemblyId": [
    //                          51, <-(the id of subassembly 51)
    //                          52, <-(the id of subassembly 52)
    //                          53 <-(the id of subassembly 53)
    //                     ]
    //    }
    @PostMapping("/{id}/addto/existing")
    public Item addExistingSubassemblyToExistingMachine(@PathVariable Long id, @RequestBody ExistingSubassembliesDTO existingSubassemblies) {
        try {
            Item machine = machineService.getMachineById(id);
            for (Long subassemblyId : existingSubassemblies.getSubassemblyId()) {
                Subassembly subassembly = subassemblyService.getSubassemblyById(subassemblyId);
                machine.getSubassemblies().add(subassembly);
            }
            try {
                return machineService.addMachine(machine);
            } catch(Exception e){
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}
