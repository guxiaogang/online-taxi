package com.online.taxi.msg.domain.sms.repo;

import com.online.taxi.msg.domain.sms.entity.Sms;
import com.online.taxi.msg.domain.sms.mapper.SmsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class SmsDao {

    @Autowired
    private SmsMapper smsMapper;

    public int insert(Sms sms) {
        return smsMapper.insertSelective(sms);
    }
}
