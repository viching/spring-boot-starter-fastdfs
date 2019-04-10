package com.viching.fastdfs;

import com.viching.fastdfs.conn.*;
import com.viching.fastdfs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(VichingFdfsProperties.class)
public class VichingFdfsAutoConfiguration {

  @Autowired
  private VichingFdfsProperties properties;

  @Bean
  public PooledConnectionFactory pooledConnectionFactory() {
    PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
    pooledConnectionFactory.setSoTimeout(properties.getSoTimeout());
    pooledConnectionFactory.setConnectTimeout(properties.getConnectTimeout());
    return pooledConnectionFactory;
  }


  @Bean
  @ConfigurationProperties(prefix = "fdfs.pool")
  public ConnectionPoolConfig connectionPoolConfig() {
    ConnectionPoolConfig connectionPoolConfig = new ConnectionPoolConfig();
    return connectionPoolConfig;
  }

  @Bean
  public FdfsConnectionPool fdfsConnectionPool(PooledConnectionFactory pooledConnectionFactory,
      ConnectionPoolConfig connectionPoolConfig) {
    FdfsConnectionPool pool =  new FdfsConnectionPool(pooledConnectionFactory, connectionPoolConfig);
    return pool;
  }

  @Bean
  public TrackerConnectionManager trackerConnectionManager(FdfsConnectionPool fdfsConnectionPool) {
    return new TrackerConnectionManager(fdfsConnectionPool, properties.getTrackerList());
  }

  @Bean
  public TrackerClient trackerClient(TrackerConnectionManager trackerConnectionManager) {
    return new DefaultTrackerClient(trackerConnectionManager);
  }

  @Bean
  public ConnectionManager connectionManager(FdfsConnectionPool fdfsConnectionPool) {
    return new ConnectionManager(fdfsConnectionPool);
  }

  @Bean
  public FastFileStorageClient fastFileStorageClient(TrackerClient trackerClient,
      ConnectionManager connectionManager) {
    return new DefaultFastFileStorageClient(trackerClient, connectionManager);
  }
  
  @Bean
  public AppendFileStorageClient appendFileStorageClient(TrackerClient trackerClient,
      ConnectionManager connectionManager) {
    return new DefaultAppendFileStorageClient(trackerClient, connectionManager);
  }

}
