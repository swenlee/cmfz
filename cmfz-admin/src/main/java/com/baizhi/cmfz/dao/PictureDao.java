package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Lee on 2018/7/5.
 */
public interface PictureDao{
    /**
     * 查询所有图片的信息
     * @return
     */
    public List<Picture> selectAllPic(@Param("begin") Integer begin, @Param("end")Integer end);

    /**
     * 查询所有的图片数量
     * @return
     */
   public Integer selectCount();

    /**\
     * 添加图片
     * @param picture
     */
   public Integer insertPicture(Picture picture);

    /**
     * 根据ID删除数据库中一张照片
     * @param id 依据ID
     * @return
     */
    public Integer deletePictureById(String id);
    /**
     * 修改数据库中的照片数据
     * @param picture
     * @return
     */
    public Integer updatePicture(@Param("pic") Picture picture);

    /**
     * 根据ID查找数据库中的照片
     * @param id
     * @return
     */
    public Picture selectPictureById(String id);
}
