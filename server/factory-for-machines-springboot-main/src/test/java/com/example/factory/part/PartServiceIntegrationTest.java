package com.example.factory.part;

import com.example.factory.service.PartService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PartServiceIntegrationTest {

    @Autowired
    PartService partService;

    /*
        We create 4 parts per machine, so unlike the other entities in this program created by the CommandLineRunner bean,
        i en up with 50*4 which means 200 parts in total from the setup.
    */

    @Test
    @Transactional
    void canFetchParts(){

        var parts = partService.getParts();

        assert parts.size() == 200;
    }

    @Test
    @Transactional
    void canFetchPageOfTenParts(){

        var parts = partService.getPartsPageable(1);

        assert parts.size() == 10;
    }


    @Test
    @Transactional
    void canAddPart(){
        assert partService.getParts().size() == 200;

        Part part = new Part("data chip");
        partService.addPart(part);

        assert partService.getParts().size() == 201;

    }


    @Test
    @Transactional
    void canFetchPartById(){
        Part part = new Part("CPU");
        partService.addPart(part);

        assert partService.getPartById(part.getPartId()) != null;
        assert partService.getPartById(part.getPartId()).getPartName().equals("CPU");
    }

    @Test
    @Transactional
    void canDeletePart(){
        Part part = new Part("GPU");
        partService.addPart(part);

        assert partService.getPartById(part.getPartId()) != null;
        assert partService.getParts().size() == 201;

        partService.deletePart(part.getPartId());

        assert partService.getPartById(part.getPartId()) == null;
        assert partService.getParts().size() == 200;
    }

    @Test
    @Transactional
    void canUpdatePart(){
        Part part = new Part("screw");
        partService.addPart(part);

        assert partService.getPartById(part.getPartId()) != null;
        assert partService.getPartById(part.getPartId()).getPartName() == "screw";

        Part updatedPart = new Part("diamond screw");
        partService.updatePart(part.getPartId(), updatedPart);

        assert partService.getPartById(part.getPartId()).getPartName() == "diamond screw";
    }
}
