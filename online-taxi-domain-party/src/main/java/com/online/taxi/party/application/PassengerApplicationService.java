package com.online.taxi.party.application;

import com.online.taxi.constants.IdentityEnum;
import com.online.taxi.dto.GetTokenRequest;
import com.online.taxi.dto.PassengerRegisterResponse;
import com.online.taxi.party.domain.passenger.entity.Passenger;
import com.online.taxi.party.domain.passenger.entity.PassengerRegisterSource;
import com.online.taxi.party.domain.passenger.service.PassengerDomainService;
import com.online.taxi.utility.EncriptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Service
@Transactional
public class PassengerApplicationService {

    @Autowired
    private PassengerDomainService passengerDomainService;

    public Passenger findByPhone(String phone) {
        String strPhoneNum = EncriptionUtil.toHexString(EncriptionUtil.encrypt(phone)).toUpperCase();
        return passengerDomainService.findByPhone(strPhoneNum);
    }

    public PassengerRegisterResponse register(GetTokenRequest request) {
        String phoneNumber = request.getPhone();
        String strPhoneNum = EncriptionUtil.toHexString(EncriptionUtil.encrypt(phoneNumber)).toUpperCase();
        Passenger passengerInfo = passengerDomainService.findByPhone(strPhoneNum);
        Passenger passengerInfoTmp = new Passenger();
        int passengerId;
        boolean isNewer = false;
        if (null == passengerInfo) {
            isNewer = true;
            // 若无乘客信息，记录新乘客信息
            Date date = new Date();
            passengerInfoTmp.setLastLoginTime(date);
            //登陆方式 1.验证码
            Byte method = 1;
            passengerInfoTmp.setLastLoginMethod(method);
            passengerInfoTmp.setPhone(strPhoneNum);
            passengerInfoTmp.setRegisterTime(date);
            passengerInfoTmp.setBalance(new BigDecimal(0));
            passengerInfoTmp.setCreateTime(date);
            log.info("新增乘客手机号：" + passengerInfoTmp.getPhone());
            passengerDomainService.insert(passengerInfoTmp);

            passengerId = passengerInfoTmp.getId();
            //新增注册来源

            PassengerRegisterSource passengerRegisterSource = new PassengerRegisterSource();
            passengerRegisterSource.setPassengerId(passengerId);
            String registerSource = request.getRegisterSource();
            passengerRegisterSource.setRegisterSource(registerSource);
            passengerRegisterSource.setMarketChannel(request.getMarketChannel());
            passengerRegisterSource.setCreateTime(new Date());
            passengerDomainService.insertPassengerRegisterSource(passengerRegisterSource);
        } else {
            log.info("Passenger - " + phoneNumber + " - verify status - already registered.");
            passengerId = passengerInfo.getId();
            passengerDomainService.updatePassengerInfoLoginTime(passengerId);
        }

        passengerInfo = passengerDomainService.findByPhone(strPhoneNum);

        return createResponse(passengerInfo.getPassengerName(),
                passengerInfo.getGender(), passengerInfo.getBalance(), phoneNumber,
                passengerInfo.getHeadImg(), passengerId, passengerInfo.getLastLoginTime(),
                passengerInfo.getLastLoginMethod(), passengerInfo.getIsContact(),
                passengerInfo.getIsShare(), passengerInfo.getSharingTime(),
                passengerInfo.getBirthday() == null ? null : passengerInfo.getBirthday().getTime(),
                isNewer);
    }

    private PassengerRegisterResponse createResponse(String passengerName, Byte sex,
                                                     BigDecimal balance, String phoneNum, String headImg,
                                                     Integer id, Date lastLoginTime, Byte method,
                                                     Integer isContact, Integer isShare, String sharingTime,
                                                     Long birthday, boolean isNewer) {
        PassengerRegisterResponse response = new PassengerRegisterResponse();
        response.setStatus("0");
        response.setPassengerName(StringUtils.isBlank(passengerName) ? "" : passengerName);
        response.setGender(sex == null ? 0 : sex);
        response.setId(id);
        response.setBalance(balance);
        response.setPhone(phoneNum);
        response.setHeadImg(StringUtils.isBlank(headImg) ? "" : headImg);
        String jPushId = IdentityEnum.PASSENGER.getCode() + "_" + phoneNum + "_" + Calendar.getInstance().getTimeInMillis();
        response.setJpushId(jPushId);
        response.setLastLoginTime(lastLoginTime);
        response.setLastLoginMethod(method);
        response.setIsContact(isContact);
        response.setIsShare(isShare);
        response.setSharingTime(sharingTime);
        response.setBirthday(birthday);
        response.setNewer(isNewer);
        return response;
    }
}
