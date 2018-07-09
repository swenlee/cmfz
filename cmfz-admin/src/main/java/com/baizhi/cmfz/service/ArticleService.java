package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.List;

/**
 * Created by Lee on 2018/7/8.
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     * @return
     */
    public Integer addArticle(Article article);

    /**
     * 分页查询文章
     * @param begin 起始坐标
     * @param end 结束坐标
     * @return
     */
    public List<Article> queryArticlesOnPage(Integer begin, Integer end);

    /**
     * 查询所有文章的个数
     * @return
     */
    public Integer queryCount();

}
