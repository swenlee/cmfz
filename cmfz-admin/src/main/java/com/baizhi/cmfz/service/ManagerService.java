package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface ManagerService {
    /**
     * 向数据库中插入管理员用户
     * @Author wendy
     * @param mgr 向数据库中插入的管理员信息
     */
    public Integer addManager(Manager mgr);
    /**
     * 根据id查找管理员用户
     * @Author wendy
     * @param name  查询的条件
     * @param password  查询的条件
     */
    public Manager queryManagerByName(String name,String password);
}
