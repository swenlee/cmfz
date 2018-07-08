package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2018/7/6.
 */
public class GuruTest {
    @Test
    public void testAll(){
      /*  ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GuruDao guruDao = (GuruDao) context.getBean("guruDao");*/
        //System.out.println(guruDao);
       /* Integer integer = guruDao.selectCount();
        System.out.println(integer);*/
        /*Guru guru = guruDao.selectGuruById("1");
        System.out.println(guru);*/
        /*List<Guru> gurus = new ArrayList<Guru>();
        gurus.add(new Guru("1","we","E:\\apache-tomcat-7.0.81\\webapps\\upload","1234","383e58686488480187b5ae0347884dae.jpg"));
        gurus.add(new Guru("2","we","E:\\apache-tomcat-7.0.81\\webapps\\upload","1234","383e58686488480187b5ae0347884dae.jpg"));
        gurus.add(new Guru("3","we","E:\\apache-tomcat-7.0.81\\webapps\\upload","1234","383e58686488480187b5ae0347884dae.jpg"));
        gurus.add(new Guru("4","we","E:\\apache-tomcat-7.0.81\\webapps\\upload","1234","383e58686488480187b5ae0347884dae.jpg"));
        Integer integer = guruDao.batchInsert(gurus);
        System.out.println(integer);*/
    }
}
