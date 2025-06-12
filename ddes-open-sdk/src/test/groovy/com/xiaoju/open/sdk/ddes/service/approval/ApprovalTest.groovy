package com.xiaoju.open.sdk.ddes.service.approval

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.approval.Approval
import com.xiaoju.open.sdk.didies.service.approval.enums.*
import com.xiaoju.open.sdk.didies.service.approval.v1.model.*
import com.xiaoju.open.sdk.didies.service.member.enums.MemberTypeEnum
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Approval
 */
@Ignore
class ApprovalTest extends Specification {

    private Approval api

    def setup() {
        Config config =  new Config()
                .setClientId("your_client_id")
                .setClientSecret("your_client_secret")
                .setSignKey("your_sign_key");
        ApiClient client = new ApiClient(config)
        api = client.approval()
    }

    /**
     * 外部审批处理接口
     *
     * 说明: 使用个转企审批时，制度入口下，有员工个人支付费用，支付完成后，可以发起接口申请和审批结果同步; - 使用接口需要联系对应的业务同学开通对应的权限;
     */
    def approvalPassTest() {
        ApprovalPassRequest approvalPassRequest = ApprovalPassRequest.builder()
                .companyId("替换成自己的companyId")
                .objectType(ApprovalObjectTypeEnum.ORDER.getCode())
                .objectId(1125965135320697)
                .objectApprovalType(ApprovalObjectApprovalTypeEnum.PERSONAL_TO_ENTERPRISE.getCode())
                .isPass(ApprovalIsPassTypeEnum.PASS.getCode())
                .build()

        ApprovalPassApiReply response = api.v1().approvalPass(approvalPassRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

    /**
     * 取消申请单
     *
     * 注意  1. 支持所有审批单的取消，取消的逻辑为：API对接的审批单有四种状态：未开始、已开始、已结束、已取消，其中已结束和已取消的状态是不支持取消的。 2. 机酒火判断是否有关联订单（所有订单状态），差旅单中机酒火只要下单，审批通过、驳回或者取消，都不可以取消差旅单 ；差旅单中用车有进行中、未支付的订单，不可取消；仅用车订单已支付或已取消 可操作取消申请单。 3. 用车申请单中，有进行中、未支付的订单，不可取消； 4. is_force参数为1，并且配置强制取消白名单的公司，可以强制取消，不进行订单的校验 5. 强制取消：取消前的订单不受影响；待支付订单依据下单时的状态进行支付鉴权；取消后无法再产生新订单；出票中的也允许取消；
     */
    def cancelApprovalTest() {
        CancelApprovalRequest cancelApprovalRequest = CancelApprovalRequest.builder()
                .companyId("替换成自己的companyId")
                .approvalId("1125966918712513")
                .isForce(1)
                .build()
        CancelApprovalApiReply response = api.v1().cancelApproval(cancelApprovalRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

    /**
     * 创建[行前审批-按日期按次数]申请单(行前申请单)
     *
     * 该接口用于创建出行审批单，创建成功后会立即在企业APP上显示审批单信息；(申批单类型：1:差旅单；2: 行前审批-按次数；3: 行前审批-按日期)  ### 注意  **城市**  1. 创建审批单时：若传递的城市ID为县级市，自动替换为对应的地级市，当传递的城市ID与城市名称不一致时，以城市ID为准，替换为城市ID对应的正确城市名称； 2. 城市 ID 错误；创建申请单成功，但是申请单上城市不可用 3. 不传城市 ID；会根据城市名称模糊匹配，如果匹配到多条，默认使用第一条 4. 所有用车出发地城市和目的地城市参数都应传入城市级别id（当用车出发地城市和目的地城市级别为区县时，应该传入对应所属地级市城市id、区县名称） 5. 当差旅制度中，出差城市配置为无需员工填写时，出发地、目的地城市传空  **travel_detail**  1. 目前每个行程的开始日期、结束日期，依赖于travel_detail中的start_date、end_date 2. 为出发地城市创建【送机】和【市内用车】的用车规则。第一个行程的出发地城市无【市内用车】 3. 为目的地城市创建【接机】和【市内用车】的用车规则。最后一个行程的目的地城市的【市内用车】依赖于end_city_rule 4. trip中城市行数量限制40个  **passenger_list** 1. 出行人限制：20 个人 2. 会议管控：40个人  **out_approval_id**  1. 唯一性校验：company_id+approval_type+申请人维度  **代订制度使用**  1. 代订使用的制度无限制，所有差旅制度都可以，只用来使用差标。  ### 说明  1. 申请单新增的 &#x60;budget_center_list&#x60; 字段，用于多成本中心字段。支持 9 个字段。 2. &#x60;budget_center_id&#x60;，&#x60;name&#x60;，&#x60;out_budget_id&#x60;，&#x60;extend_field_list&#x60; 四个字段与 &#x60;budget_center_list&#x60; 不可以同时使用。 3. 历史客户可以使用历史 4 个字段可以兼容映射到新字段处理使用多成本中心。需要甲子开关切换多成本中心功能。 4. 新建取值优先级：最外层 &#x60;budget_center_list&#x60; 大于 人维度 &#x60;budget_center_list&#x60; 大于 &#x60;budget_center_id&#x60;，&#x60;name&#x60;，&#x60;out_budget_id&#x60;，&#x60;extend_field_list&#x60;  **序号 1 字段**  当 &#x60;sequence &#x3D; 1&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id | budget_center_id | | value | name | |  | code | |  | out_budget_id |  **序号 2 字段**  当 &#x60;sequence &#x3D; 2&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_01 | |  | code |  **序号 3 字段**  当 &#x60;sequence &#x3D; 3&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_02 | |  | code |  **序号 4 字段**  当 &#x60;sequence &#x3D; 4&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_03 | |  | code | 
     */
    def createBusinessByDateApprovalTest() {
        CreateApprovalBusinessByDateRequest createApprovalBusinessByDateRequest = CreateApprovalBusinessByDateRequest.builder()
                .companyId("替换成自己的companyId")
                .approvalType(ApprovalTypeEnum.PRE_TRIP_BY_DATE.getCode())
                .outApprovalId("didi-sdk-test")
                .regulationId("1125927807992439")
                .budgetCenterId("1125950150116339")
                .reason("didi-sdk-test")
                .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
                .businessTripDetailObj(BusinessTripDetailByDate.builder().startTime("2024-12-23").endTime("2024-12-30").tripAmount(70882).perorderMoneyQuota(70882).build())
                .memberType(MemberTypeEnum.PHONE.getCode())
                .phone("11100022245")
                .passengerListObj([TripPassenger.builder().passengerType(0).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).passengerPhone("11100022245").build(), TripPassenger.builder().passengerType(0).passengerName("沈x").memberType(MemberTypeEnum.PHONE.getCode()).passengerPhone("00016244610").build()])
                .executiveRegulationType(0)
                .executiveRegulationId("1125950150116339")
                .executiveRegulationMemberType(MemberTypeEnum.PHONE.getCode())
                .executiveRegulationMember("11100022245")
                .build()
        CreateApprovalApiReply response = api.v1().createBusinessByDateApproval(createApprovalBusinessByDateRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 创建[行前审批-按次数]申请单(行前申请单)
     *
     * 该接口用于创建出行审批单，创建成功后会立即在企业APP上显示审批单信息；(申批单类型：1:差旅单；2: 行前审批-按次数；3: 行前审批-按日期)  ### 注意  **城市**  1. 创建审批单时：若传递的城市ID为县级市，自动替换为对应的地级市，当传递的城市ID与城市名称不一致时，以城市ID为准，替换为城市ID对应的正确城市名称； 2. 城市 ID 错误；创建申请单成功，但是申请单上城市不可用 3. 不传城市 ID；会根据城市名称模糊匹配，如果匹配到多条，默认使用第一条 4. 所有用车出发地城市和目的地城市参数都应传入城市级别id（当用车出发地城市和目的地城市级别为区县时，应该传入对应所属地级市城市id、区县名称） 5. 当差旅制度中，出差城市配置为无需员工填写时，出发地、目的地城市传空  **travel_detail**  1. 目前每个行程的开始日期、结束日期，依赖于travel_detail中的start_date、end_date 2. 为出发地城市创建【送机】和【市内用车】的用车规则。第一个行程的出发地城市无【市内用车】 3. 为目的地城市创建【接机】和【市内用车】的用车规则。最后一个行程的目的地城市的【市内用车】依赖于end_city_rule 4. trip中城市行数量限制40个  **passenger_list** 1. 出行人限制：20 个人 2. 会议管控：40个人  **out_approval_id**  1. 唯一性校验：company_id+approval_type+申请人维度  **代订制度使用**  1. 代订使用的制度无限制，所有差旅制度都可以，只用来使用差标。  ### 说明  1. 申请单新增的 &#x60;budget_center_list&#x60; 字段，用于多成本中心字段。支持 9 个字段。 2. &#x60;budget_center_id&#x60;，&#x60;name&#x60;，&#x60;out_budget_id&#x60;，&#x60;extend_field_list&#x60; 四个字段与 &#x60;budget_center_list&#x60; 不可以同时使用。 3. 历史客户可以使用历史 4 个字段可以兼容映射到新字段处理使用多成本中心。需要甲子开关切换多成本中心功能。 4. 新建取值优先级：最外层 &#x60;budget_center_list&#x60; 大于 人维度 &#x60;budget_center_list&#x60; 大于 &#x60;budget_center_id&#x60;，&#x60;name&#x60;，&#x60;out_budget_id&#x60;，&#x60;extend_field_list&#x60;  **序号 1 字段**  当 &#x60;sequence &#x3D; 1&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id | budget_center_id | | value | name | |  | code | |  | out_budget_id |  **序号 2 字段**  当 &#x60;sequence &#x3D; 2&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_01 | |  | code |  **序号 3 字段**  当 &#x60;sequence &#x3D; 3&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_02 | |  | code |  **序号 4 字段**  当 &#x60;sequence &#x3D; 4&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_03 | |  | code | 
     */
    def createBusinessByTimesApprovalTest() {
        CreateApprovalBusinessByTimesRequest createApprovalRequest = CreateApprovalBusinessByTimesRequest.builder()
                .companyId("替换成自己的companyId")
                .approvalType(ApprovalTypeEnum.PRE_TRIP_BY_TIMES.getCode())
                .outApprovalId("didi-sdk-test-by_times")
                .regulationId("1125928451544592")
                .budgetCenterId("1125950150116339")
                .reason("didi-sdk-test")
                .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
                .businessTripDetailObj(BusinessTripDetailByTimes.builder().startTime("2024-12-23").endTime("2024-12-30").tripTimes(2).build())
                .memberType(MemberTypeEnum.PHONE.getCode())
                .phone("11100022245")
                .passengerListObj([TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build(),
                                   TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("沈x").memberType(MemberTypeEnum.PHONE.getCode()).build()]).build()
        CreateApprovalApiReply response = api.v1().createBusinessByTimesApproval(createApprovalRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 创建[差旅]申请单(行前申请单)
     *
     * 该接口用于创建出行审批单，创建成功后会立即在企业APP上显示审批单信息；(申批单类型：1:差旅单；2: 行前审批-按次数；3: 行前审批-按日期)  ### 注意  **城市**  1. 创建审批单时：若传递的城市ID为县级市，自动替换为对应的地级市，当传递的城市ID与城市名称不一致时，以城市ID为准，替换为城市ID对应的正确城市名称； 2. 城市 ID 错误；创建申请单成功，但是申请单上城市不可用 3. 不传城市 ID；会根据城市名称模糊匹配，如果匹配到多条，默认使用第一条 4. 所有用车出发地城市和目的地城市参数都应传入城市级别id（当用车出发地城市和目的地城市级别为区县时，应该传入对应所属地级市城市id、区县名称） 5. 当差旅制度中，出差城市配置为无需员工填写时，出发地、目的地城市传空  **travel_detail**  1. 目前每个行程的开始日期、结束日期，依赖于travel_detail中的start_date、end_date 2. 为出发地城市创建【送机】和【市内用车】的用车规则。第一个行程的出发地城市无【市内用车】 3. 为目的地城市创建【接机】和【市内用车】的用车规则。最后一个行程的目的地城市的【市内用车】依赖于end_city_rule 4. trip中城市行数量限制40个  **passenger_list** 1. 出行人限制：20 个人 2. 会议管控：40个人  **out_approval_id**  1. 唯一性校验：company_id+approval_type+申请人维度  **代订制度使用**  1. 代订使用的制度无限制，所有差旅制度都可以，只用来使用差标。  ### 说明  1. 申请单新增的 &#x60;budget_center_list&#x60; 字段，用于多成本中心字段。支持 9 个字段。 2. &#x60;budget_center_id&#x60;，&#x60;name&#x60;，&#x60;out_budget_id&#x60;，&#x60;extend_field_list&#x60; 四个字段与 &#x60;budget_center_list&#x60; 不可以同时使用。 3. 历史客户可以使用历史 4 个字段可以兼容映射到新字段处理使用多成本中心。需要甲子开关切换多成本中心功能。 4. 新建取值优先级：最外层 &#x60;budget_center_list&#x60; 大于 人维度 &#x60;budget_center_list&#x60; 大于 &#x60;budget_center_id&#x60;，&#x60;name&#x60;，&#x60;out_budget_id&#x60;，&#x60;extend_field_list&#x60;  **序号 1 字段**  当 &#x60;sequence &#x3D; 1&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id | budget_center_id | | value | name | |  | code | |  | out_budget_id |  **序号 2 字段**  当 &#x60;sequence &#x3D; 2&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_01 | |  | code |  **序号 3 字段**  当 &#x60;sequence &#x3D; 3&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_02 | |  | code |  **序号 4 字段**  当 &#x60;sequence &#x3D; 4&#x60; 时：  | 字段 | 历史字段 | | ---- | ---- | | id |  | | value | extend_field_03 | |  | code | 
     */
    def createTravelApprovalTest() {
        CreateApprovalRequest createApprovalRequest = CreateApprovalRequest.builder()
                .companyId("替换成自己的companyId")
                .approvalType(ApprovalTypeEnum.TRAVEL.getCode())
                .regulationId("1125937551844010")
                .outApprovalId("202504230002-sdk-test")
                .reason("sdk-test")
                .travelDetailObj(TravelDetail.builder()
                        .startDate("2025-04-21")
                        .endDate("2025-05-21")
                        .trips([Trip.builder().departureCity("北京市").departureCityId(1).startDate("2025-04-21").endDate("2025-05-21").tripType("1,2").toCitys([TravelCity.builder().id(17).name("成都市").build()]).build()])
                        .startCityRule(ApprovalCityRuleEnum.YES.getCode())
                        .endCityRule(ApprovalCityRuleEnum.YES.getCode())
                        .build())
                .memberType(MemberTypeEnum.PHONE.getCode())
                .phone("00016213494")
                .passengerListObj([TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build(),
                                   TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("李x").memberType(MemberTypeEnum.PHONE.getCode()).build(),
                                   TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("邓x").memberType(MemberTypeEnum.PHONE.getCode()).build()])
                .executiveRegulationType(ApprovalExecutiveRegulationTypeEnum.EXECUTIVE_APPLICATION.getCode())
                .executiveRegulationId("1125937551844010")
                .executiveRegulationMemberType(MemberTypeEnum.PHONE.getCode())
                .executiveRegulationMember("00016213494")
                .build()

        CreateApprovalApiReply response = api.v1().createTravelApproval(createApprovalRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 审批单查询订单（用车）
     *
     * 说明： 行后授权可以使用通知接口收到审批单号查询用车的订单信息用作外部的审批信息;
     */
    def listApprovalOrderTest() {
        ListApprovalOrderRequest listApprovalOrderRequest = ListApprovalOrderRequest.builder()
                .companyId("替换成自己的companyId")
                .offset(0)
                .length(1)
                .approvalId("1125966918712513")
                .build()
        ListApprovalOrderApiReply response = api.v1().listApprovalOrder(listApprovalOrderRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 修改申请单(行前申请单)
     *
     * 修改申请单
     */
    def updateApprovalTest() {
        UpdateApprovalRequest updateApprovalRequest = UpdateApprovalRequest.builder()
                .companyId("替换成自己的companyId").approvalType(ApprovalTypeEnum.TRAVEL.getCode())
                .outApprovalId("202504230002-sdk-test")
                .reason("sdk-test-test-update")
                .travelDetailObj(TravelDetail.builder()
                        .startDate("2025-04-21")
                        .endDate("2025-05-21")
                        .trips([Trip.builder().departureCity("北京市").departureCityId(1).startDate("2025-04-21").endDate("2025-05-21").tripType("1,2").toCitys([TravelCity.builder().id(17).name("成都市").build()]).build()])
                        .startCityRule(ApprovalCityRuleEnum.YES.getCode())
                        .endCityRule(ApprovalCityRuleEnum.YES.getCode())
                        .build())
                .passengerListObj([TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build(),
                                   TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("李x").memberType(MemberTypeEnum.PHONE.getCode()).build(),
                                   TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("邓x").memberType(MemberTypeEnum.PHONE.getCode()).build()])
                .build()

        UpdateApprovalApiReply response = api.v1().updateApproval(updateApprovalRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 修改[用车按日期]申请单(行前申请单)
     *
     * 修改用车按日期申请单
     */
    def updateBusinessByDateApprovalTest() {
        UpdateApprovalBusinessByDateRequest updateApprovalBusinessByDateRequest = UpdateApprovalBusinessByDateRequest.builder()
                .companyId("替换成自己的companyId").approvalType(ApprovalTypeEnum.PRE_TRIP_BY_DATE.getCode())
                .outApprovalId("didi-sdk-test")
                .budgetCenterId("1125950150116339")
                .reason("测试更新用车按日期申请单")
                .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
                .businessTripDetailObj(BusinessTripDetailByDate.builder().startTime("2024-12-23").endTime("2024-12-30").tripAmount(70882).perorderMoneyQuota(70882).build())
                .passengerListObj([TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build(),
                                   TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("李x").memberType(MemberTypeEnum.PHONE.getCode()).build()]).build()

        UpdateApprovalApiReply response = api.v1().updateBusinessByDateApproval(updateApprovalBusinessByDateRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 修改[用车按次数]申请单(行前申请单)
     *
     * 修改按次数申请单
     */
    def updateBusinessByTimesApprovalTest() {
        UpdateApprovalBusinessByTimesRequest updateApprovalBusinessByTimesRequest = UpdateApprovalBusinessByTimesRequest.builder()
                .companyId("替换成自己的companyId").approvalType(ApprovalTypeEnum.PRE_TRIP_BY_TIMES.getCode())
                .outApprovalId("didi-sdk-test-by_times")
                .budgetCenterId("1125950150116339")
                .reason("测试修改按次数")
                .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
                .businessTripDetailObj(BusinessTripDetailByTimes.builder().startTime("2024-12-23").endTime("2024-12-30").tripTimes(2).build())
                .passengerListObj([TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build()])
                .build()

        UpdateApprovalApiReply response = api.v1().updateBusinessByTimesApproval(updateApprovalBusinessByTimesRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

    /**
     * 申请单详情接口
     *
     * 申请单详情接口
     */
    def getApprovalDetailTest() {
        GetApprovalDetailRequest getApprovalDetailRequest = GetApprovalDetailRequest.builder()
                .companyId("替换成自己的companyId")
                .approvalId("1125966918712513")
                .build()
        GetApprovalDetailApiReply response = api.v1().getApprovalDetail(getApprovalDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

}