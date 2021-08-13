package com.yh.service;

import com.yh.damain.Account;
import java.util.List;

//service的接口

public interface AccountService {

//    查询所以账户的方法
    public List<Account> findAll();

//    保存账户信息的方法
    public void saveAccount(Account account);
}
