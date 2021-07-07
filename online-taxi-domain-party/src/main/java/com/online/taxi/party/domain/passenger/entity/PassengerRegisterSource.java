package com.online.taxi.party.domain.passenger.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PassengerRegisterSource {
    private Integer id;
    private Integer passengerId;
    private String registerSource;
    private String marketChannel;
    private Date createTime;
    private Date updateTime;
}