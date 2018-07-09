package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Lee on 2018/7/8.
 */
public interface ArticleDao {
    public Integer insertArticle(Article article);


    public List<Article> selectArticlesOnPage(@Param("begin")Integer begin, @Param("end") Integer end);

    public Integer selectCount();
}
