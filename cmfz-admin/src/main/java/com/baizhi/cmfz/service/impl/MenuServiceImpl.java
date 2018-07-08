package com.baizhi.cmfz.service.impl;/**
 * Created by Administrator on 2018/7/5.
 */

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author wendy
 * @Date 2018/7/5 10:36
 **/
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAllMenus() {
        return menuDao.selectAllMenus();
    }
}
