package com.mock_ecommerce_app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OpenIdCredentialsDTO {
    private String google_openid_config;
    private String microsoft_openid_config;
    private String google_client_id;
    private String microsoft_client_id;
}
