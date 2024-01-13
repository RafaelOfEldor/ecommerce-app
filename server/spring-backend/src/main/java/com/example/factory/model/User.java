package com.example.factory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long id = 0L;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "user_cart_id")
    @JsonIgnoreProperties({"user"})
    private UserCart userCart;

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
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

//    public User(String userName, String userPassword) {
//        this.username = userName;
//        this.password = userPassword;
//    }
//
//    //      --------For testing-------
//    public User(Long userId, String userName, String userEmail) {
//        this.id = userId;
//        this.username = userName;
//        this.email = userEmail;
//    }
}
