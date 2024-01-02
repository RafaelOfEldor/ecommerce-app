package com.example.factory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long id = 0L;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "usernamename")
    private String username;

    @Column(name = "_password")
    private String password;
    @Column(name = "email")
    private String email;

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }



    public String getUserName() {
        return username;
    }

    public String getUserPassword() {
        return password;
    }

    public String getUserEmail() {
        return email;
    }


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    @JsonIgnoreProperties("user")
//    private List<Order> orders = new ArrayList<>();

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_address",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "address_id")
//    )
//    @JsonIgnoreProperties("users")
//    private List<Address> addresses = new ArrayList<>();

    public User(String userName, String userPassword) {
        this.username = userName;
        this.password = userPassword;
    }

    //      --------For testing-------
    public User(Long userId, String userName, String userEmail) {
        this.id = userId;
        this.username = userName;
        this.email = userEmail;
    }
}
