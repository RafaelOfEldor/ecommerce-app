package com.mock_ecommerce_app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewAddressDTO {
    private Long userId;
    private String addressStreetName;
    private String addressHouseNumber;
    private String addressPostalCode;

}
