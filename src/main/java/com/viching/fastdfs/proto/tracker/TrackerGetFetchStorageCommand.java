package com.viching.fastdfs.proto.tracker;

import com.viching.fastdfs.domain.StorageNodeInfo;
import com.viching.fastdfs.proto.AbstractFdfsCommand;
import com.viching.fastdfs.proto.FdfsResponse;
import com.viching.fastdfs.proto.tracker.internal.TrackerGetFetchStorageRequest;

/**
 * 获取源服务器
 * 
 * @author tobato
 *
 */
public class TrackerGetFetchStorageCommand extends AbstractFdfsCommand<StorageNodeInfo> {

    public TrackerGetFetchStorageCommand(String groupName, String path, boolean toUpdate) {
        super.request = new TrackerGetFetchStorageRequest(groupName, path, toUpdate);
        super.response = new FdfsResponse<StorageNodeInfo>() {
            // default response
        };
    }

}
