package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单栏查找
 * @Author wendy
 * Created by Administrator on 2018/7/5.
 */
public interface MenuDao {
    /**
     * 查看所有菜单的选项
     * @return
     */
    public List<Menu> selectAllMenus();
}
