package com.baizhi.cmfz.entity;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{

  private String articleId;
  private String guruId;
  private String introduction;
  @JSONField(format="yyyy-MM-dd hh:mm:ss")
  private Date date;
  private String mainPic;
  private String articleTitle;
  private String articleStatus;

  public String getArticleId() {
    return articleId;
  }

  public void setArticleId(String articleId) {
    this.articleId = articleId;
  }

  public String getGuruId() {
    return guruId;
  }

  public void setGuruId(String guruId) {
    this.guruId = guruId;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getMainPic() {
    return mainPic;
  }

  public void setMainPic(String mainPic) {
    this.mainPic = mainPic;
  }

  public String getArticleTitle() {
    return articleTitle;
  }

  public void setArticleTitle(String articleTitle) {
    this.articleTitle = articleTitle;
  }

  public String getArticleStatus() {
    return articleStatus;
  }

  public void setArticleStatus(String articleStatus) {
    this.articleStatus = articleStatus;
  }

  public Article() {
  }

  public Article(String articleId, String guruId, String introduction, Date date, String mainPic, String articleTitle, String articleStatus) {
    this.articleId = articleId;
    this.guruId = guruId;
    this.introduction = introduction;
    this.date = date;
    this.mainPic = mainPic;
    this.articleTitle = articleTitle;
    this.articleStatus = articleStatus;
  }

  @Override
  public String toString() {
    return "Article{" +
            "articleId='" + articleId + '\'' +
            ", guruId='" + guruId + '\'' +
            ", introduction='" + introduction + '\'' +
            ", date=" + date +
            ", mainPic='" + mainPic + '\'' +
            ", articleTitle='" + articleTitle + '\'' +
            ", articleStatus='" + articleStatus + '\'' +
            '}';
  }
}
