package com.mock_ecommerce_app.dtos;

import com.mock_ecommerce_app.model.Address;
import com.mock_ecommerce_app.model.Order;
import com.mock_ecommerce_app.model.Role;
import com.mock_ecommerce_app.model.UserCart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserInfoDto {
    private String firstName;
    private String lastName;
    private String userName;
    private Role role;
    private String email;
    private List<Address> addresses;
    private List<Order> orders;
    private UserCart userCart;
    private Long id;
}
