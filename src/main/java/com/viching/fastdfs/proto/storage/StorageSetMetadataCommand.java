package com.viching.fastdfs.proto.storage;

import com.viching.fastdfs.domain.MetaData;
import com.viching.fastdfs.proto.AbstractFdfsCommand;
import com.viching.fastdfs.proto.FdfsResponse;
import com.viching.fastdfs.proto.storage.enums.StorageMetdataSetType;
import com.viching.fastdfs.proto.storage.internal.StorageSetMetadataRequest;

import java.util.Set;

/**
 * 设置文件标签
 * 
 * @author tobato
 *
 */
public class StorageSetMetadataCommand extends AbstractFdfsCommand<Void> {

    /**
     * 设置文件标签(元数据)
     * 
     * @param groupName
     * @param path
     * @param metaDataSet
     * @param type
     */
    public StorageSetMetadataCommand(String groupName, String path, Set<MetaData> metaDataSet,
            StorageMetdataSetType type) {
        this.request = new StorageSetMetadataRequest(groupName, path, metaDataSet, type);
        // 输出响应
        this.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
