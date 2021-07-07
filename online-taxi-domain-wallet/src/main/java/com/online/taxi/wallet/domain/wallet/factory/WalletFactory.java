package com.online.taxi.wallet.domain.wallet.factory;

import com.online.taxi.wallet.domain.wallet.entity.Wallet;

import java.util.Date;

public class WalletFactory {

    public static Wallet create(Integer passengerId) {
        Wallet record = new Wallet();
        record.setPassengerId(passengerId);
        record.setFreezeGiveFee(0d);
        record.setFreezeCapital(0d);
        record.setGiveFee(0d);
        record.setCapital(0d);
        record.setCreateTime(new Date());
        return record;
    }
}
