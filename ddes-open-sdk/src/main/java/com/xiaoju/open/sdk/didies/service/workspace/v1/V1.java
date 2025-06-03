package com.xiaoju.open.sdk.didies.service.workspace.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.CreateWorkplaceApiReply;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.CreateWorkplaceRequest;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.DeleteWorkplaceApiReply;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.DeleteWorkplaceRequest;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.UpdateWorkplaceApiReply;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.UpdateWorkplaceRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 地点新增
    * 说明  - 地址目前支持国内城市，cityid需要使用用车的城市接口获取；  param字段列表 | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | --- | --- | --- | --- | --- | | city_id | 职场所在城市id | int | Y | 职场所在城市id | | out_address_id | 地址所属城市id | string | N | 客户地址ID，最大64字符 | | address | 地址详细名称 | string | Y | 地址详细名称，最大100字符 | | lng | 经度 | string | Y | 经度 | | lat | 纬度 | string | Y | 纬度 | | is_workplace | 是否为职场 | int | N | 是否为职场，1是，0否，默认为否 | | point_range | 用车范围 | int | Y | 用车范围 100 到1500 枚举为100的整数倍 | | remark | 备注 | string | N | 备注，最大200字符 |
    * @param createWorkplaceRequest  (required)
    * @return CreateWorkplaceApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreateWorkplaceApiReply createWorkplace(CreateWorkplaceRequest createWorkplaceRequest) throws Exception {
        
        return doPost(createWorkplaceRequest, "/open-apis/v1/workplace/create", CreateWorkplaceApiReply.class, 0);
    }
    /**
    * 地点删除
    * param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | --- | --- | --- | --- | --- | | id | 滴滴地址ID | string | N | 客户ID或滴滴地址ID二选一，如果两个都有，则以滴滴ID为准 | | out_address_id | 客户地址ID | string | N |  |
    * @param deleteWorkplaceRequest  (required)
    * @return DeleteWorkplaceApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public DeleteWorkplaceApiReply deleteWorkplace(DeleteWorkplaceRequest deleteWorkplaceRequest) throws Exception {
        
        return doPost(deleteWorkplaceRequest, "/open-apis/v1/workplace/del", DeleteWorkplaceApiReply.class, 0);
    }
    /**
    * 地点修改
    * param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | --- | --- | --- | --- | --- | | id | 滴滴地址ID，客户ID或滴滴地址ID二选一，如果两个都有，则以滴滴ID为准 | string | N | 滴滴地址ID | | city_id | 职场所在城市id，职场所在城市id，仅限国内城市，滴滴网约车开城城市 | int | Y | 职场所在城市id | | out_address_id | 地址所属城市id，客户的内部的地址id（创建后不支持修改），最大64字符 | string | N | 地址所属城市id | | address | 称地址详细名称 最大100字符 | string | Y | 地址详细名称 | | lng | 经度 | string | Y | 经度 | | lat | 纬度 | string | Y | 纬度 | | is_workplace | 是否为职场，1是，0否，默认为否 | int | N | 是否为职场 | | point_range | 用车范围 100 到1500 枚举为100的整数倍 | int | Y | 用车范围 | | remark | 备注，最大200字符 | string | N | 备注 | 
    * @param updateWorkplaceRequest  (required)
    * @return UpdateWorkplaceApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateWorkplaceApiReply updateWorkplace(UpdateWorkplaceRequest updateWorkplaceRequest) throws Exception {
        
        return doPost(updateWorkplaceRequest, "/open-apis/v1/workplace/update", UpdateWorkplaceApiReply.class, 0);
    }
}

