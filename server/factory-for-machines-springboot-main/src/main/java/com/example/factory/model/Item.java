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
@Entity
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_seq_gen")
    @SequenceGenerator(name = "machine_seq_gen", sequenceName = "machine_seq", allocationSize = 1)
    @Column(name = "item_id")
    private Long itemId = 0L;

    @Column(name= "machine_name")
    private String itemName;

    @Column(name = "item_qty")
    private Integer itemQuantity;

    public Item(String machineName, Integer quantity) {
        this.itemName = machineName;
        this.itemQuantity = quantity;
    }

}
