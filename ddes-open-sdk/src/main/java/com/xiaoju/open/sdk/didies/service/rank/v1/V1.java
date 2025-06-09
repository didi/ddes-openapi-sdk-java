package com.xiaoju.open.sdk.didies.service.rank.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.CreateRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.CreateRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.DelRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.DelRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.ListRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.ListRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.UpdateRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.UpdateRankRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 职级新增
    * 说明 - 用于新增职级信息；  注意 - 公司职级总数限制 500 个;   param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 | | name | 职级名称 | string | Y | 最长 30 字符，只能输入汉字、字母、数字、下划线、连字符、空格、点、括号、加、减和等号 | 
    * @param createRankRequest  (required)
    * @return CreateRankApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreateRankApiReply createRank(CreateRankRequest createRankRequest) throws Exception {
        
        return doPost(createRankRequest, "/open-apis/v1/rank/create", CreateRankApiReply.class, 0);
    }
    /**
    * 职级删除
    * 说明 - 用于删除职级信息；  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | rank_id | 滴滴侧职级 ID | string | N | 滴滴侧职级 ID和外部职级编号二者之一必填 | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 | 
    * @param delRankRequest  (required)
    * @return DelRankApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public DelRankApiReply delRank(DelRankRequest delRankRequest) throws Exception {
        
        return doPost(delRankRequest, "/open-apis/v1/rank/del", DelRankApiReply.class, 0);
    }
    /**
    * 职级查询
    * 说明 - 用于查询职级的列表信息
    * @param listRankRequest  (required)
    * @return ListRankApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListRankApiReply listRank(ListRankRequest listRankRequest) throws Exception {
        return doGet(listRankRequest, "/river/Rank/getRanks", ListRankApiReply.class, 0);
        
    }
    /**
    * 职级修改
    * 说明 - 用于修改职级信息；  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | rank_id | 滴滴侧职级 ID | string | N | 滴滴侧职级 ID和外部职级编号二者之一必填 | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 | | name | 职级名称 | string | Y | 最长 30 字符，只能输入汉字、字母、数字、下划线、连字符、空格、点、括号、加、减和等号 |
    * @param updateRankRequest  (required)
    * @return UpdateRankApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateRankApiReply updateRank(UpdateRankRequest updateRankRequest) throws Exception {
        
        return doPost(updateRankRequest, "/open-apis/v1/rank/update", UpdateRankApiReply.class, 0);
    }
}

