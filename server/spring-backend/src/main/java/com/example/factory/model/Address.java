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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
    @SequenceGenerator(name = "address_seq_gen", sequenceName = "address_seq", allocationSize = 1)
    @Column(name = "address_id")
    private Long addressId = 0L;

    @Column(name = "address_street_name")
    private String addressStreetName;


    @Column(name = "address_house_number")
    private String addressHouseNumber;

    @Column(name = "address_postal_code")
    private String addressPostalCode;

    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"orders", "addresses"})
    private List<User> users = new ArrayList<>();

    public Address(String addressStreetName, String addressHouseNumber, String addressPostalCode) {
        this.addressStreetName = addressStreetName;
        this.addressHouseNumber = addressHouseNumber;
        this.addressPostalCode = addressPostalCode;
    }
}
