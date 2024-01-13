package com.example.factory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_cart")
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_cart_seq_gen")
    @SequenceGenerator(name = "user_cart_seq_gen", sequenceName = "user_cart_seq", allocationSize = 1)
    @Column(name = "user_cart_id")
    private Long id = 0L;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_carts_items",
            joinColumns = @JoinColumn(name = "user_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"userCart", "password", "userName", "credentialsNonExpired",
            "credentialsNonExpired", "accountNonExpired", "accountNonLocked", "userPassword"
    ,"userEmail", "enabled", "authorities", "role"})
    private User user;
}
