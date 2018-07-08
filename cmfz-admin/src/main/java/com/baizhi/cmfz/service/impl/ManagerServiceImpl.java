package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.Codec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Description
 * @Author wendy
 * @Date 2018/7/4 13:20
 **/
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDao md;

    public Integer addManager(Manager mgr) {
        String id = UUID.randomUUID().toString().replace("-", "");
        String pwd = Codec.encryption(mgr.getMgrPwd()+mgr.getMgrSalt());
        mgr.setMgrId(id);
        mgr.setMgrPwd(pwd);
        return md.insertManager(mgr);
    }

    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
    public Manager queryManagerByName(String name,String password) {
        Manager manager = md.selectManagerByName(name);
        if(manager != null){
            if(manager.getMgrStatus() == 1){
                String pwd = Codec.encryption(password+manager.getMgrSalt());
                System.out.println(pwd);
                if(manager.getMgrPwd().equals(pwd)||manager.getMgrPwd().equals(password)){
                    System.out.println("查询成功");
                    return manager;
                }
            }
        }
        System.out.println("查询失败");
        return null;
    }
}
