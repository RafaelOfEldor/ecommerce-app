package com.example.factory.dtos;

import com.example.factory.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PurchaseItemDTO {
    private Long userId;

    private List<ItemsWithQuantityDTO> items;
}
