package com.xiaoju.open.sdk.didies.replay

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptRequest
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderRequest
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ApprovalPassRequest
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CancelApprovalRequest
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalBusinessByDateRequest
import com.xiaoju.open.sdk.didies.service.approval.v1.model.GetApprovalDetailRequest
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ListApprovalOrderRequest
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalBusinessByDateRequest
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfWangYCRequest
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillStructureRequest
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfWangYCRequest
import com.xiaoju.open.sdk.didies.service.bill.v1.model.ListBillRequest
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.CreateBudgetCenterRequest
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.DelBudgetCenterRequest
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.GetBudgetCenterRequest
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.UpdateBudgetCenterRequest
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCarCityRequest
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityRequest
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCountryRequest
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListTrainCityRequest
import com.xiaoju.open.sdk.didies.service.extend.v1.model.CreateExtendBatchRequest
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.CreateLegalEntityRequest
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.GetLegalEntityRequest
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.UpdateLegalEntityRequest
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrRequest
import com.xiaoju.open.sdk.didies.service.member.v1.model.CreateMemberRequest
import com.xiaoju.open.sdk.didies.service.member.v1.model.DelMemberRequest
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberDetailRequest
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberQuotaRequest
import com.xiaoju.open.sdk.didies.service.member.v1.model.ListMemberRequest
import com.xiaoju.open.sdk.didies.service.member.v1.model.UpdateMemberRequest
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetCarOrderDetailRequest
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetOrderRequest
import com.xiaoju.open.sdk.didies.service.order.v1.model.ListOrderRequest
import com.xiaoju.open.sdk.didies.service.rank.v1.model.CreateRankRequest
import com.xiaoju.open.sdk.didies.service.rank.v1.model.ListRankRequest
import com.xiaoju.open.sdk.didies.service.rank.v1.model.UpdateRankRequest
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationRequest
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationRequest
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.CreateTravelerRequest
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.DelTravelerRequest
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.UpdateTravelerRequest

/**
 * URI -> 接口元数据 映射表（对齐 Go replay_map.go 的 43 条）。
 *
 * 三个 entry 工厂：
 * - mkRiver:  river 平铺字段接口，build 走 buildRiverApiReq（逐字段反射 + 类型适配）
 * - mkRequest: POST-body 接口（river POST-body 与 open-apis param_json 共用），
 *              build 走 buildRequestApiReq，自动判别 param_json vs 直接字段
 * - mkFlat:   平铺字段接口（open-apis approval/detail 等），走 river 平铺反射
 *
 * call/reply 由通用 extractReply 反射处理，无需逐接口编写。
 * 新增接口只需在此追加一条 entry。
 */
class ReplayMap {

    /** uri -> 接口元数据 */
    static final Map<String, ReplayEntry> REPLAY_MAP = [:]

