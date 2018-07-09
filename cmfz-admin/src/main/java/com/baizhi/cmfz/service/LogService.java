package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * Created by Lee on 2018/7/9.
 */
public interface LogService {

    /**
     *@Description
     *@Author wendy
     *@Time  2018/7/9 19:29
     *@Param [page, rows]
     *@Exception
     *@Return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> queryAllLog(Integer page, Integer rows);

    /**
     *@Description  添加日志信息
     *@Author wendy
     *@Time  2018/7/9 20:39
     *@Param [log]
     *@Exception
     *@Return boolean
     */
    public boolean appendLog(Log log);
}
