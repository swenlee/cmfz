package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface MenuService {
    /**
     * 查询所有的菜单项
     * @return
     */
    public List<Menu> queryAllMenus();
}
