package com.online.taxi.party.domain.passenger.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Passenger {
    private Integer id;
    private String phone;
    private String education;
    private Date birthday;
    private String passengerName;
    private Date registerTime;
    private BigDecimal balance;
    private Byte gender;
    private String headImg;
    private Byte passengerType;
    private Byte userLevel;
    private Short registerType;
    private Date lastLoginTime;
    private Byte lastLoginMethod;
    private Date lastLoginScreenTime;
    private String lastLoginScreenMethod;
    private Date lastOrderTime;
    private Date createTime;
    private Date updateTime;
    private Integer isContact;
    private Integer isShare;
    private String sharingTime;
}
