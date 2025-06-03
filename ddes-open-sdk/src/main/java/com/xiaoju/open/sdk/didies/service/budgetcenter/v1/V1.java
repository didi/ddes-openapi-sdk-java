package com.xiaoju.open.sdk.didies.service.budgetcenter.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.CreateBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.CreateBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.DelBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.DelBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.GetBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.GetBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.UpdateBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.UpdateBudgetCenterRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 部门或项目新增
    * 注意： * 部门数量上限是2000，如贵司超过2000个部门，请联系相应的对接同学添加白名单进行扩展; * 部门添加时，请不要并发操作，防止部门添加失败；  * 请求时无需中文转义；  说明  * 新建接口后，可以使用查询接口对齐信息;  * 建议保存新建之后返回的滴滴部门或项目的ID作为唯一主键，用于修改或删除的判断;
    * @param createBudgetCenterRequest  (required)
    * @return CreateBudgetCenterApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreateBudgetCenterApiReply createBudgetCenter(CreateBudgetCenterRequest createBudgetCenterRequest) throws Exception {
        
        return doPost(createBudgetCenterRequest, "/river/BudgetCenter/add", CreateBudgetCenterApiReply.class, 0);
    }
    /**
    * 部门或项目停用
    * 说明  * 停用接口后，可以使用查询接口对齐信息;  * 查询停用/删除的部门时，不返回;
    * @param delBudgetCenterRequest  (required)
    * @return DelBudgetCenterApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public DelBudgetCenterApiReply delBudgetCenter(DelBudgetCenterRequest delBudgetCenterRequest) throws Exception {
        
        return doPost(delBudgetCenterRequest, "/river/BudgetCenter/del", DelBudgetCenterApiReply.class, 0);
    }
    /**
    * 部门或项目查询
    * 说明： * 查询项目或部门在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息，只能查询有效的部门。需要查询全部的状态。没有启用接口，过期时间修改逻辑需要确认；
    * @param getBudgetCenterRequest  (required)
    * @return GetBudgetCenterApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBudgetCenterApiReply getBudgetCenter(GetBudgetCenterRequest getBudgetCenterRequest) throws Exception {
        return doGet(getBudgetCenterRequest, "/river/BudgetCenter/get", GetBudgetCenterApiReply.class, 0);
        
    }
    /**
    * 部门或项目修改
    * 说明  * 新建接口后，可以使用查询接口对齐信息;  * 建议保存新建之后返回的滴滴部门或项目的ID作为唯一主键，用于修改或删除的判断;
    * @param updateBudgetCenterRequest  (required)
    * @return UpdateBudgetCenterApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateBudgetCenterApiReply updateBudgetCenter(UpdateBudgetCenterRequest updateBudgetCenterRequest) throws Exception {
        
        return doPost(updateBudgetCenterRequest, "/river/BudgetCenter/edit", UpdateBudgetCenterApiReply.class, 0);
    }
}

