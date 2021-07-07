package com.online.taxi.wallet.domain.wallet.mapper;


import com.online.taxi.wallet.domain.wallet.entity.WalletRecord;

import java.util.List;

/**
 */
public interface WalletRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(WalletRecord record);

    WalletRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WalletRecord record);

    List<WalletRecord> selectPaidRecordByOrderId(Integer orderId);
}