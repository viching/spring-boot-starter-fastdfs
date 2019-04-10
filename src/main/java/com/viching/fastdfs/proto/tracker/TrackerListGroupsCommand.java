package com.viching.fastdfs.proto.tracker;

import com.viching.fastdfs.domain.GroupState;
import com.viching.fastdfs.proto.AbstractFdfsCommand;
import com.viching.fastdfs.proto.tracker.internal.TrackerListGroupsRequest;
import com.viching.fastdfs.proto.tracker.internal.TrackerListGroupsResponse;

import java.util.List;

/**
 * 列出组命令
 * 
 * @author tobato
 *
 */
public class TrackerListGroupsCommand extends AbstractFdfsCommand<List<GroupState>> {

    public TrackerListGroupsCommand() {
        super.request = new TrackerListGroupsRequest();
        super.response = new TrackerListGroupsResponse();
    }

}
