package com.online.taxi.party.domain.passenger.repo;

import com.online.taxi.party.domain.passenger.entity.Passenger;
import com.online.taxi.party.domain.passenger.entity.PassengerRegisterSource;
import com.online.taxi.party.domain.passenger.mapper.PassengerMapper;
import com.online.taxi.party.domain.passenger.mapper.PassengerRegisterSourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PassengerDao {

    @Autowired
    private PassengerMapper passengerMapper;

    @Autowired
    private PassengerRegisterSourceMapper passengerRegisterSourceMapper;

    public int insertPassengerRegisterSource(PassengerRegisterSource passengerRegisterSource) {
        return passengerRegisterSourceMapper.insertSelective(passengerRegisterSource);
    }

    public Passenger queryPassengerInfoById(Integer passengerId) {
        return passengerMapper.selectByPrimaryKey(passengerId);
    }

    public Passenger queryPassengerInfoByPhoneNum(String phoneNum) {
        return passengerMapper.queryPassengerByPhoneNum(phoneNum);
    }

    public int deleteByPrimaryKey(Integer id) {
        return passengerMapper.deleteByPrimaryKey(id);
    }

    public int insert(Passenger record) {
        return passengerMapper.insert(record);
    }

    public int insertSelective(Passenger record) {
        return passengerMapper.insertSelective(record);
    }

    public Passenger selectByPrimaryKey(Integer id) {
        return passengerMapper.selectByPrimaryKey(id);
    }
    public List<Passenger> selectByPrimaryKeyList() {
        return passengerMapper.selectByPrimaryKeyList();
    }

    public int updateByPrimaryKeySelective(Passenger record) {
        return passengerMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Passenger record) {
        return passengerMapper.updateByPrimaryKey(record);
    }

    public void updatePassengerInfoLoginTime(Integer passengerId) {
        passengerMapper.updatePassengerLoginTime(passengerId);
    }
}
