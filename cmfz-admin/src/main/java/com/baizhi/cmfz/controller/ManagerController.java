package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Description TODO
 * @Author wendy
 * @Date 2018/7/4 14:17
 **/
@Controller
@RequestMapping("/mgr")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    @RequestMapping(value = "toLogin")
    public String toLogin(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        String mgrName="";
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("mgrName")){
                try {
                    mgrName = URLDecoder.decode(cookie.getValue(),"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("mgrName",mgrName);
        return "login";
    }

  /*  @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String login(Manager manager, String code, HttpSession session, Model model, String remember, HttpServletResponse response){
        System.out.println(manager);
        String vcode = (String) session.getAttribute("vcode");
        if(!vcode.equalsIgnoreCase(code)){
            return "login";
        }
        Manager mgr = ms.queryManagerByName(manager.getMgrName(), manager.getMgrPwd());
        System.out.println("管理员controller："+mgr);
        if(mgr == null){
            return "login";
        }
        model.addAttribute("manager",mgr);
        session.setAttribute("manager",mgr);
        if(remember.equals("true")){
            String name = mgr.getMgrName();
            try {
                name = java.net.URLEncoder.encode(name,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Cookie c1 = new Cookie("mgrName",name);
            response.addCookie(c1);
        }
        return "index";
    }*/
  @RequestMapping(value = "/login",method= RequestMethod.POST)
  public @ResponseBody Manager login(String mgrName,String mgrPwd,  HttpSession session, String code,Model model, String remember, HttpServletResponse response){
      Manager mgr = null;
      Manager manager = new Manager();
      manager.setMgrName(mgrName);
      manager.setMgrPwd(mgrPwd);
      String vcode = (String) session.getAttribute("vcode");
     /* if(!vcode.equalsIgnoreCase(code)){
          System.out.println("code验证失败！");
          return mgr;
      }else{
          mgr = new Manager();
      }*/
      mgr = ms.queryManagerByName(manager.getMgrName(), manager.getMgrPwd());
      System.out.println("管理员controller："+mgr);
      if(mgr == null){
          return mgr;
      }
      model.addAttribute("manager",mgr);
      session.setAttribute("manager",mgr);
      if(remember.equals("true")){
          System.out.println("-----"+mgr.getMgrName());
          String name = mgr.getMgrName();
          try {
              name = java.net.URLEncoder.encode(name,"utf-8");
          } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
          }
          Cookie c1 = new Cookie("mgrName",name);
          response.addCookie(c1);
      }
      return mgr;
  }


    @RequestMapping(value="/createVcode")
    public String createVcode(HttpServletResponse response, Model model,HttpSession session) throws IOException {
        CreateValidateCode cvc = new CreateValidateCode(80, 40, 4);
        String vcode = cvc.getCode();
        model.addAttribute("vcode", vcode);
        session.setAttribute("vcode", vcode);
        System.out.println(vcode);
        cvc.write(response.getOutputStream());
        return null;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
      session.setAttribute("manager",null);
       return "login";
    }
}
