package com.online.taxi.party.domain.driver.mapper;

import com.online.taxi.party.domain.driver.entity.Driver;

import java.util.List;

/**
 *
 */
public interface DriverMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Driver record);

    int insertSelective(Driver record);

    Driver selectByPrimaryKey(Integer id);

    List<Driver> selectByPrimaryKeyList();

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);

    int updateCarIdById(Driver record);

    Driver queryDriverByPhoneNum(String phoneNum);

    Driver queryDriverByCarId(Integer carId);

    int updateDriverByPhoneNum(Driver Driver);

}
