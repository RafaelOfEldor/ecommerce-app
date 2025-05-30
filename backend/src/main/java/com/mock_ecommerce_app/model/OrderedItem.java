package com.mock_ecommerce_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "ordered_items")
public class OrderedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordered_item_seq_gen")
    @SequenceGenerator(name = "ordered_item_seq_gen", sequenceName = "ordered_item_seq", allocationSize = 1)
    @Column(name = "ordered_item_id")
    private Long orderedItemId = 0L;

    @Column(name= "ordered_item_name")
    private String orderedItemName;

    @Column(name= "ordered_item_original_item_id")
    private Long orderedItemOriginalItemId;

    @Column(name= "ordered_item_image", columnDefinition = "text")
    private String orderedItemImage;

    @Column(name= "ordered_item_price")
    private double orderedItemPrice;

    @Column(name= "ordered_item_description", columnDefinition = "text")
    private String orderedItemDescription;

    @Column(name = "ordered_item_category")
    private String orderedItemCategory;

    @Column(name = "ordered_item_quantity")
    private Integer orderedItemQuantity;

    public OrderedItem(String orderedItemName, Long orderedItemOriginalItemId, String orderedItemImage, double orderedItemPrice, String orderedItemDescription, String orderedItemCategory, Integer orderedItemQuantity) {
        this.orderedItemName = orderedItemName;
        this.orderedItemOriginalItemId = orderedItemOriginalItemId;
        this.orderedItemImage = orderedItemImage;
        this.orderedItemPrice = orderedItemPrice;
        this.orderedItemDescription = orderedItemDescription;
        this.orderedItemCategory = orderedItemCategory;
        this.orderedItemQuantity = orderedItemQuantity;
    }
}
