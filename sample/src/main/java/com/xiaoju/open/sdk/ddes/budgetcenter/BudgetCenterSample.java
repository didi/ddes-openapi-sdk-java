package com.xiaoju.open.sdk.ddes.budgetcenter;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.budgetcenter.enums.BudgetCycleEnum;
import com.xiaoju.open.sdk.didies.service.budgetcenter.enums.BudgetTypeEnum;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.CreateBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.CreateBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.DelBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.DelBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.GetBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.GetBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.UpdateBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.UpdateBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.order.enums.BudgetCenterTypeEnum;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class BudgetCenterSample {

  public static void main(String[] args) {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);

  }


  /**
   * 部门或项目新增
   * <p>
   * 注意： * 部门数量上限是2000，如贵司超过2000个部门，请联系相应的对接同学添加白名单进行扩展; * 部门添加时，请不要并发操作，防止部门添加失败；  * 请求时无需中文转义；  说明  * 新建接口后，可以使用查询接口对齐信息;  *
   * 建议保存新建之后返回的滴滴部门或项目的ID作为唯一主键，用于修改或删除的判断;
   */
  public static void createBudgetCenterTest(ApiClient client) throws Exception {
    CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
        .companyId("替换成自己的companyId")
        .name("自定义")
        .type(BudgetCenterTypeEnum.DEPARTMENT.getCode())
        .budgetCycle(BudgetCycleEnum.NONE.getCode())
        .totalQuota("0")
        .outBudgetId("0")
        .build();
    CreateBudgetCenterApiReply response = client.budgetcenter().v1().createBudgetCenter(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("billConfirmTest end");
  }

  /**
   * 部门或项目停用
   * <p>
   * 说明  * 停用接口后，可以使用查询接口对齐信息;  * 查询停用/删除的部门时，不返回;
   */
  public static void delBudgetCenterTest(ApiClient client) throws Exception {
    DelBudgetCenterRequest request = DelBudgetCenterRequest.builder()
        .companyId("替换成自己的companyId")
        .id("1125966620632586")
        .build();

    DelBudgetCenterApiReply response = client.budgetcenter().v1().delBudgetCenter(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("billConfirmTest end");
  }

  /**
   * 部门或项目查询
   * <p>
   * 说明： * 查询项目或部门在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息，只能查询有效的部门。需要查询全部的状态。没有启用接口，过期时间修改逻辑需要确认；
   */
  public static void getBudgetCenterTest(ApiClient client) throws Exception {
    GetBudgetCenterRequest request = GetBudgetCenterRequest.builder()
        .companyId("替换成自己的companyId")
        .offset(0)
        .length(1)
        .build();
    GetBudgetCenterApiReply response = client.budgetcenter().v1().getBudgetCenter(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("billConfirmTest end");
  }

  /**
   * 部门或项目修改
   * <p>
   * 说明  * 新建接口后，可以使用查询接口对齐信息;  * 建议保存新建之后返回的滴滴部门或项目的ID作为唯一主键，用于修改或删除的判断;
   */
  public static void updateBudgetCenterTest(ApiClient client) throws Exception {
    UpdateBudgetCenterRequest request = UpdateBudgetCenterRequest.builder()
        .companyId("替换成自己的companyId")
        .name("自定义")
        .type(BudgetTypeEnum.DEPARTMENT.getCode())
        .build();
    UpdateBudgetCenterApiReply response = client.budgetcenter().v1().updateBudgetCenter(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("billConfirmTest end");
  }
}
