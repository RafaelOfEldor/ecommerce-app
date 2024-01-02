package com.example.factory.item;

import com.example.factory.model.Item;
import com.example.factory.service.ItemService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceIntegrationTest {

    @Autowired
    ItemService itemService;

    @Test
    @Transactional
    void canFetchMachines(){

        var machines = itemService.getMachines();

        assert machines.size() == 50;
    }

    @Test
    @Transactional
    void canFetchPageOfTenMachines(){

        var machines = itemService.getMachinesPageable(1);

        assert machines.size() == 10;
    }


    @Test
    @Transactional
    void canAddMachine(){
        assert itemService.getMachines().size() == 50;

        Item machine = new Item("Playstation", 1);
        itemService.addMachine(machine);

        assert itemService.getMachines().size() == 51;

    }


    @Test
    @Transactional
    void canFetchMachineById(){
        Item machine = new Item("Xbox", 1);
        itemService.addMachine(machine);

        assert itemService.getMachineById(machine.getMachineId()) != null;
        assert itemService.getMachineById(machine.getMachineId()).getMachineName().equals("Xbox");
    }

    @Test
    @Transactional
    void canDeleteMachine(){
        Item machine = new Item("Jason Derulo", 1);
        itemService.addMachine(machine);

        assert itemService.getMachineById(machine.getMachineId()) != null;
        assert itemService.getMachines().size() == 51;

        itemService.deleteMachine(machine.getMachineId());

        assert itemService.getMachineById(machine.getMachineId()) == null;
        assert itemService.getMachines().size() == 50;
    }

    @Test
    @Transactional
    void canUpdateMachine(){
        Item machine = new Item("Nintendo Switch", 1);
        itemService.addMachine(machine);

        assert itemService.getMachineById(machine.getMachineId()) != null;
        assert itemService.getMachineById(machine.getMachineId()).getMachineName() == "Nintendo Switch";

        Item updatedMachine = new Item("Nintendo Switch Pro", 1);
        itemService.updateMachine(machine.getMachineId(), updatedMachine);

        assert itemService.getMachineById(machine.getMachineId()).getMachineName() == "Nintendo Switch Pro";
    }
}
