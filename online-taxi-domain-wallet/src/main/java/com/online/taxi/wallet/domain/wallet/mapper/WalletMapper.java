package com.online.taxi.wallet.domain.wallet.mapper;

import com.online.taxi.wallet.domain.wallet.entity.Wallet;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 */
@Service
public interface WalletMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Wallet record);

    int insertSelective(Wallet record);

    Wallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wallet record);

    int updateByPrimaryKey(Wallet record);

    Wallet selectByPassengerInfoId(Integer passengerInfoId);

    int updateBalanceByPassengerInfoId(Map<String, Object> param);

    int unfreezeBalanceByPassengerInfoId(Map<String, Object> param);

}