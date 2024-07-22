package com.mock_ecommerce_app.repository;

import com.mock_ecommerce_app.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {
}
