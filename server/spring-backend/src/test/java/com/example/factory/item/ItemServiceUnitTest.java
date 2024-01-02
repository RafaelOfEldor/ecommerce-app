package com.example.factory.item;

import com.example.factory.model.Item;
import com.example.factory.repository.ItemRepository;
import com.example.factory.service.ItemService;
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
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;


    @Test
    void shouldFetchAllMachines(){

        List<Item> machineList = List.of(new Item(), new Item());

        when(itemRepository.findAll()).thenReturn(machineList);

        assert itemService.getMachines().size() == 2;
    }

    @Test
    void shouldAddAMachine(){
        Item machine = new Item("Playstation", 1);

        when(itemRepository.save(machine)).thenReturn(machine);

        assert itemService.addMachine(machine).getMachineName().equals("Playstation");
    }

    @Test
    void shouldFetchMachineById(){
        Optional<Item> machine = Optional.of(new Item("Xbox", 1));

        Mockito.<Optional<Item>>when(itemRepository.findById(machine.get().getMachineId())).thenReturn(machine);

        assert itemService.getMachineById(machine.get().getMachineId()).getMachineName().equals("Xbox");
    }

    @Test
    void shouldUpdateMachine() {
        Item existingMachine = new Item("Playstation", 1);
        when(itemRepository.save(existingMachine)).thenReturn(existingMachine);

        Item updatedMachine = new Item("Playstation Pro", 1);
        Optional<Item> optionalUpdatedMachine = Optional.of(updatedMachine);

        when(itemRepository.findById(5L)).thenReturn(optionalUpdatedMachine);
        when(itemRepository.save(updatedMachine)).thenReturn(updatedMachine);

        assert itemService.updateMachine(5L, updatedMachine).getMachineName().equals("Playstation Pro");
    }

    @Test
    void shouldDeleteMachine() {

        long idOfMachineToDelete = 5L;

        when(itemRepository.existsById(idOfMachineToDelete)).thenReturn(true);


        itemService.deleteMachine(idOfMachineToDelete);

        verify(itemRepository).deleteById(idOfMachineToDelete);
    }
}
