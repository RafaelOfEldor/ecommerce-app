package com.example.factory.machine;

import com.example.factory.model.Item;
import com.example.factory.service.MachineService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceIntegrationTest {

    @Autowired
    MachineService machineService;

    @Test
    @Transactional
    void canFetchMachines(){

        var machines = machineService.getMachines();

        assert machines.size() == 50;
    }

    @Test
    @Transactional
    void canFetchPageOfTenMachines(){

        var machines = machineService.getMachinesPageable(1);

        assert machines.size() == 10;
    }


    @Test
    @Transactional
    void canAddMachine(){
        assert machineService.getMachines().size() == 50;

        Item machine = new Item("Playstation", 1);
        machineService.addMachine(machine);

        assert machineService.getMachines().size() == 51;

    }


    @Test
    @Transactional
    void canFetchMachineById(){
        Item machine = new Item("Xbox", 1);
        machineService.addMachine(machine);

        assert machineService.getMachineById(machine.getMachineId()) != null;
        assert machineService.getMachineById(machine.getMachineId()).getMachineName().equals("Xbox");
    }

    @Test
    @Transactional
    void canDeleteMachine(){
        Item machine = new Item("Jason Derulo", 1);
        machineService.addMachine(machine);

        assert machineService.getMachineById(machine.getMachineId()) != null;
        assert machineService.getMachines().size() == 51;

        machineService.deleteMachine(machine.getMachineId());

        assert machineService.getMachineById(machine.getMachineId()) == null;
        assert machineService.getMachines().size() == 50;
    }

    @Test
    @Transactional
    void canUpdateMachine(){
        Item machine = new Item("Nintendo Switch", 1);
        machineService.addMachine(machine);

        assert machineService.getMachineById(machine.getMachineId()) != null;
        assert machineService.getMachineById(machine.getMachineId()).getMachineName() == "Nintendo Switch";

        Item updatedMachine = new Item("Nintendo Switch Pro", 1);
        machineService.updateMachine(machine.getMachineId(), updatedMachine);

        assert machineService.getMachineById(machine.getMachineId()).getMachineName() == "Nintendo Switch Pro";
    }
}
