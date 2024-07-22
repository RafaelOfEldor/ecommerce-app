package com.mock_ecommerce_app.repository;

import com.mock_ecommerce_app.model.Item;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemCategory(String itemCategory, PageRequest pageable);
}
