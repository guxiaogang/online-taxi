package com.online.taxi.security.dao;


import com.online.taxi.security.domain.Account;
import com.online.taxi.security.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 **/
@Repository
public class AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据账号查询用户信息
    public Account getUserByUsername(String username) {
        String sql = "select * from account where username = ?";
        List<Account> list = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(Account.class));
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    //根据用户id查询用户权限
    public List<String> findPermissionsByUserId(String userId) {
        String sql = "SELECT * FROM permission WHERE id IN(\n" +
                "\n" +
                "SELECT permission_id FROM role_permission WHERE role_id IN(\n" +
                "  SELECT role_id FROM user_role WHERE user_id = ? \n" +
                ")\n" +
                ")\n";

        List<Permission> list = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Permission.class));
        List<String> permissions = new ArrayList<>();
        list.forEach(c -> permissions.add(c.getCode()));
        return permissions;
    }
}
