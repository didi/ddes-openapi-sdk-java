package com.xiaoju.open.sdk.didies.service.project.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.project.v1.model.*;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 查询项目下的人员关联信息
    * @param getProjectDetailRequest  (required)
    * @return GetProjectDetailApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetProjectDetailApiReply getProjectDetail(GetProjectDetailRequest getProjectDetailRequest) throws Exception {
        return doGet(getProjectDetailRequest, "/river/Project/detail", GetProjectDetailApiReply.class, 0);
    }
    /**
    * 查询项目外部出行人列表
    * @param outTravelerListRequest  (required)
    * @return OutTravelerListApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public OutTravelerListApiReply outTravelerList(OutTravelerListRequest outTravelerListRequest) throws Exception {
        return doGet(outTravelerListRequest, "/open-apis/v2/project/outTravelerList", OutTravelerListApiReply.class, 0);
    }
    /**
    * 绑定项目与人员关系
    * @param updateMemberRequest  (required)
    * @return UpdateMemberApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateMemberApiReply updateMember(UpdateMemberRequest updateMemberRequest) throws Exception {
        return doPost(updateMemberRequest, "/river/Project/updateMember", UpdateMemberApiReply.class, 0);
    }
    /**
    * 删除项目与人员关系
    * @param delMemberRequest  (required)
    * @return DelMemberApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public DelMemberApiReply delMember(DelMemberRequest delMemberRequest) throws Exception {
        return doPost(delMemberRequest, "/river/Project/delMember", DelMemberApiReply.class, 0);
    }
}
