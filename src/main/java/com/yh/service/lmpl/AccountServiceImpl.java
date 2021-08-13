package com.yh.service.lmpl;

import com.yh.dao.IAccountdao;
import com.yh.service.AccountService;
import com.yh.damain.Account;
import com.yh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//@Service("serviceName")相当于在application.xml的配置文件中配置了<bean id="serviceName">,
//在TestSpring里面就是获取这个accountService
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired//反射注入，相当于创建一个IAccount的对象去调用它的方法
    private IAccountdao iaccountdao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有账户...");
        System.out.println(iaccountdao.findAll());
        return iaccountdao.findAll();
    }

    @Override
    public void saveAccount(Account account) {

        System.out.println("Service业务层：保存帐户...");
        //调用seivice中的saveAccount()保存提交的数据
        iaccountdao.saveAccount(account);
    }
}
