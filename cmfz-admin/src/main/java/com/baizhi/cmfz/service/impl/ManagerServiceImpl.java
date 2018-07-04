package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lee on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public Manager queryByNameAndPwd(String mgrName, String mgrPwd) {
        Manager manager = managerDao.selectByNameAndPwd(mgrName,mgrPwd);
        return manager;
    }

    @Override
    public Integer addMgr(Manager manager) {
        String salt = EncryptionUtils.getRandomSalt(4);
        manager.setSalt(salt);
        manager.setMgrPwd(DigestUtils.md5Hex(manager.getMgrPwd()+salt));
        manager.setMgrId("2");
        manager.setStatus("0");
        Integer result = managerDao.insertMgr(manager);
        return result;
    }
}
