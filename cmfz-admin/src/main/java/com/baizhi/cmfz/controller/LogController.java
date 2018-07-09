package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

/**
 * Created by Lee on 2018/7/9.
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/showAllLog")
    public @ResponseBody Map<String,Object> showAllLog(Integer page,Integer rows){
        return logService.queryAllLog(page, rows);
    }
}
