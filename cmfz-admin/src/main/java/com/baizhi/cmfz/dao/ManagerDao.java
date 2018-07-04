package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Lee on 2018/7/4.
 */
public interface ManagerDao {
    /**
     * 通过姓名和密码查询用户
     * @param mgrName
     * @param mgrPwd
     * @return
     */
    public Manager selectByNameAndPwd(@Param("mgrName") String mgrName,@Param("mgrPwd")String mgrPwd);

    /**
     * 插入一个管理员
     * @param manager
     * @return
     */
    public Integer insertMgr(Manager  manager);
}
