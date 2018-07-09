package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.EchartsChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2018/7/9.
 */
@Controller
@RequestMapping("/user")
public class EchartsController {
    @RequestMapping("/showAllEchartsF")
    public @ResponseBody List<EchartsChain> showAllEchartsF(){
        List<EchartsChain> echarts=new ArrayList<EchartsChain>();
        echarts.add(new EchartsChain("北京","100","男"));
        echarts.add(new EchartsChain("天津","120","男"));
        echarts.add(new EchartsChain("上海","110","男"));
        echarts.add(new EchartsChain("重庆","50","男"));
        echarts.add(new EchartsChain("云南","70","男"));
        echarts.add(new EchartsChain("河南","90","男"));
        echarts.add(new EchartsChain("辽宁","120","男"));
        echarts.add(new EchartsChain("河北","170","男"));
        echarts.add(new EchartsChain("湖南","170","男"));
        echarts.add(new EchartsChain("黑龙江","10","男"));
        echarts.add(new EchartsChain("安徽","130","男"));
        echarts.add(new EchartsChain("山东","144","男"));
        echarts.add(new EchartsChain("新疆","10","男"));
        echarts.add(new EchartsChain("江苏","106","男"));
        echarts.add(new EchartsChain("浙江","107","男"));
        echarts.add(new EchartsChain("江西","109","男"));
        echarts.add(new EchartsChain("内蒙古","140","男"));
        echarts.add(new EchartsChain("陕西","100","男"));
        echarts.add(new EchartsChain("吉林","100","男"));
        echarts.add(new EchartsChain("福建","100","男"));

        return echarts;

    }
    @RequestMapping("/showAllEchartsM")
    public @ResponseBody List<EchartsChain> showAllEchartsM(){
        List<EchartsChain> echarts=new ArrayList<EchartsChain>();
        echarts.add(new EchartsChain("北京","170","女"));
        echarts.add(new EchartsChain("天津","109","女"));
        echarts.add(new EchartsChain("上海","134","女"));
        echarts.add(new EchartsChain("重庆","45","女"));
        echarts.add(new EchartsChain("云南","54","女"));
        echarts.add(new EchartsChain("河南","32","女"));
        echarts.add(new EchartsChain("辽宁","150","女"));
        echarts.add(new EchartsChain("河北","170","女"));
        echarts.add(new EchartsChain("湖南","175","女"));
        echarts.add(new EchartsChain("黑龙江","30","女"));
        echarts.add(new EchartsChain("安徽","145","女"));
        echarts.add(new EchartsChain("山东","153","女"));
        echarts.add(new EchartsChain("新疆","10","女"));
        echarts.add(new EchartsChain("江苏","106","女"));
        echarts.add(new EchartsChain("浙江","107","女"));
        echarts.add(new EchartsChain("江西","109","女"));
        echarts.add(new EchartsChain("内蒙古","140","女"));
        echarts.add(new EchartsChain("陕西","130","女"));
        echarts.add(new EchartsChain("吉林","150","女"));
        echarts.add(new EchartsChain("福建","110","女"));
        return echarts;

    }
}

