# FastDFS Java Client Springboot Starter

项目基于:
> https://github.com/tobato/FastDFS_Client  
> https://github.com/luhuiguo/fastdfs-client

整合 **fastdfs-client** 和 **fastdfs-spring-boot-starter**

## Spring Boot-based project

```xml
<dependency>
    <groupId>com.viching.fastdfs</groupId>
    <artifactId>spring-boot-starter-fastdfs</artifactId>
    <version>0.0.1</version>
</dependency>
```

```yml
fdfs:
  connect-timeout: 2000
  so-timeout: 3000
  tracker-list:
    - 192.168.1.111:22122
    - 192.168.1.111:22122
    
```

```java
@Autowired
private FastFileStorageClient storageClient;
```
