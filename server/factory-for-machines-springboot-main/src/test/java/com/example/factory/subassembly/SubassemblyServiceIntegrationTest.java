package com.example.factory.subassembly;

import com.example.factory.service.SubassemblyService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubassemblyServiceIntegrationTest {

    @Autowired
    SubassemblyService subassemblyService;

    @Test
    @Transactional
    void canFetchSubassemblies(){

        var subassemblies = subassemblyService.getSubassemblies();

        assert subassemblies.size() == 50;
    }

    @Test
    @Transactional
    void canFetchPageOfTenSubassemblies(){

        var subassemblies = subassemblyService.getSubassembliesPageable(1);

        assert subassemblies.size() == 10;
    }


    @Test
    @Transactional
    void canAddSubassembly(){
        assert subassemblyService.getSubassemblies().size() == 50;

        Subassembly subassembly = new Subassembly("Mother board");
        subassemblyService.addSubassembly(subassembly);

        assert subassemblyService.getSubassemblies().size() == 51;

    }


    @Test
    @Transactional
    void canFetchSubassemblyById(){
        Subassembly subassembly = new Subassembly("Quantum reactor");
        subassemblyService.addSubassembly(subassembly);

        assert subassemblyService.getSubassemblyById(subassembly.getSubassemblyId()) != null;
        assert subassemblyService.getSubassemblyById(subassembly.getSubassemblyId()).getSubassemblyName().equals("Quantum reactor");
    }

    @Test
    @Transactional
    void canDeleteSubassembly(){
        Subassembly subassembly = new Subassembly("Engine");
        subassemblyService.addSubassembly(subassembly);

        assert subassemblyService.getSubassemblyById(subassembly.getSubassemblyId()) != null;
        assert subassemblyService.getSubassemblies().size() == 51;

        subassemblyService.deleteSubassembly(subassembly.getSubassemblyId());

        assert subassemblyService.getSubassemblyById(subassembly.getSubassemblyId()) == null;
        assert subassemblyService.getSubassemblies().size() == 50;
    }

    @Test
    @Transactional
    void canUpdateSubassembly(){
        Subassembly subassembly = new Subassembly("Electric motor");
        subassemblyService.addSubassembly(subassembly);

        assert subassemblyService.getSubassemblyById(subassembly.getSubassemblyId()) != null;
        assert subassemblyService.getSubassemblyById(subassembly.getSubassemblyId()).getSubassemblyName() == "Electric motor";

        Subassembly updatedSubassembly = new Subassembly("Hybrid motor");
        subassemblyService.updateSubassembly(subassembly.getSubassemblyId(), updatedSubassembly);

        assert subassemblyService.getSubassemblyById(subassembly.getSubassemblyId()).getSubassemblyName() == "Hybrid motor";
    }
}
