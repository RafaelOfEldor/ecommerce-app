package com.mock_ecommerce_app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewCustomerWithNewAddressDTO {

        private String customerName;
        private String customerEmail;
        private String addressStreetName;
        private String addressStreetNameNumber;

}
