package com.example.factory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "item_seq", allocationSize = 1)
    @Column(name = "item_id")
    private Long itemId = 0L;

    @Column(name= "item_name")
    private String itemName;

    @Column(name= "item_image", columnDefinition = "text")
    private String itemImage;

    @Column(name= "item_in_stock")
    private boolean itemInStock;

    @Column(name= "item_price")
    private double itemPrice;

    @Column(name= "item_description", columnDefinition = "text")
    private String itemDescription;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @Column(name = "item_stock")
    private Integer itemStock;

    @Column(name = "item_category")
    private String itemCategory;


    public Item(String itemName, String itemImage, boolean itemInStock, int itemPrice, List<Review> reviews, Integer itemStock, String itemCategory) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemInStock = itemInStock;
        this.itemPrice = itemPrice;
        this.reviews = reviews;
        this.itemStock = itemStock;
        this.itemCategory = itemCategory;
    }

    public Item(String itemName, String itemImage, boolean itemInStock, double itemPrice, String itemDescription, Integer itemStock, String itemCategory) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemInStock = itemInStock;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemStock = itemStock;
        this.itemCategory = itemCategory;
    }

    //Without reviews for now
}
