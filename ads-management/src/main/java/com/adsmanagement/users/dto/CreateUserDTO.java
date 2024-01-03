package com.adsmanagement.users.dto;

import com.adsmanagement.users.models.User;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateUserDTO {

    private String name;

    private String role;

    private String email;

    private String phone;

    private Long birthday;

    private String password;

    public User ToUser() {
        return new User(null,name,role,email,phone,new Date(birthday),password,null, null);
    }
}