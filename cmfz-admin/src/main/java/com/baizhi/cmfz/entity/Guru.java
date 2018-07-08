package com.baizhi.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * 上师表
 */
public class Guru implements Serializable {
  @Excel(name = "上师编号", width = 40.0)
  private String guruId;
  @Excel(name = "上师姓名", width = 40.0)
  private String guruName;
  @Excel(name = "图片路径", width = 40.0)
  private String guruPic;
  @Excel(name = "上师简介", width = 40.0)
  private String guruSummary; //简介
  @Excel(name = "上师头像", width = 40.0)
  private String guruPicName; //头像照片文件名
  public Guru() {
  }

  public Guru(String guruId, String guruName, String guruPic, String guruSummary, String guruPicName) {
    this.guruId = guruId;
    this.guruName = guruName;
    this.guruPic = guruPic;
    this.guruSummary = guruSummary;
    this.guruPicName = guruPicName;
  }

  @Override
  public String toString() {
    return "Guru{" +
            "guruId='" + guruId + '\'' +
            ", guruName='" + guruName + '\'' +
            ", guruPic='" + guruPic + '\'' +
            ", guruSummary='" + guruSummary + '\'' +
            ", guruPicName='" + guruPicName + '\'' +
            '}';
  }

  public String getGuruPicName() {
    return guruPicName;
  }

  public void setGuruPicName(String guruPicName) {
    this.guruPicName = guruPicName;
  }

  public String getGuruId() {
    return guruId;
  }

  public void setGuruId(String guruId) {
    this.guruId = guruId;
  }

  public String getGuruName() {
    return guruName;
  }

  public void setGuruName(String guruName) {
    this.guruName = guruName;
  }

  public String getGuruPic() {
    return guruPic;
  }

  public void setGuruPic(String guruPic) {
    this.guruPic = guruPic;
  }

  public String getGuruSummary() {
    return guruSummary;
  }

  public void setGuruSummary(String guruSummary) {
    this.guruSummary = guruSummary;
  }
}
