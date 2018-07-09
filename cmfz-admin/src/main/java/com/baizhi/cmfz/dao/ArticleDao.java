package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Lee on 2018/7/8.
 */
public interface ArticleDao {
    /**
     * 向数据库中插入一条数据
     * @param article
     * @return
     */
    public Integer insertArticle(Article article);

    /**
     * 通过分页进行数据的查询
     * @param begin 开始坐标
     * @param end 结束坐标
     * @return
     */
    public List<Article> selectArticlesOnPage(@Param("begin")Integer begin, @Param("end") Integer end);

    /**
     * 查询文章的数量S
     * @return
     */
    public Integer selectCount();
}
