package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/9  19:13
 */
public interface LogDao {

    /**
     *@Description  查询所有日志信息
     *@Author wendy
     *@Time  2018/7/9 19:14
     *@Param [start, end]
     *@Exception
     *@Return java.util.List<com.qyg.cmfz.dao.Log>
     */
    public List<Log> selectAllLog(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *@Description 查询日志的数量
     *@Author wendy
     *@Time  2018/7/9 19:15
     *@Param []
     *@Exception
     *@Return java.lang.Integer
     */
    public Integer selectCountLog();


    /**
     *@Description 插入日志信息
     *@Author gege
     *@Time  2018/7/9 19:16
     *@Param [log]
     *@Exception
     *@Return java.lang.Integer
     */
    public Integer insertLog(Log log);
}
