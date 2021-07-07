package com.online.taxi.wallet.domain.wallet.service;


import com.online.taxi.wallet.domain.wallet.entity.Wallet;
import com.online.taxi.wallet.domain.wallet.repo.WalletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletDomainService {

    @Autowired
    private WalletDao walletDao;

    public int create(Wallet wallet) {
        return walletDao.insertSelective(wallet);
    }
}
