package com.online.taxi.party.domain.passenger.service;

import com.online.taxi.party.domain.passenger.entity.Passenger;
import com.online.taxi.party.domain.passenger.entity.PassengerRegisterSource;
import com.online.taxi.party.domain.passenger.repo.PassengerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerDomainService {

    @Autowired
    private PassengerDao passengerDao;

    public Passenger findByPhone(String phone) {
        return passengerDao.queryPassengerInfoByPhoneNum(phone);
    }

    public void insert(Passenger passenger) {
        passengerDao.insert(passenger);
    }

    public void insertPassengerRegisterSource(PassengerRegisterSource passengerRegisterSource) {
        passengerDao.insertPassengerRegisterSource(passengerRegisterSource);
    }

    public void updatePassengerInfoLoginTime(int passengerId) {
        passengerDao.updatePassengerInfoLoginTime(passengerId);
    }
}
