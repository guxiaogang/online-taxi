package com.online.taxi.party.domain.passenger.mapper;

import com.online.taxi.party.domain.passenger.entity.Passenger;

import java.util.List;
import java.util.Map;

/**
 * @date
 */
public interface PassengerMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Passenger record);

    int insertSelective(Passenger record);

    Passenger selectByPrimaryKey(Integer id);

    List<Passenger> selectByPrimaryKeyList();

    int updateByPrimaryKeySelective(Passenger record);

    int updateByPrimaryKey(Passenger record);

    Passenger queryPassengerByPhoneNum(String phoneNum);

    int updatePassengerBalance(Map<String, Object> map);

    void updatePassengerLoginTime(Integer passengerId);
}
