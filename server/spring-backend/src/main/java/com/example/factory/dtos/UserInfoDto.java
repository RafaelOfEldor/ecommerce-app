package com.example.factory.dtos;

import com.example.factory.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserInfoDto {
    /*
        Make a DTO that sends back firstName, lastName, username, role, email, id
        */

    private String firstName;
    private String lastName;
    private String userName;
    private Role role;
    private String email;
    private Long id;
}