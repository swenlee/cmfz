package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.List;

/**
 * Created by Lee on 2018/7/8.
 */
public interface ArticleService {

    public Integer addArticle(Article article);


    public List<Article> queryArticlesOnPage(Integer begin, Integer end);

    public Integer queryCount();

}
