package com.online.taxi.security.domain;

import lombok.Data;


@Data
public class Account {
    private String id;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private String telephone;
    private String email;
    private String location;

}
