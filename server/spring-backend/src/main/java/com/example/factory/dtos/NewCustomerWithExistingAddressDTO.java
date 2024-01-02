package com.example.factory.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewCustomerWithExistingAddressDTO {


        private String customerName;
        private String customerEmail;
        private Long addressId;

}
