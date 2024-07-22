package com.mock_ecommerce_app.dtos;

import com.mock_ecommerce_app.model.Address;
import com.mock_ecommerce_app.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewCustomerDTO {
    private String customerName;
    private String customerEmail;
    private List<Order> orders;
    private List<Address> addresses;

}
