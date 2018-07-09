package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lee on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceIpml implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public Integer addArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public List<Article> queryArticlesOnPage(Integer begin, Integer end) {
        return articleDao.selectArticlesOnPage(begin, end);
    }

    @Override
    public Integer queryCount() {
        return articleDao.selectCount();
    }
}
