package com.online.taxi.wallet.domain.wallet.repo;

import com.online.taxi.wallet.domain.wallet.entity.Wallet;
import com.online.taxi.wallet.domain.wallet.mapper.WalletMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class WalletDao {

    @NonNull
    private WalletMapper walletMapper;

    public int insertSelective(Wallet record) {
        return walletMapper.insertSelective(record);
    }

}
