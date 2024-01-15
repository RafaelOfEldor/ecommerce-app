package com.example.factory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_seq", allocationSize = 1)
    @Column(name = "order_id")
    private Long orderId = 0L;

    @OneToOne
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties({"orders", "addresses", "users"})
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "ordered_item_id")
    )
    private List<OrderedItem> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"orders", "addresses"})
    private User user;

    public Order(Address address) {
        this.address = address;
    }
}
