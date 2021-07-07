package com.online.taxi.party.domain.passenger.mapper;


import com.online.taxi.party.domain.passenger.entity.PassengerRegisterSource;

public interface PassengerRegisterSourceMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(PassengerRegisterSource record);
    int insertSelective(PassengerRegisterSource record);
    PassengerRegisterSource selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(PassengerRegisterSource record);
    int updateByPrimaryKey(PassengerRegisterSource record);
}