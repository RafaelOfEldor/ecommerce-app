package com.example.factory.part;

import com.example.factory.repository.PartRepository;
import com.example.factory.service.PartService;
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
public class PartServiceUnitTest {

    @MockBean
    private PartRepository partRepository;

    @Autowired
    private PartService partService;


    @Test
    void shouldFetchAllParts(){

        List<Part> partList = List.of(new Part(), new Part());

        when(partRepository.findAll()).thenReturn(partList);

        assert partService.getParts().size() == 2;
    }

    @Test
    void shouldAddAPart(){
        Part part = new Part("data chip");

        when(partRepository.save(part)).thenReturn(part);

        assert partService.addPart(part).getPartName().equals("data chip");
    }

    @Test
    void shouldFetchPartById(){
        Optional<Part> part = Optional.of(new Part("CPU"));

        Mockito.<Optional<Part>>when(partRepository.findById(part.get().getPartId())).thenReturn(part);

        assert partService.getPartById(part.get().getPartId()).getPartName().equals("CPU");
    }

    @Test
    void shouldUpdatePart() {
        Part existingPart = new Part("data chip");
        when(partRepository.save(existingPart)).thenReturn(existingPart);

        Part updatedPart = new Part("sim card");
        Optional<Part> optionalUpdatedPart = Optional.of(updatedPart);

        when(partRepository.findById(5L)).thenReturn(optionalUpdatedPart);
        when(partRepository.save(updatedPart)).thenReturn(updatedPart);

        assert  partService.updatePart(5L, updatedPart).getPartName().equals("sim card");
    }

    @Test
    void shouldDeletePart() {

        long idOfPartToDelete = 5L;

        when(partRepository.existsById(idOfPartToDelete)).thenReturn(true);

        partService.deletePart(idOfPartToDelete);

        verify(partRepository).deleteById(idOfPartToDelete);
    }
}
