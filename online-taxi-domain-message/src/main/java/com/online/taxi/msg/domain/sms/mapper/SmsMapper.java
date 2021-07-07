package com.online.taxi.msg.domain.sms.mapper;


import com.online.taxi.msg.domain.sms.entity.Sms;

/**
 *
 */
public interface SmsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sms record);

    int insertSelective(Sms record);

    Sms selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);
}