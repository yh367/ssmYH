package com.yh.Test;

import com.yh.damain.Account;
import com.yh.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring {

    @Test
    public void run1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        AccountService yh = (AccountService) applicationContext.getBean("accountService");
        //ApplicationContext.getBean() 方法用来获取 Bean，该方法返回值类型为 Object，通过强制类型转换为 HelloWorld 的实例对象，
        // 根据该对象调用类中的方法
        yh.findAll();
    }

}
