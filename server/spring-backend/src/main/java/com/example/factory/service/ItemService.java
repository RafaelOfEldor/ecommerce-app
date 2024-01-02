package com.example.factory.service;

import com.example.factory.model.Item;
import com.example.factory.repository.ItemRepository;
import com.example.factory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public Item addItem(Item Item) {
        return itemRepository.save(Item);
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemsPageable(int pageNumber) {
        return itemRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void deleteItem(Long id) {
        Item machine = itemRepository.findById(id).orElse(null);
        if(machine != null) {
            orderRepository.findAll().forEach(order -> {
                if (order.getItems().contains(getItemById(id))) {
                    order.getItems().remove(getItemById(id));
                }
            });
        }
        itemRepository.deleteById(id);
    }

    public Item updateItem(Long id, Item newItem) {

        return itemRepository.findById(id)
                .map(machine -> {
                    if (newItem.getItemName() != null) {
                        machine.setItemName(newItem.getItemName());
                    }

                    if (newItem.getItemQuantity() != null) {
                        machine.setItemQuantity(newItem.getItemQuantity());
                    }
                    return itemRepository.save(machine);
                })
                .orElseGet(() -> {
                    return itemRepository.save(newItem);
                });
    }

}
