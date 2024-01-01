package com.example.factory.service;

import com.example.factory.model.Item;
import com.example.factory.repository.MachineRepository;
import com.example.factory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MachineService {

    private final MachineRepository machineRepository;
    private final OrderRepository orderRepository;
    @Autowired
    public MachineService(MachineRepository machineRepository, OrderRepository orderRepository) {
        this.machineRepository = machineRepository;
        this.orderRepository = orderRepository;
    }

    public Item addMachine(Item Machine) {
        return machineRepository.save(Machine);
    }

    public List<Item> getMachines() {
        return machineRepository.findAll();
    }

    public List<Item> getMachinesPageable(int pageNumber) {
        return machineRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Item getMachineById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    public void deleteMachine(Long id) {
        Item machine = machineRepository.findById(id).orElse(null);
        if(machine != null) {
            orderRepository.findAll().forEach(order -> {
                if (order.getMachines().contains(getMachineById(id))) {
                    order.getMachines().remove(getMachineById(id));
                }
            });
        }
        machineRepository.deleteById(id);
    }

    public Item updateMachine(Long id, Item newMachine) {

        return machineRepository.findById(id)
                .map(machine -> {
                    if (newMachine.getMachineName() != null) {
                        machine.setMachineName(newMachine.getMachineName());
                    }

                    if (newMachine.getItemQuantity() != null) {
                        machine.setItemQuantity(newMachine.getItemQuantity());
                    }
                    return machineRepository.save(machine);
                })
                .orElseGet(() -> {
                    return machineRepository.save(newMachine);
                });
    }

}
