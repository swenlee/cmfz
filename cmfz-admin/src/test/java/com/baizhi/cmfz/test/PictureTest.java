/*
package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

*/
/**
 * Created by Lee on 2018/7/5.
 *//*

public class PictureTest {
    @Test
    public void testAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        PictureDao pictureDao = (PictureDao) context.getBean("pictureDao");

        List<Picture> pictures = pictureDao.selectAllPic(1,10);

        for (Picture picture : pictures) {
            System.out.println(picture);
        }
    }
    @Test
    public void addPic(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureService pictureServiceImpl = (PictureService) context.getBean("pictureServiceImpl");

        Integer integer = pictureServiceImpl.addPicture(new Picture("1", "A3", new Date(), "123", "1"));

        System.out.println(integer);

    }
}
*/
