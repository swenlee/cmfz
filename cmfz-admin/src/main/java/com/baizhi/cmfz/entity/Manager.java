package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Manager implements Serializable {
  private String mgrId;
  private String mgrName;
  private String mgrPwd;
  private String mgrSalt;
  private Long mgrStatus;

  public Manager() {
  }

  public Manager(String mgrId, String mgrName, String mgrPwd, String mgrSalt, Long mgrStatus) {
    this.mgrId = mgrId;
    this.mgrName = mgrName;
    this.mgrPwd = mgrPwd;
    this.mgrSalt = mgrSalt;
    this.mgrStatus = mgrStatus;
  }

  @Override
  public String toString() {
    return "Manager{" +
            "mgrId='" + mgrId + '\'' +
            ", mgrName='" + mgrName + '\'' +
            ", mgrPwd='" + mgrPwd + '\'' +
            ", mgrSalt='" + mgrSalt + '\'' +
            ", mgrStatus=" + mgrStatus +
            '}';
  }

  public String getMgrId() {
    return mgrId;
  }

  public void setMgrId(String mgrId) {
    this.mgrId = mgrId;
  }

  public String getMgrName() {
    return mgrName;
  }

  public void setMgrName(String mgrName) {
    this.mgrName = mgrName;
  }

  public String getMgrPwd() {
    return mgrPwd;
  }

  public void setMgrPwd(String mgrPwd) {
    this.mgrPwd = mgrPwd;
  }

  public String getMgrSalt() {
    return mgrSalt;
  }

  public void setMgrSalt(String mgrSalt) {
    this.mgrSalt = mgrSalt;
  }

  public Long getMgrStatus() {
    return mgrStatus;
  }

  public void setMgrStatus(Long mgrStatus) {
    this.mgrStatus = mgrStatus;
  }
}
