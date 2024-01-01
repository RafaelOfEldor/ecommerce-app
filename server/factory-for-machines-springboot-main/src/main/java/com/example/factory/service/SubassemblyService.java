package com.example.factory.service;

import com.example.factory.repository.MachineRepository;
import com.example.factory.repository.SubassemlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubassemblyService {

    private final SubassemlyRepository subassemblyRepository;
    private final MachineRepository machineRepository;
    @Autowired
    public SubassemblyService(SubassemlyRepository subassemblyRepository, MachineRepository machineRepository) {
        this.subassemblyRepository = subassemblyRepository;
        this.machineRepository = machineRepository;
    }

    public Subassembly addSubassembly(Subassembly Subassembly) {
        return subassemblyRepository.save(Subassembly);
    }

    public List<Subassembly> getSubassemblies() {
        return subassemblyRepository.findAll();
    }

    public List<Subassembly> getSubassembliesPageable(int pageNumber) {
        return subassemblyRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Subassembly getSubassemblyById(Long id) {
        return subassemblyRepository.findById(id).orElse(null);
    }

    public void deleteSubassembly(Long id) {
        Subassembly subassembly = subassemblyRepository.findById(id).orElse(null);
        if(subassembly != null) {
            machineRepository.findAll().forEach(machine -> {
                if (machine.getSubassemblies().contains(getSubassemblyById(id))) {
                    machine.getSubassemblies().remove(getSubassemblyById(id));
                }
            });
        }
        subassemblyRepository.deleteById(id);
    }

    public Subassembly updateSubassembly(Long id, Subassembly newSubassembly) {

        return subassemblyRepository.findById(id)
                .map(subassembly -> {
                    if (newSubassembly.getSubassemblyName() != null) {
                        subassembly.setSubassemblyName(newSubassembly.getSubassemblyName());
                    }
                    return subassemblyRepository.save(subassembly);
                })
                .orElseGet(() -> {
                    return subassemblyRepository.save(newSubassembly);
                });
    }

}
