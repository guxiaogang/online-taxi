package com.online.taxi.party.domain.driver.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class Driver {
    private Integer id;
    private String phoneNumber;
    private Integer driverLeader;
    private String driverName;
    private Date registerTime;
    private BigDecimal balance;
    private Integer gender;
    private Integer carId;
    private Integer isFollowing;
    private Integer workStatus;
    private String headImg;
    private String cityCode;
    private Date bindTime;
    private Integer useStatus;
    private Integer csWorkStatus;
    private Integer signStatus;
    private String tags;
    private Date createTime;
    private Date updateTime;
}