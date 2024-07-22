package com.mock_ecommerce_app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemsWithQuantityDTO {

        private String itemName;
        private Long itemOrigianlId;
        private String itemImage;
        private double itemPrice;
        private String itemDescription;
        private String itemCategory;
        private int itemQuantity;

}
