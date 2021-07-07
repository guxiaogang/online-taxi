package com.online.taxi.wallet.domain.wallet.entity;

import lombok.Data;

import java.util.Date;

/**
 */
@Data
public class Wallet {
    private Integer id;
    private Integer passengerId;
    private Double capital;
    private Double giveFee;
    private Double freezeCapital;
    private Double freezeGiveFee;
    private Date createTime;
    private Date updateTime;

}