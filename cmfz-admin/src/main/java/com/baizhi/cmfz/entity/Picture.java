package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图
 */
public class Picture implements Serializable {
  private String pictureId;
  private String picturePath;
  @JSONField(format = "yyyy-MM-dd : hh:mm:ss")
  @DateTimeFormat(style = "yyyy-MM-dd : hh:mm:ss")
  private Date pictureDate;
  private String pictureDescription;
  private String pictureStatus;

  public Picture() {
  }

  public Picture(String pictureId, String picturePath, Date pictureDate, String pictureDescription, String pictureStatus) {
    this.pictureId = pictureId;
    this.picturePath = picturePath;
    this.pictureDate = pictureDate;
    this.pictureDescription = pictureDescription;
    this.pictureStatus = pictureStatus;
  }

  @Override
  public String toString() {
    return "Picture{" +
            "pictureId='" + pictureId + '\'' +
            ", picturePath='" + picturePath + '\'' +
            ", pictureDate=" + pictureDate +
            ", pictureDescription='" + pictureDescription + '\'' +
            ", pictureStatus='" + pictureStatus + '\'' +
            '}';
  }

  public String getPictureId() {
    return pictureId;
  }

  public void setPictureId(String pictureId) {
    this.pictureId = pictureId;
  }

  public String getPicturePath() {
    return picturePath;
  }

  public void setPicturePath(String picturePath) {
    this.picturePath = picturePath;
  }

  public Date getPictureDate() {
    return pictureDate;
  }

  public void setPictureDate(Date pictureDate) {
    this.pictureDate = pictureDate;
  }

  public String getPictureDescription() {
    return pictureDescription;
  }

  public void setPictureDescription(String pictureDescription) {
    this.pictureDescription = pictureDescription;
  }

  public String getPictureStatus() {
    return pictureStatus;
  }

  public void setPictureStatus(String pictureStatus) {
    this.pictureStatus = pictureStatus;
  }
}