    static {
        // ===== /river/ 家族 =====

        // ----- river 平铺字段接口（mkRiver）：18 条 -----
        mkRiver("/river/Order/detail", { GetCarOrderDetailRequest.builder() }, { ApiClient c, b -> c.order().v1().getCarOrderDetail(b) })
        mkRiver("/river/Order/get", { GetOrderRequest.builder() }, { ApiClient c, b -> c.order().v1().getOrder(b) })
        mkRiver("/river/Member/get", { ListMemberRequest.builder() }, { ApiClient c, b -> c.member().v1().listMember(b) })
        mkRiver("/river/Member/detail", { GetMemberDetailRequest.builder() }, { ApiClient c, b -> c.member().v1().getMemberDetail(b) })
        mkRiver("/river/Member/getQuota", { GetMemberQuotaRequest.builder() }, { ApiClient c, b -> c.member().v1().getMemberQuota(b) })
        mkRiver("/river/BudgetCenter/get", { GetBudgetCenterRequest.builder() }, { ApiClient c, b -> c.budgetcenter().v1().getBudgetCenter(b) })
        mkRiver("/river/Approval/getOrder", { ListApprovalOrderRequest.builder() }, { ApiClient c, b -> c.approval().v1().listApprovalOrder(b) })
        mkRiver("/river/Bill/get", { ListBillRequest.builder() }, { ApiClient c, b -> c.bill().v1().listBill(b) })
        mkRiver("/river/Bill/detail", { GetBillDetailOfWangYCRequest.builder() }, { ApiClient c, b -> c.bill().v1().getBillDetailOfWangYC(b) })
        mkRiver("/river/Bill/getBillStructure", { GetBillStructureRequest.builder() }, { ApiClient c, b -> c.bill().v1().getBillStructure(b) })
        mkRiver("/river/Bill/getNotGeneratedBillDetail", { GetNotGenBillDetailOfWangYCRequest.builder() }, { ApiClient c, b -> c.bill().v1().getNotGenBillDetailOfWangYC(b) })
        mkRiver("/river/City/get", { ListCarCityRequest.builder() }, { ApiClient c, b -> c.city().v1().listCarCity(b) })
        mkRiver("/river/Login/getLoginEncryptStr", { GetLoginEncryptStrRequest.builder() }, { ApiClient c, b -> c.login().v1().getLoginEncryptStr(b) })
        mkRiver("/river/Rank/getRanks", { ListRankRequest.builder() }, { ApiClient c, b -> c.rank().v1().listRank(b) })
        mkRiver("/river/Regulation/detail", { GetRegulationRequest.builder() }, { ApiClient c, b -> c.regulation().v1().getRegulation(b) })
        mkRiver("/river/Regulation/get", { ListRegulationRequest.builder() }, { ApiClient c, b -> c.regulation().v1().listRegulation(b) })
        mkRiver("/river/AfterApproval/getPersonalReceiptOrder", { GetPersonalReceiptOrderRequest.builder() }, { ApiClient c, b -> c.afterapproval().v1().getPersonalReceiptOrder(b) })
        mkRiver("/river/LegalEntity/get", { GetLegalEntityRequest.builder() }, { ApiClient c, b -> c.legalentity().v1().getLegalEntity(b) })

        // ----- river POST-body 接口（mkRequest）：17 条 -----
        mkRequest("river", "/river/Member/edit", { UpdateMemberRequest.builder() }, { ApiClient c, b -> c.member().v1().updateMember(b) })
        mkRequest("river", "/river/Member/del", { DelMemberRequest.builder() }, { ApiClient c, b -> c.member().v1().delMember(b) })
        mkRequest("river", "/river/Member/single", { CreateMemberRequest.builder() }, { ApiClient c, b -> c.member().v1().createMember(b) })
        mkRequest("river", "/river/BudgetCenter/add", { CreateBudgetCenterRequest.builder() }, { ApiClient c, b -> c.budgetcenter().v1().createBudgetCenter(b) })
        mkRequest("river", "/river/BudgetCenter/edit", { UpdateBudgetCenterRequest.builder() }, { ApiClient c, b -> c.budgetcenter().v1().updateBudgetCenter(b) })
        mkRequest("river", "/river/BudgetCenter/del", { DelBudgetCenterRequest.builder() }, { ApiClient c, b -> c.budgetcenter().v1().delBudgetCenter(b) })
        mkRequest("river", "/river/Approval/cancel", { CancelApprovalRequest.builder() }, { ApiClient c, b -> c.approval().v1().cancelApproval(b) })
        mkRequest("river", "/river/Approval/pass", { ApprovalPassRequest.builder() }, { ApiClient c, b -> c.approval().v1().approvalPass(b) })
        // /river/Approval/create 日志 in 与 createBusinessByDateApproval 参数最接近
        mkRequest("river", "/river/Approval/create", { CreateApprovalBusinessByDateRequest.builder() }, { ApiClient c, b -> c.approval().v1().createBusinessByDateApproval(b) })
        mkRequest("river", "/river/Approval/update", { UpdateApprovalBusinessByDateRequest.builder() }, { ApiClient c, b -> c.approval().v1().updateBusinessByDateApproval(b) })
        mkRequest("river", "/river/Auth/authorize", { AuthorizeRequest.builder() }, { ApiClient c, b -> c.auth().v1().authorize(b) })
        mkRequest("river", "/river/DemeterAres/Country/index", { ListCountryRequest.builder() }, { ApiClient c, b -> c.city().v1().listCountry(b) })
        mkRequest("river", "/river/DemeterAres/TrainCity", { ListTrainCityRequest.builder() }, { ApiClient c, b -> c.city().v1().listTrainCity(b) })
        mkRequest("river", "/river/ExtendInfo/BatchSync", { CreateExtendBatchRequest.builder() }, { ApiClient c, b -> c.extend().v1().createExtendBatch(b) })
        mkRequest("river", "/river/LegalEntity/add", { CreateLegalEntityRequest.builder() }, { ApiClient c, b -> c.legalentity().v1().createLegalEntity(b) })
        mkRequest("river", "/river/LegalEntity/edit", { UpdateLegalEntityRequest.builder() }, { ApiClient c, b -> c.legalentity().v1().updateLegalEntity(b) })
        mkRequest("river", "/river/AfterApproval/createPersonalReceipt", { CreatePersonalReceiptRequest.builder() }, { ApiClient c, b -> c.afterapproval().v1().createPersonalReceipt(b) })

        // ===== /open-apis/ 家族：8 条 =====
        mkRequest("open-apis", "/open-apis/v1/order/list", { ListOrderRequest.builder() }, { ApiClient c, b -> c.order().v1().listOrder(b) })
        mkFlat("open-apis", "/open-apis/v1/approval/detail", { GetApprovalDetailRequest.builder() }, { ApiClient c, b -> c.approval().v1().getApprovalDetail(b) })
        mkRequest("open-apis", "/open-apis/v1/rank/create", { CreateRankRequest.builder() }, { ApiClient c, b -> c.rank().v1().createRank(b) })
        mkRequest("open-apis", "/open-apis/v1/rank/update", { UpdateRankRequest.builder() }, { ApiClient c, b -> c.rank().v1().updateRank(b) })
        mkRequest("open-apis", "/open-apis/v1/traveler/create", { CreateTravelerRequest.builder() }, { ApiClient c, b -> c.traveler().v1().createTraveler(b) })
        mkRequest("open-apis", "/open-apis/v1/traveler/del", { DelTravelerRequest.builder() }, { ApiClient c, b -> c.traveler().v1().delTraveler(b) })
        mkRequest("open-apis", "/open-apis/v1/traveler/update", { UpdateTravelerRequest.builder() }, { ApiClient c, b -> c.traveler().v1().updateTraveler(b) })
        mkRequest("open-apis", "/open-apis/v1/city/list", { ListCityRequest.builder() }, { ApiClient c, b -> c.city().v1().listCity(b) })
    }

