package com.online.taxi.api.client;

import com.online.taxi.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "wallet")
public interface WalletClient {

    @RequestMapping(value="/wallet/{passengerId}/init", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    ResponseResult init(@PathVariable("passengerId") Integer passengerId);
}
