/*
package ManagerTest;*/
/**
 * Created by Administrator on 2018/7/4.
 *//*


import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.Codec;
import org.aspectj.apache.bcel.classfile.Code;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

*/
/**
 * @Description TODO
 * @Author wendy
 * @Date 2018/7/4 14:31
 **//*

public class mgrTest {

    @Test
    public void testmd5(){
        String code = Codec.encryption("123456"+"abcd");
        System.out.println(code);
    }

    @Test
    public void encode(){
*/
/*        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerDao = (ManagerDao) context.getBean("managerDao");
        Integer integer = managerDao.insertManager(new Manager("6", "张三", "123456", "abcd", 1l));
        System.out.println(integer);*//*

    }

    @Test
    public void service(){
        */
/*ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService = (ManagerService) context.getBean("managerServiceImpl");
       *//*
*/
/* Integer integer = managerService.addManager(new Manager("6", "曹九龙", "123456", "aaaa", 1l));
        System.out.println(integer);*//*

    }

}
*/
