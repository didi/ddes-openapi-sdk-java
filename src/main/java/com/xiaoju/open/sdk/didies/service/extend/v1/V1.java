package com.xiaoju.open.sdk.didies.service.extend.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.CreateExtendBatchApiReply;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.CreateExtendBatchRequest;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.ListExtendApiReply;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.ListExtendRequest;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.UpdateExtendStatusApiReply;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.UpdateExtendStatusRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 拓展信息批量创建
    * 注意： 拓展信息的批量接口目前只支持创建档案以及对应的子档案信息。 - 不支持修改父节点关联关系。  说明 建议的使用方式，档案root建立后，可以选择三种种数据结构：  1. 建立第一级子档案，父节点为空为一级。后续数据挂在二级子档案，推荐 2. 所有的数据按照一级子节点平铺，父节点都为空 3. 按照层级关系一次性批量同步。目前父子级关系无法变更  item_list字段列表 | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | --- | --- | --- | --- | --- | | parent_code | 子档案的父级子档案code，顶级部门父级不需要传 | string | N | 顶级部门父级不需要传 | | code | 子档案code，子档案code在同一个档案下不能重复，150字符以内 | string | Y | 子档案code在同一个档案下不能重复，150字符以内 | | name | 子档案名称，传了更新 &lt;br&gt; -不传不处理 &lt;br&gt; -传空字符串不处理 &lt;br&gt; -首次创建子档案时，name必传，如果没传或者传空字符串，子档案信息不全，不会创建对应的子档案 &lt;br&gt; -父级子档案在本次接口中创建，但是创建失败，子档案也会创建失败 &lt;br&gt; -父级子档案不合法（已经删除了），不存在，子档案也会创建失败，150字符以内 | string | N | 传了更新 &lt;br&gt; -不传不处理 &lt;br&gt; -传空字符串不处理 &lt;br&gt; -首次创建子档案时，name必传，如果没传或者传空字符串，子档案信息不全，不会创建对应的子档案 &lt;br&gt; -父级子档案在本次接口中创建，但是创建失败，子档案也会创建失败 &lt;br&gt; -父级子档案不合法（已经删除了），不存在，子档案也会创建失败，150字符以内 | 
    * @param createExtendBatchRequest  (required)
    * @return CreateExtendBatchApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreateExtendBatchApiReply createExtendBatch(CreateExtendBatchRequest createExtendBatchRequest) throws Exception {
        
        return doPost(createExtendBatchRequest, "/river/ExtendInfo/BatchSync", CreateExtendBatchApiReply.class, 0);
    }
    /**
    * 拓展信息查询
    * 
    * @param listExtendRequest  (required)
    * @return ListExtendApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListExtendApiReply listExtend(ListExtendRequest listExtendRequest) throws Exception {
        return doGet(listExtendRequest, "/river/ExtendInfo/Get", ListExtendApiReply.class, 0);
        
    }
    /**
    * 档案状态处理
    * 说明 - 用于处理档案的状态变更;  item_list字段列表： | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | --- | --- | --- | --- | --- | | code | 子档案code，子档案code在同一个档案下不能重复 | string | Y | 子档案code在同一个档案下不能重复 | | status | 子档案状态，3 数字3为删除 -子档案及以下子档案都会被删除，子档案只有删除，没有停用 | string | Y | 3 数字3为删除 -子档案及以下子档案都会被删除&lt;br&gt;子档案只有删除，没有停用 | 
    * @param updateExtendStatusRequest  (required)
    * @return UpdateExtendStatusApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateExtendStatusApiReply updateExtendStatus(UpdateExtendStatusRequest updateExtendStatusRequest) throws Exception {
        
        return doPost(updateExtendStatusRequest, "/river/ExtendInfo/Status", UpdateExtendStatusApiReply.class, 0);
    }
}

