package com.online.taxi.security.domain;

import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
public class Permission {
    private String id;
    private String code;
    private String description;
    private String url;
}
