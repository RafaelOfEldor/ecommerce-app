package com.example.factory.service;

import com.example.factory.repository.PartRepository;
import com.example.factory.repository.SubassemlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PartService {
    private final PartRepository partRepository;
    private final SubassemlyRepository subassemblyRepository;
    @Autowired
    public PartService(PartRepository partRepository, SubassemlyRepository subassemblyRepository) {
        this.partRepository = partRepository;
        this.subassemblyRepository = subassemblyRepository;
    }

    public Part addPart(Part Part) {
        return partRepository.save(Part);
    }

    public List<Part> getParts() {
        return partRepository.findAll();
    }

    public List<Part> getPartsPageable(int pageNumber) {
        return partRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Part getPartById(Long id) {
        return partRepository.findById(id).orElse(null);
    }

    public void deletePart(Long id) {
        Part part = partRepository.findById(id).orElse(null);
        if(part != null) {
            subassemblyRepository.findAll().forEach(subassembly -> {
                if (subassembly.getParts().contains(getPartById(id))) {
                    subassembly.getParts().remove(getPartById(id));
                }
            });
        }
        partRepository.deleteById(id);
    }

    public Part updatePart(Long id, Part newPart) {

        return partRepository.findById(id)
                .map(part -> {
                    if (newPart.getPartName() != null) {
                        part.setPartName(newPart.getPartName());
                    }
                    return partRepository.save(part);
                })
                .orElseGet(() -> {
                    return partRepository.save(newPart);
                });
    }
}
