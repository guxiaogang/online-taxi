package com.online.taxi.msg.domain.sms.service;

import com.online.taxi.msg.domain.sms.entity.Sms;
import com.online.taxi.msg.domain.sms.repo.SmsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@Slf4j
public class SmsDomainService {

    @Autowired
    private SmsDao smsDao;

    public void save(Sms sms) {
        smsDao.insert(sms);
    }
}
