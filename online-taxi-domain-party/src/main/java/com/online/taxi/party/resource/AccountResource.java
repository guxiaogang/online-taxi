/*
 * Copyright 2012-2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. More information from:
 *
 *        https://github.com/fenixsoft
 */

package com.online.taxi.party.resource;

import com.online.taxi.domain.party.Account;
import com.online.taxi.party.application.AccountApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;



/**
 * 用户资源
 * <p>
 * 对客户端以Restful形式暴露资源，提供对用户资源{@link Account}的管理入口
 **/

@RestController
@RequestMapping(path = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
//@CacheConfig(cacheNames = "resource.account")
public class AccountResource {

    @Autowired
    private AccountApplicationService service;

    /**
     * 根据用户名称获取用户详情
     */
    @GetMapping(path = "/{username}")
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_API','BROWSER')")
    public Account getUser(@PathParam("username") String username) {
        return service.findAccountByUsername(username);
    }

//    /**
//     * 创建新的用户
//     */
//    @POST
//    @CacheEvict(key = "#user.username")
//    @PreAuthorize("#oauth2.hasAnyScope('BROWSER')")
//    public Response createUser(@Valid @UniqueAccount Account user) {
//        return CommonResponse.op(() -> service.createAccount(user));
//    }

//    /**
//     * 更新用户信息
//     */
//    @PUT
//    @CacheEvict(key = "#user.username")
//    @PreAuthorize("#oauth2.hasAnyScope('BROWSER')")
//    public Response updateUser(@Valid @AuthenticatedAccount @NotConflictAccount Account user) {
//        return CommonResponse.op(() -> service.updateAccount(user));
//    }
}
