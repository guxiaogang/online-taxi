package com.online.taxi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PassengerRegisterResponse {
    private String status;
    private String accessToken ;
    private String phone;
    private Byte gender;
    private Integer id;
    private String passengerName;
    private BigDecimal balance;
    private String headImg;
    private String jpushId;
    private int lastLoginMethod;
    private Date LastLoginTime;
    private Integer isContact;
    private Integer isShare;
    private String sharingTime;
    private Long birthday;
    private boolean isNewer;
}
