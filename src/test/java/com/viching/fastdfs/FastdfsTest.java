package com.viching.fastdfs;

import com.viching.fastdfs.domain.StorePath;
import com.viching.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppTest.class}, properties = "classpath:application.yml")
public class FastdfsTest {

    @Autowired
    private FastFileStorageClient storageClient;

    @Test
    public void test1() throws IOException {
        File file = new File("C:\\Users\\SD\\Desktop\\update.js");
        StorePath path = null;
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            path = storageClient.uploadFile(is, file.length(), getSuffix(file.getName()), Collections.EMPTY_SET);
        }
        if (path == null) {
            System.out.println("update fail");
        } else {
            System.out.println("update result: " + path.getFullPath());
        }
    }

    /**
     * 获取上传文件的后缀，比如：。jpg
     *
     * @param originalFilename
     * @return
     * @create_time 2015年3月25日 下午8:27:27
     */
    public String getSuffix(String originalFilename) {
        String[] arr = originalFilename.split("\\.");
        int num = arr.length - 1;
        return arr[num];
    }
}
