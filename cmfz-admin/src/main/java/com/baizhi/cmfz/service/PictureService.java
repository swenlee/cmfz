package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * Created by Lee on 2018/7/5.
 */
public interface PictureService {
    /**
     * 查询所有图片
     * @return
     */
    public Map<String, Object> queryAll(Integer page, Integer rows);

    /**
     * 添加图片信息
     * @param picture
     * @return
     */
    public Integer addPicture(Picture picture);

    public Picture queryPictureById(String id);

    public Integer removePictureById(String id);

    public Integer modifyPicture(Picture picture);
}
