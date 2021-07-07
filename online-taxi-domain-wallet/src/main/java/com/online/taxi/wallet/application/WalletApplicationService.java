

package com.online.taxi.wallet.application;

import com.online.taxi.wallet.domain.wallet.factory.WalletFactory;
import com.online.taxi.wallet.domain.wallet.service.WalletDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class WalletApplicationService {

    @Autowired
    private WalletDomainService walletDomainService;

    public void createWallet(Integer passengerId) {

        walletDomainService.create(WalletFactory.create(passengerId));
    }
}
