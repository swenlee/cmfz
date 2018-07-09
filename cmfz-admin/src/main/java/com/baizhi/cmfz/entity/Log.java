package com.baizhi.cmfz.entity;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Log {

  private String logId;
  private String user;
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date logDate;
  private String resource;
  private String action;
  private String message;
  private String result;

  public String getLogId() {
    return logId;
  }

  public void setLogId(String logId) {
    this.logId = logId;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Date getLogDate() {
    return logDate;
  }

  public void setLogDate(Date logDate) {
    this.logDate = logDate;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Log() {
  }

  public Log(String logId, String user, Date logDate, String resource, String action, String message, String result) {
    this.logId = logId;
    this.user = user;
    this.logDate = logDate;
    this.resource = resource;
    this.action = action;
    this.message = message;
    this.result = result;
  }

  @Override
  public String toString() {
    return "Log{" +
            "logId='" + logId + '\'' +
            ", user='" + user + '\'' +
            ", logDate=" + logDate +
            ", resource='" + resource + '\'' +
            ", action='" + action + '\'' +
            ", message='" + message + '\'' +
            ", result='" + result + '\'' +
            '}';
  }
}
