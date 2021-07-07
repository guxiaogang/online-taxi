package com.online.taxi.msg.domain.sms.factory;

import com.online.taxi.msg.domain.sms.entity.Sms;

import java.util.Date;

public class SmsFactory {

    public static Sms create(String phone, String content) {
        Sms.SmsBuilder builder = Sms.builder()
                .phone(phone)
                .createTime(new Date())
                .sendFlag(1)
                .sendNumber(0)
                .operator("")
                .smsContent(content);
        return builder.build();
    }
}
