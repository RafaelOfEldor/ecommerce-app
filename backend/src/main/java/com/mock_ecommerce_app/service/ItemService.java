package com.mock_ecommerce_app.service;

import com.mock_ecommerce_app.model.Item;
import com.mock_ecommerce_app.repository.ItemRepository;
import com.mock_ecommerce_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by(Sort.Order.asc("itemId")));
        return itemRepository.findAll(pageable).getContent();
    }

    public List<Item> getApparelPageable(int pageNumber) {
        return itemRepository.findByItemCategory("apparel", PageRequest.of(pageNumber, 10)).stream().toList();
    }
    public List<Item> getJewelryPageable(int pageNumber) {
        return itemRepository.findByItemCategory("jewelry", PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public List<Item> getTechnologyPageable(int pageNumber) {
        return itemRepository.findByItemCategory("technology", PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public List<Item> getGardeningPageable(int pageNumber) {
        return itemRepository.findByItemCategory("gardening", PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public List<Item> getConsumablesPageable(int pageNumber) {
        return itemRepository.findByItemCategory("consumables", PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public List<Item> getFurniturePageable(int pageNumber) {
        return itemRepository.findByItemCategory("furniture", PageRequest.of(pageNumber, 10)).stream().toList();
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

//    public Item updateItem(Long id, Item newItem) {
//
//        return itemRepository.findById(id)
//                .map(machine -> {
//                    if (newItem.getItemName() != null) {
//                        machine.setItemName(newItem.getItemName());
//                    }
//
//                    if (newItem.getItemQuantity() != null) {
//                        machine.setItemQuantity(newItem.getItemQuantity());
//                    }
//                    return itemRepository.save(machine);
//                })
//                .orElseGet(() -> {
//                    return itemRepository.save(newItem);
//                });
//    }

}
