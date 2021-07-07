package com.online.taxi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
public class GetTokenRequest {
    @NotNull(message = "Phone Number can not be empty")
    @Pattern(message = "Phone Number is invalid", regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$")
    private String phone;

    @NotNull(message = "Verify Code can not be empty")
    private String verifyCode;

    private Integer id;

    private Integer type;

    private Integer identityStatus;

    private String equipType;

    private Double longitude;

    private Double latitude;

    private Double speed;

    private Double accuracy;

    private Double direction;

    private Double height;

    private String city;

    private String token;

    private String registerSource;

    private String marketChannel;

}
