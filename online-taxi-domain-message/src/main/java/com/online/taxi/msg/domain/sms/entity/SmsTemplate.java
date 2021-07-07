package com.online.taxi.msg.domain.sms.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 *
 */
@Getter
@Setter
public class SmsTemplate {
    private Integer id;
    private String templateId;
    private String content;
    private Date createTime;
    private Date updateTime;
}