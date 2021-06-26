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

package com.online.taxi.party.application;

import com.online.taxi.domain.party.Account;
import com.online.taxi.infrastructure.utility.Encryption;
import com.online.taxi.party.domain.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 用户资源的应用服务接口
 *
 **/
@Service
@Transactional
public class AccountApplicationService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private Encryption encoder;

    public void createAccount(Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        repository.save(account);
    }

    public Account findAccountByUsername(String username) {
        return repository.findByUsername(username);
    }

    public void updateAccount(Account account) {
        repository.save(account);
    }

}
