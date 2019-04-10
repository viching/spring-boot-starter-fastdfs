package com.viching.fastdfs;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "fdfs")
public class VichingFdfsProperties {

  /** 读取时间 */
  private int soTimeout = 1000;
  /** 连接超时时间 */
  private int connectTimeout = 1000;

  /** Tracker 地址列表 */
  private List<String> trackerList = new ArrayList<>();

  public int getSoTimeout() {
    return soTimeout;
  }

  public void setSoTimeout(int soTimeout) {
    this.soTimeout = soTimeout;
  }

  public int getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public List<String> getTrackerList() {
    return trackerList;
  }

  public void setTrackerList(List<String> trackerList) {
    this.trackerList = trackerList;
  }

  
}
