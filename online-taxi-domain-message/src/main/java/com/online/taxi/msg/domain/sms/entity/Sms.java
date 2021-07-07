package com.online.taxi.msg.domain.sms.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 *
 */
@Getter
@Setter
@Builder
public class Sms {
    private Integer id;
    private String phone;
    private String smsContent;
    private Date sendTime;
    private String operator;
    private Integer sendFlag;
    private Integer sendNumber;
    private Date createTime;

    public void sendFailed() {
        setSendFlag(0);
        setSendNumber(1);
    }
}