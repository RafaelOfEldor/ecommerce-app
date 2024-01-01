package com.example.factory.machine;

import com.example.factory.model.Item;
import com.example.factory.repository.MachineRepository;
import com.example.factory.service.MachineService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ItemServiceUnitTest {

    @MockBean
    private MachineRepository machineRepository;

    @Autowired
    private MachineService machineService;


    @Test
    void shouldFetchAllMachines(){

        List<Item> machineList = List.of(new Item(), new Item());

        when(machineRepository.findAll()).thenReturn(machineList);

        assert machineService.getMachines().size() == 2;
    }

    @Test
    void shouldAddAMachine(){
        Item machine = new Item("Playstation", 1);

        when(machineRepository.save(machine)).thenReturn(machine);

        assert machineService.addMachine(machine).getMachineName().equals("Playstation");
    }

    @Test
    void shouldFetchMachineById(){
        Optional<Item> machine = Optional.of(new Item("Xbox", 1));

        Mockito.<Optional<Item>>when(machineRepository.findById(machine.get().getMachineId())).thenReturn(machine);

        assert machineService.getMachineById(machine.get().getMachineId()).getMachineName().equals("Xbox");
    }

    @Test
    void shouldUpdateMachine() {
        Item existingMachine = new Item("Playstation", 1);
        when(machineRepository.save(existingMachine)).thenReturn(existingMachine);

        Item updatedMachine = new Item("Playstation Pro", 1);
        Optional<Item> optionalUpdatedMachine = Optional.of(updatedMachine);

        when(machineRepository.findById(5L)).thenReturn(optionalUpdatedMachine);
        when(machineRepository.save(updatedMachine)).thenReturn(updatedMachine);

        assert machineService.updateMachine(5L, updatedMachine).getMachineName().equals("Playstation Pro");
    }

    @Test
    void shouldDeleteMachine() {

        long idOfMachineToDelete = 5L;

        when(machineRepository.existsById(idOfMachineToDelete)).thenReturn(true);


        machineService.deleteMachine(idOfMachineToDelete);

        verify(machineRepository).deleteById(idOfMachineToDelete);
    }
}
