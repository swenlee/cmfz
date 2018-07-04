package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lee on 2018/7/4.
 */
public class ManagerTest {
    /*@Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerDao = (ManagerDao) context.getBean("managerDao");
        Manager manager = managerDao.selectByNameAndPwd("wendy", "123456");
        System.out.println(manager);
    }

    @Test
    public void test2(){
        System.out.println("test2 method");
    }*/

    public static void main(String[] args) {
        System.out.println("test ");
    }
}

