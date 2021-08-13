package com.yh.dao;

import com.yh.damain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

//dao的接口

@Repository //这个注解表示这是一个持久层，用法类似与@control,@service
public interface IAccountdao {

    //    这个一个接口，但不需要实现它，用于 函数与SQL语句 的映射
    @Select("select * from account")//查出结果并映射到account类:
    public List<Account> findAll();


    @Insert("insert into account (name,money) value(#{name},#{money})")
    public void saveAccount(Account account);

}
