
package com.online.taxi.wallet.resource;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.wallet.application.WalletApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/wallet", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@CacheConfig(cacheNames = "resource.wallet")
public class WalletResource {

    @Autowired
    private WalletApplicationService walletApplicationService;

    /**
     * 根据用户名称获取用户详情
     */
    @PostMapping("/{passengerId}/init")
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_WALLET','BROWSER')")
    public ResponseResult create(@PathVariable("passengerId") Integer passengerId) {
        walletApplicationService.createWallet(passengerId);
        return ResponseResult.success();
    }

}
