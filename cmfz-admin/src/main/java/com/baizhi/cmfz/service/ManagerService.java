package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 * Created by Lee on 2018/7/4.
 */
public interface ManagerService {
    /**
     * 业务层通过密码姓名进行查询
     * @param mgrName
     * @param mgrPwd
     * @return
     */
    public Manager queryByNameAndPwd(String mgrName,String mgrPwd);

    /**
     * 在业务层添加一个管理员
     * @param manager
     * @return
     */
    public Integer addMgr(Manager manager);

}
