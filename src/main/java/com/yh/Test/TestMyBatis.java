package com.yh.Test;
import com.yh.dao.IAccountdao;
import com.yh.damain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void run1() throws IOException{
        Account account = new Account();
        account.setName("杜卡蓝");
        account.setMoney(200.0);
//        加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建sqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        创建Sqlsession对象
        SqlSession session = factory.openSession();
//        获取到代理对象
        IAccountdao dao = session.getMapper(IAccountdao.class);

        //保存数据
        dao.saveAccount(account);
//        提交事务,把修改保存到数据库
        session.commit();
//        关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        创建Sqlsession对象
        SqlSession session = factory.openSession();
//        获取到代理对象
        IAccountdao dao = session.getMapper(IAccountdao.class);
        List<Account> list = dao.findAll();
        for (Account account : list){
            System.out.println(account);
        }
        session.close();
        in.close();
    }










}
