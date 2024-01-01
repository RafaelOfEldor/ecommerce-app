package com.example.factory.subassembly;

import com.example.factory.repository.SubassemlyRepository;
import com.example.factory.service.SubassemblyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SubassemblyServiceUnitTest {

    @MockBean
    private SubassemlyRepository subassemblyRepository;

    @Autowired
    private SubassemblyService subassemblyService;


    @Test
    void shouldFetchAllSubassemblies(){

        List<Subassembly> subassemblyList = List.of(new Subassembly(), new Subassembly());

        when(subassemblyRepository.findAll()).thenReturn(subassemblyList);

        assert subassemblyService.getSubassemblies().size() == 2;
    }

    @Test
    void shouldAddASubassembly(){
        Subassembly subassembly = new Subassembly("Engine");

        when(subassemblyRepository.save(subassembly)).thenReturn(subassembly);

        assert subassemblyService.addSubassembly(subassembly).getSubassemblyName().equals("Engine");
    }

    @Test
    void shouldFetchSubassemblyById(){
        Optional<Subassembly> subassembly = Optional.of(new Subassembly("electric motor"));

        Mockito.<Optional<Subassembly>>when(subassemblyRepository.findById(subassembly.get().getSubassemblyId())).thenReturn(subassembly);

        assert subassemblyService.getSubassemblyById(subassembly.get().getSubassemblyId()).getSubassemblyName().equals("electric motor");
    }

    @Test
    void shouldUpdateSubassembly() {
        Subassembly existingSubassembly = new Subassembly("Electrical motor");
        when(subassemblyRepository.save(existingSubassembly)).thenReturn(existingSubassembly);

        Subassembly updatedSubassembly = new Subassembly("engine");
        Optional<Subassembly> optionalUpdatedSubassembly = Optional.of(updatedSubassembly);

        when(subassemblyRepository.findById(5L)).thenReturn(optionalUpdatedSubassembly);
        when(subassemblyRepository.save(updatedSubassembly)).thenReturn(updatedSubassembly);

        assert  subassemblyService.updateSubassembly(5L, updatedSubassembly).getSubassemblyName().equals("engine");
    }

    @Test
    void shouldDeleteSubassembly() {

        long idOfSubassemblyToDelete = 5L;

        when(subassemblyRepository.existsById(idOfSubassemblyToDelete)).thenReturn(true);

        subassemblyService.deleteSubassembly(idOfSubassemblyToDelete);

        verify(subassemblyRepository).deleteById(idOfSubassemblyToDelete);
    }
}
