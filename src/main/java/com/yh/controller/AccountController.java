package com.yh.controller;


import com.yh.damain.Account;
import com.yh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AccountController {

    @Autowired   //按类型注入,@Autowired自动注入一个java bean的service对象。
    //controller中注入service对象，调用service对象方法并测试

    private AccountService accountService;

    @RequestMapping("/account/findAll")
    public String findAll(Model model){
        System.out.println("Controller表现层：查询所有账户...");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    //index页面提交的数据先到这里
    @RequestMapping("/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException{
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
       ///request.getContextPath()就是/ssmYH_war
        String name = request.getParameter("name");
        System.out.println(name);
        return;
    }
}

