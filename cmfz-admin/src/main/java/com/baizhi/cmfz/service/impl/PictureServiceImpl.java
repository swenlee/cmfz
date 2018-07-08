package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Lee on 2018/7/5.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureDao pictureDao;

    public Map<String, Object> queryAll(Integer page, Integer rows) {
        List<Picture> pictures = pictureDao.selectAllPic((page - 1) * rows , page * rows);
        Integer count = pictureDao.selectCount();
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("total", count);
        map.put("rows", pictures);
        return map;
    }

    @Override
    public Integer addPicture(Picture picture) {
        Integer integer = pictureDao.insertPicture(picture);
        return integer;
    }

    @Override
    public Integer removePictureById(String id) {
        return pictureDao.deletePictureById(id);
    }

    @Override
    public Integer modifyPicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Picture queryPictureById(String id) {
        return pictureDao.selectPictureById(id);
    }
}
