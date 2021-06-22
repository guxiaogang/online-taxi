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
import com.online.taxi.infrastructure.jaxrs.CommonResponse;
import com.online.taxi.party.application.AccountApplicationService;
import com.online.taxi.party.domain.validation.AuthenticatedAccount;
import com.online.taxi.party.domain.validation.NotConflictAccount;
import com.online.taxi.party.domain.validation.UniqueAccount;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 用户资源
 * <p>
 * 对客户端以Restful形式暴露资源，提供对用户资源{@link Account}的管理入口
 **/
@Path("/accounts")
@Component
@CacheConfig(cacheNames = "resource.account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    private AccountApplicationService service;

    /**
     * 根据用户名称获取用户详情
     */
    @GET
    @Path("/{username}")
    @Cacheable(key = "#username")
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_API','BROWSER')")
    public Account getUser(@PathParam("username") String username) {
        return service.findAccountByUsername(username);
    }

    /**
     * 创建新的用户
     */
    @POST
    @CacheEvict(key = "#user.username")
    @PreAuthorize("#oauth2.hasAnyScope('BROWSER')")
    public Response createUser(@Valid @UniqueAccount Account user) {
        return CommonResponse.op(() -> service.createAccount(user));
    }

    /**
     * 更新用户信息
     */
    @PUT
    @CacheEvict(key = "#user.username")
    @PreAuthorize("#oauth2.hasAnyScope('BROWSER')")
    public Response updateUser(@Valid @AuthenticatedAccount @NotConflictAccount Account user) {
        return CommonResponse.op(() -> service.updateAccount(user));
    }
}
