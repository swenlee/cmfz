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

    /**
     * 通过id进行查询图片信息
     * @param id
     * @return
     */
    public Picture queryPictureById(String id);

    /**
     * 通过id进行图片的移除
     * @param id
     * @return
     */
    public Integer removePictureById(String id);

    /**
     * 修改图片的信息
     * @param picture
     * @return
     */
    public Integer modifyPicture(Picture picture);
}