    /** 构造 river 平铺字段 entry：build 走逐字段反射，call/reply 通用。 */
    static void mkRiver(String uri, Closure newBuilder, Closure callFn) {
        REPLAY_MAP[uri] = new ReplayEntry(
                family: "river",
                build: { Map inMap -> ReplayEngine.buildRiverApiReq(newBuilder.call(), inMap) },
                call: { ApiClient c, Object req -> callFn.call(c, req) },
                reply: { Object resp -> ReplayEngine.extractReply(resp) },
        )
    }

    /** 构造 POST-body entry（river POST-body 与 open-apis param_json 共用）：
     * build 走 buildRequestApiReq，自动判别 param_json vs 直接字段。 */
    static void mkRequest(String family, String uri, Closure newBuilder, Closure callFn) {
        REPLAY_MAP[uri] = new ReplayEntry(
                family: family,
                build: { Map inMap -> ReplayEngine.buildRequestApiReq(newBuilder.call(), inMap) },
                call: { ApiClient c, Object req -> callFn.call(c, req) },
                reply: { Object resp -> ReplayEngine.extractReply(resp) },
        )
    }

    /** 构造平铺字段 entry（open-apis approval/detail 等）：走 river 平铺反射。 */
    static void mkFlat(String family, String uri, Closure newBuilder, Closure callFn) {
        REPLAY_MAP[uri] = new ReplayEntry(
                family: family,
                build: { Map inMap -> ReplayEngine.buildRiverApiReq(newBuilder.call(), inMap) },
                call: { ApiClient c, Object req -> callFn.call(c, req) },
                reply: { Object resp -> ReplayEngine.extractReply(resp) },
        )
    }
}
