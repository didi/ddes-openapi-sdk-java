package com.xiaoju.open.sdk.ddes.service.bill

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.core.request.RestHttpTransport
import com.xiaoju.open.sdk.didies.service.bill.Bill
import com.xiaoju.open.sdk.didies.service.bill.enums.BusinessLineEnum
import com.xiaoju.open.sdk.didies.service.bill.enums.BusinessTypeEnum
import com.xiaoju.open.sdk.didies.service.bill.v1.V1
import com.xiaoju.open.sdk.didies.service.bill.v1.model.*
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Bill
 */
@Ignore
class BillTest extends Specification {

    private Bill api

    Config config

    def setup() {
        config = Config.builder()
                .baseUrl("https://api.es.xiaojukeji.com")
                .clientId("替换成自己的clientId")
                .clientSecret("替换成自己的clientSecret")
                .signKey("替换成自己的signKey")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO).build()
        ApiClient client = new ApiClient(config)
        api = client.bill()
    }

    /**
     * 商旅、网约车账单确认
     *
     *
     */
    def billConfirmTest() {
        BillConfirmRequest billConfirmRequest = new BillConfirmRequest(
                companyId: "替换成自己的companyId",
                billId: ""
        )

        BillConfirmApiReply response = api.v1().billConfirm(billConfirmRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 调账查询结果
     *
     * 响应参数同调账提交接口
     */
    def getAdjustBillDataResultTest() {
        GetAdjustBillDataResultRequest getAdjustBillDataResultRequest = new GetAdjustBillDataResultRequest(
                billId: 1125966073074006,
                adjustReqId: "1747987703615",
                companyId: "替换成自己的companyId"
        )

        GetAdjustBillDataResultApiReply response = api.v1().getAdjustBillDataResult(getAdjustBillDataResultRequest)
        println(JacksonUtils.toJson(getAdjustBillDataResultRequest))
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 代驾)
     *

     */
    def getBillDetailOfDaiJiaTest() {
        GetBillDetailOfDaiJiaRequest getBillDetailOfDaiJiaRequest = new GetBillDetailOfDaiJiaRequest(
                // timestamp=1747886051&company_id=替换成自己的companyId&sign=5d805253dfb10699088e3259a69a6f5e&bill_id=1125957079305278&business_type=40&length=100&payment_period=2025-05-14~2025-05-15
                companyId: "替换成自己的companyId",
                billId: "1125957079305278",
                length: 100,
                businessType: BusinessTypeEnum.DESIGNATED_DRIVER.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                paymentPeriod: "2025-05-14~2025-05-15"
                // bill_id=1125957079305278&business_type=40&length=100&payment_period=2025-05-14~2025-05-15
        )
        GetBillDetailOfDaiJiaApiReply response = api.v1().getBillDetailOfDaiJia(getBillDetailOfDaiJiaRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 国内机票)
     *

     */
    def getBillDetailOfDomesticFlightTest() {
        GetBillDetailOfDomesticFlightRequest getBillDetailOfDomesticFlightRequest = new GetBillDetailOfDomesticFlightRequest(
                // bill_id=1125967084045554&business_type=11&length=100&last_id=1125947318912450
                companyId: "替换成自己的companyId",
                billId: "1125967084045554",
                businessType: BusinessTypeEnum.DOMESTIC_FLIGHT.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100
        )

        GetBillDetailOfDomesticFlightApiReply response = api.v1().getBillDetailOfDomesticFlight(getBillDetailOfDomesticFlightRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 国内酒店)
     *

     */
    def getBillDetailOfDomesticHotelTest() {
        GetBillDetailOfDomesticHotelRequest getBillDetailOfDomesticHotelRequest = new GetBillDetailOfDomesticHotelRequest(
                // bill_id=1125966905240344&business_type=201&length=100&last_id=1125947318912450
                companyId: "替换成自己的companyId",
                billId: "1125966905240344",
                businessType: BusinessTypeEnum.DOMESTIC_HOTEL.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100
        )

        GetBillDetailOfDomesticHotelApiReply response = api.v1().getBillDetailOfDomesticHotel(getBillDetailOfDomesticHotelRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 国际机票)
     *

     */
    def getBillDetailOfInterFlightTest() {

        RestTemplate restTemplate = Mock()
        restTemplate.exchange(_, _, _, _) >> {
            new ResponseEntity<>(internationalFlightBill, HttpStatus.OK)
        }
        config.setHttpTransport(new RestHttpTransport(restTemplate))

        ITokenHolder tokenHolder = Mock()
        tokenHolder.isExpired() >> false
        tokenHolder.getAccessToken() >> 'aaaaaaaaaaaaaaaaaaaaaaa'
        V1 v1 = new V1(tokenHolder, config)

        GetBillDetailOfInterFlightRequest getBillDetailOfInterFlightRequest = new GetBillDetailOfInterFlightRequest(
                companyId: "替换成自己的companyId", // 需自己传
                businessType: BusinessTypeEnum.DOMESTIC_FLIGHT.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100
        )
        GetBillDetailOfInterFlightApiReply response = v1.getBillDetailOfInterFlight(getBillDetailOfInterFlightRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 海外酒店)
     *

     */
    def getBillDetailOfInterHotelTest() {
        GetBillDetailOfInterHotelRequest getBillDetailOfInterHotelRequest = new GetBillDetailOfInterHotelRequest(
                // bill_id=1125966074000462&business_type=204&length=100&last_id=1125947318912450
                companyId: "替换成自己的companyId",
                billId: "1125966074000462",
                businessType: BusinessTypeEnum.INTERNATIONAL_HOTEL.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100
        )

        GetBillDetailOfInterHotelApiReply response = api.v1().getBillDetailOfInterHotel(getBillDetailOfInterHotelRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 增值手工单)
     *

     */
    def getBillDetailOfManualOrderTest() {
        GetBillDetailOfManualOrderRequest getBillDetailOfManualOrderRequest = new GetBillDetailOfManualOrderRequest(
                // bill_id=1125966074000462&business_type=531&length=100&last_id=1125947318912450
                companyId: "替换成自己的companyId",
                billId: "1125966074000462",
                businessType: BusinessTypeEnum.MANUAL_ORDER.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100
        )

        GetBillDetailOfManualOrderApiReply response = api.v1().getBillDetailOfManualOrder(getBillDetailOfManualOrderRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 出租车)
     *

     */
    def getBillDetailOfTaxiTest() {
        GetBillDetailOfTaxiRequest getBillDetailOfTaxiRequest = new GetBillDetailOfTaxiRequest(
                // bill_id=1125962263860239&business_type=100&length=100&payment_period=2025-05-14~2025-05-15
                companyId: "替换成自己的companyId",
                billId: "1125962263860239",
                businessType: BusinessTypeEnum.TAXI.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100,
        )

        GetBillDetailOfTaxiApiReply response = api.v1().getBillDetailOfTaxi(getBillDetailOfTaxiRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 火车票)
     *

     */
    def getBillDetailOfTrainTicketTest() {
        GetBillDetailOfTrainTicketRequest getBillDetailOfTrainTicketRequest = new GetBillDetailOfTrainTicketRequest(
//                bill_id=1125967160953370&business_type=203&length=100&last_id=1125947318912450
                companyId: "替换成自己的companyId",
                billId: "1125967160953370",
                businessType: BusinessTypeEnum.TRAIN_TICKET.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100
        )

        GetBillDetailOfTrainTicketApiReply response = api.v1().getBillDetailOfTrainTicket(getBillDetailOfTrainTicketRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 已出账单(按业务类型拆分 - 网约车)
     *

     */
    def getBillDetailOfWangYCTest() {
        GetBillDetailOfWangYCRequest getBillDetailOfWangYCRequest = new GetBillDetailOfWangYCRequest(
                // bill_id=1125966721993062&business_type=0&client_id=替换成自己的clientId&company_id=替换成自己的companyId&sign=5d743ac55779932142eafc3fc3b8351b&timestamp=1747882646
                companyId: "替换成自己的companyId",
                billId: "1125966721993062",
                businessType: BusinessTypeEnum.RIDE_HAILING.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                length: 100,
        )

        GetBillDetailOfWangYCApiReply response = api.v1().getBillDetailOfWangYC(getBillDetailOfWangYCRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 网约车、商旅账单树查询
     *
     *
     */
    def getBillStructureTest() {
        GetBillStructureRequest getBillStructureRequest = new GetBillStructureRequest(
                companyId: "替换成自己的companyId",
                paymentPeriod: "2025-04-01~2025-04-30",
                businessType: 1
        )
        GetBillStructureApiReply response = api.v1().getBillStructure(getBillStructureRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 账单汇总查询-商旅、网约车、出租车
     *
     *
     */
    def getBillSummaryTest() {
        GetBillSummaryRequest getBillSummaryRequest = new GetBillSummaryRequest(
                companyId: "替换成自己的companyId",
                billId: "1125966073074006",
                businessLine: BusinessLineEnum.RIDE_HAILING.getCode()
        )

        GetBillSummaryApiReply response = api.v1().getBillSummary(getBillSummaryRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 代驾)
     *

     */
    def getNotGenBillDetailOfDaiJiaTest() {
        GetNotGenBillDetailOfDaiJiaRequest getNotGenBillDetailOfDaiJiaRequest = new GetNotGenBillDetailOfDaiJiaRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.DESIGNATED_DRIVER.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
        )

        GetNotGenBillDetailOfDaiJiaApiReply response = api.v1().getNotGenBillDetailOfDaiJia(getNotGenBillDetailOfDaiJiaRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 国内机票)
     *

     */
    def getNotGenBillDetailOfFlightTest() {
        GetNotGenBillDetailOfFlightRequest getNotGenBillDetailOfFlightRequest = new GetNotGenBillDetailOfFlightRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.BILL_DOMESTIC_FLIGHT.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
        )

        GetNotGenBillDetailOfFlightApiReply response = api.v1().getNotGenBillDetailOfFlight(getNotGenBillDetailOfFlightRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 国内酒店)
     *

     */
    def getNotGenBillDetailOfHotelTest() {
        GetNotGenBillDetailOfHotelRequest getNotGenBillDetailOfHotelRequest = new GetNotGenBillDetailOfHotelRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.DOMESTIC_HOTEL.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
        )

        GetNotGenBillDetailOfHotelApiReply response = api.v1().getNotGenBillDetailOfHotel(getNotGenBillDetailOfHotelRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 国际机票)
     *

     */
    def getNotGenBillDetailOfInterFlightTest() {

        RestTemplate restTemplate = Mock()
        restTemplate.exchange(_, _, _, _) >> {
            new ResponseEntity<>(internationalNotGenFlightBill, HttpStatus.OK)
        }
        config.setHttpTransport(new RestHttpTransport(restTemplate))

        ITokenHolder tokenHolder = Mock()
        tokenHolder.isExpired() >> false
        tokenHolder.getAccessToken() >> 'aaaaaaaaaaaaaaaaaaaaaaa'
        V1 v1 = new V1(tokenHolder, config)

        GetNotGenBillDetailOfInterFlightRequest getNotGenBillDetailOfInterFlightRequest = new GetNotGenBillDetailOfInterFlightRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.INTERNATIONAL_FLIGHT.getCode(), // 这里是对业务拆分，实际使用的时候【必填】
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
                // lastId: "", // 使用上次查询返回结果的last_id 使用上次查询返回结果的last_id，第一次查询last_id可不传，解决深分页的问题
        )
        GetNotGenBillDetailOfInterFlightApiReply response = v1.getNotGenBillDetailOfInterFlight(getNotGenBillDetailOfInterFlightRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 海外酒店)
     *

     */
    def getNotGenBillDetailOfInterHotelTest() {
        GetNotGenBillDetailOfInterHotelRequest getNotGenBillDetailOfInterHotelRequest = new GetNotGenBillDetailOfInterHotelRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.INTERNATIONAL_HOTEL.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
        )

        GetNotGenBillDetailOfInterHotelApiReply response = api.v1().getNotGenBillDetailOfInterHotel(getNotGenBillDetailOfInterHotelRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 增值手工单)
     *

     */
    def getNotGenBillDetailOfManualOrderTest() {
        GetNotGenBillDetailOfManualOrderRequest getNotGenBillDetailOfManualOrderRequest = new GetNotGenBillDetailOfManualOrderRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.MANUAL_ORDER.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
                // lastId: "", // 使用上次查询返回结果的last_id 使用上次查询返回结果的last_id，第一次查询last_id可不传，解决深分页的问题
        )

        GetNotGenBillDetailOfManualOrderApiReply response = api.v1().getNotGenBillDetailOfManualOrder(getNotGenBillDetailOfManualOrderRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 出租车)
     *
     */
    def getNotGenBillDetailOfTaxiTest() {
        GetNotGenBillDetailOfTaxiRequest getNotGenBillDetailOfTaxiRequest = new GetNotGenBillDetailOfTaxiRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.TAXI.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
                // lastId: "", // 使用上次查询返回结果的last_id 使用上次查询返回结果的last_id，第一次查询last_id可不传，解决深分页的问题
        )

        GetNotGenBillDetailOfTaxiApiReply response = api.v1().getNotGenBillDetailOfTaxi(getNotGenBillDetailOfTaxiRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 火车票)
     *
     */
    def getNotGenBillDetailOfTrainTest() {
        GetNotGenBillDetailOfTrainRequest getNotGenBillDetailOfTrainRequest = new GetNotGenBillDetailOfTrainRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.TRAIN_TICKET.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
        )

        GetNotGenBillDetailOfTrainApiReply response = api.v1().getNotGenBillDetailOfTrain(getNotGenBillDetailOfTrainRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 未出账单(按业务类型拆分 - 网约车)
     *
     */
    def getNotGenBillDetailOfWangYCTest() {
        GetNotGenBillDetailOfWangYCRequest getNotGenBillDetailOfWangYCRequest = new GetNotGenBillDetailOfWangYCRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.RIDE_HAILING.getCode(),
                startDate: "2025-05-03 17:50:00",
                endDate: "2025-05-04 17:50:00",
        )

        GetNotGenBillDetailOfWangYCApiReply response = api.v1().getNotGenBillDetailOfWangYC(getNotGenBillDetailOfWangYCRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 网约车、出租车交易明细 ~ 网约车
     *
     */
    def getTransactionBillDetailTest() {
        GetTransactionBillDetailRequest getTransactionBillDetailRequest = new GetTransactionBillDetailRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.RIDE_HAILING.getCode(),
                length: 100,
                billId: "1125966721993062"
        )

        GetTransactionBillDetailApiReply response = api.v1().getTransactionBillDetail(getTransactionBillDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 网约车、出租车交易明细 ~ 出租车
     */
    def getTransactionBillDetailOfTaxiTest() {
        GetTransactionBillDetailOfTaxiRequest getTransactionBillDetailOfTaxiRequest = new GetTransactionBillDetailOfTaxiRequest(
                companyId: "替换成自己的companyId",
                businessType: BusinessTypeEnum.TAXI.getCode(),
                length: 100,
                billId: "1125966721993062"
        )

        GetTransactionBillDetailOfTaxiApiReply response = api.v1().getTransactionBillDetailOfTaxi(getTransactionBillDetailOfTaxiRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 账单列表接口
     *
     *
     */
    def listBillTest() {
        ListBillRequest listBillRequest = new ListBillRequest(
                companyId: "替换成自己的companyId",
                offset: 0, length: 100, businessLine: BusinessLineEnum.RIDE_HAILING.getCode()
        )

        ListBillApiReply response = api.v1().listBill(listBillRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

    /**
     * 账单列表接口
     *
     *
     */
    def listBillTest_business() {
        ListBillRequest listBillRequest = new ListBillRequest(
                companyId: "替换成自己的companyId", offset: 0, length: 100, businessLine: BusinessLineEnum.BUSINESS_TRAVEL.getCode()
        )

        ListBillApiReply response = api.v1().listBill(listBillRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 账单列表接口
     *
     *
     */
    def listBillTest_taxi() {
        ListBillRequest listBillRequest = new ListBillRequest(
                companyId: "替换成自己的companyId", offset: 0, length: 100, businessLine: BusinessLineEnum.TAXI.getCode()
        )

        ListBillApiReply response = api.v1().listBill(listBillRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 账单调整提交接口
     */
    def updateAdjustBillDataTest() {
        // 替换成自己的clientId，替换成自己的clientSecret，替换成自己的signKey，替换成自己的companyId
        config.setClientId("替换成自己的clientId")
        config.setClientSecret("替换成自己的clientSecret")
        config.setSignKey("替换成自己的signKey")
        def items = [
                new AdjustListItem(
                        subBusinessType: 1,
                        subOrderId: "1125963892688390"
                )
        ]

        UpdateAdjustBillDataRequest updateAdjustBillDataRequest = new UpdateAdjustBillDataRequest(
                billId: 1125966073074006,
                adjustReqId: "1747987703615",
                companyId: "替换成自己的companyId",
                businessType: 0,
                adjustType: 1, // 1:订单计入下期2:订单信息调整
                adjustList: items,
                remark: "手工单调账"
        )
        println(JacksonUtils.toJson(updateAdjustBillDataRequest))
        UpdateAdjustBillDataApiReply response = api.v1().updateAdjustBillData(updateAdjustBillDataRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }


    // 国际未出机票账单
    String internationalNotGenFlightBill = """{"data": {"detail_list": [{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "汉莎航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125963328142639","approval_normal_history": "2025-04-11 18:09:32OpenApi系统通过(0)审批完成","arrival_airport_code": "MAD","arrival_airport_name": "巴拉哈斯机场","arrival_city_id": "1000357","arrival_city_name": "马德里","arrival_continent": "欧洲","arrival_country": "西班牙","arrival_time": "2025-05-11 20:40:00","before_cut_service_fee": 0,"booking_date": "2025-04-30 15:20:20","booking_dep_code": "522","booking_dep_name": "欧洲分公司（储能）","booking_member_id": 1125931981863687,"booking_member_name": "钟郑浩","booking_member_number": "REPT00886","booking_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）","budget_center_code": "522","budget_center_id": "1125935657210950","budget_center_name": "欧洲分公司（储能）","budget_center_parent_path_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）","cabin_code": "V","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "2764.00","construction_cost": "0","create_time": "2025-04-30 15:20:20","days_in_advance": 11,"department": "欧洲分公司（储能）","department_id": "1125935657210950","departure_airport_code": "MUC","departure_airport_name": "慕尼黑机场","departure_city_id": "1000363","departure_city_name": "慕尼黑","departure_continent": "欧洲","departure_country": "德国","departure_time": "2025-05-11 17:55:00","employee_number": "REPT00886","ex_info_01": "","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 2644.0,"extend_info": "","extra_info": "","final_departure_time": "2025-05-11 17:55:00","flight_number": "LH1802","flight_segment_number": 1,"flight_segment_travel": "慕尼黑-马德里","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "瑞浦兰钧能源股份有限公司","group_2_code": "7","group_2_name": " 瑞浦兰钧能源股份有限公司","group_3_code": "659","group_3_name": "市场营销中心","group_4_code": "499","group_4_name": "储能事业部","group_5_code": "504","group_5_name": "海外储能","group_6_code": "522","group_6_name": "欧洲分公司（储能）","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125963328036030,"institution_name": "申请单模式（D1-D2)-1125963328142639","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "否","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125931981863687","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965435898203","origin_order_id": "1125965435898203","origin_ticket_id": "1125965435956740","out_legal_entity_id": "","out_requisition_id": "RPKQ0052025040915399","parent_institution_id": 1125944033866726,"parent_institution_name": "申请单模式（D1-D2)","passenger_dep_code": "522","passenger_dep_name": "欧洲分公司（储能）","passenger_group_1_code": "1","passenger_group_1_name": "瑞浦兰钧能源股份有限公司","passenger_group_2_code": "7","passenger_group_2_name": " 瑞浦兰钧能源股份有限公司","passenger_group_3_code": "659","passenger_group_3_name": "市场营销中心","passenger_group_4_code": "499","passenger_group_4_name": "储能事业部","passenger_group_5_code": "504","passenger_group_5_name": "海外储能","passenger_group_6_code": "522","passenger_group_6_name": "欧洲分公司（储能）","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125931981863687,"passenger_member_name": "ZHONG/ZHENGHAO","passenger_member_number": "REPT00886","passenger_name": "ZHONG/ZHENGHAO","passenger_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）","pay_channel": "授信","pay_type": "企业支付","pnr_number": "5THPRD","pre_order_id": "0","project_ext_info": "","rank_name": "D2","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125963328142639","service_fee": "120.00","settlement_time": "2025-04-30 15:20:20","sub_account_company_name": "瑞浦兰钧能源股份有限公司","sub_company_no": "","supplier_order_id": "2202650899099","supplier_ticket_number": "220-2650899099","tax": "696.00","ticket_fee": "1948.00","ticket_id_text": "","total_fee": "2644.00","transaction_type": 0,"travel_purpose": "商务出行（拜访客户/供应商）","trip_description": "","trip_reason": "参加德国intersolar,&nbsp;拜访欧洲片区客户","unique_key": "1125965435956740-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "四川航空,四川航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125962059749715","approval_normal_history": "2025-04-01 10:03:07OpenApi系统通过(0)审批完成","arrival_airport_code": "TFU,WNZ","arrival_airport_name": "天府国际机场,龙湾国际机场","arrival_city_id": "17,85","arrival_city_name": "成都,温州","arrival_continent": "亚洲,亚洲","arrival_country": "中国,中国","arrival_time": "2025-05-15 05:00:00,2025-05-15 11:25:00","before_cut_service_fee": 0,"booking_date": "2025-04-30 12:23:13","booking_dep_code": "541","booking_dep_name": "大客户组（储能）","booking_member_id": 1125931241415638,"booking_member_name": "周娜","booking_member_number": "REPT36951","booking_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）>大客户组（储能）","budget_center_code": "541","budget_center_id": "1125936648657127","budget_center_name": "大客户组（储能）","budget_center_parent_path_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）>大客户组（储能）","cabin_code": "N,B","cabin_name": "经济舱,经济舱","cabin_type": 0,"change_handle_cost": "0","company_real_pay": "2749.00","construction_cost": "0","create_time": "2025-04-30 12:23:13","days_in_advance": 14,"department": "大客户组（储能）","department_id": "1125936648657127","departure_airport_code": "MAD,TFU","departure_airport_name": "巴拉哈斯机场,天府国际机场","departure_city_id": "1000357,17","departure_city_name": "马德里,成都","departure_continent": "欧洲,亚洲","departure_country": "西班牙,中国","departure_time": "2025-05-14 17:05:00,2025-05-15 08:50:00","employee_number": "REPT36951","ex_info_01": "","ex_info_01_code": "","ex_info_02": "储能","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 2629.0,"extend_info": "","extra_info": "","final_departure_time": "2025-05-14 17:05:00,2025-05-15 08:50:00","flight_number": "3U3804,3U6901","flight_segment_number": 0,"flight_segment_travel": "马德里-成都,成都-温州","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "瑞浦兰钧能源股份有限公司","group_2_code": "7","group_2_name": " 瑞浦兰钧能源股份有限公司","group_3_code": "659","group_3_name": "市场营销中心","group_4_code": "499","group_4_name": "储能事业部","group_5_code": "504","group_5_name": "海外储能","group_6_code": "522","group_6_name": "欧洲分公司（储能）","group_7_code": "541","group_7_name": "大客户组（储能）","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125962058575224,"institution_name": "申请单模式（ABC）差标-1125962059749715","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否,否","is_traveler": "否","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125931241415638","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965424526973","origin_order_id": "1125965424526973","origin_ticket_id": "1125965424395954","out_legal_entity_id": "","out_requisition_id": "RPKQ0052025032915191","parent_institution_id": 1125935437534864,"parent_institution_name": "申请单模式（ABC）差标","passenger_dep_code": "541","passenger_dep_name": "大客户组（储能）","passenger_group_1_code": "1","passenger_group_1_name": "瑞浦兰钧能源股份有限公司","passenger_group_2_code": "7","passenger_group_2_name": " 瑞浦兰钧能源股份有限公司","passenger_group_3_code": "659","passenger_group_3_name": "市场营销中心","passenger_group_4_code": "499","passenger_group_4_name": "储能事业部","passenger_group_5_code": "504","passenger_group_5_name": "海外储能","passenger_group_6_code": "522","passenger_group_6_name": "欧洲分公司（储能）","passenger_group_7_code": "541","passenger_group_7_name": "大客户组（储能）","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125931241415638,"passenger_member_name": "ZHOU/NA","passenger_member_number": "REPT36951","passenger_name": "ZHOU/NA","passenger_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）>大客户组（储能）","pay_channel": "授信","pay_type": "企业支付","pnr_number": "KE6Q44","pre_order_id": "0","project_ext_info": "","rank_name": "C职级","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": ",","refund_handle_cost": "0","requisition_id": "1125962059749715","service_fee": "120.00","settlement_time": "2025-04-30 12:23:13","sub_account_company_name": "瑞浦兰钧能源股份有限公司","sub_company_no": "","supplier_order_id": "8766402793389","supplier_ticket_number": "876-6402793389","tax": "1629.00","ticket_fee": "1000.00","ticket_id_text": "","total_fee": "2629.00","transaction_type": 0,"travel_purpose": "商务出行（拜访客户/供应商）","trip_description": "","trip_reason": "参加5月份德国Intersolar展会，展会前后在欧洲各国拜访客户。客户拜访行程尚未敲定，提前提行程购买去慕尼黑的机票","unique_key": "1125965424395954-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "汉莎航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125962610815360","approval_normal_history": "2025-04-06 12:11:55OpenApi系统通过(0)审批完成","arrival_airport_code": "MAD","arrival_airport_name": "巴拉哈斯机场","arrival_city_id": "1000357","arrival_city_name": "马德里","arrival_continent": "欧洲","arrival_country": "西班牙","arrival_time": "2025-05-11 20:40:00","before_cut_service_fee": 0,"booking_date": "2025-04-30 12:03:27","booking_dep_code": "789","booking_dep_name": "储能系统研发部(青创)","booking_member_id": 1125943364109870,"booking_member_name": "刘思","booking_member_number": "REPT10007","booking_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 上海瑞浦青创新能源有限公司>研发中心>储能系统研发部(青创)","budget_center_code": "499","budget_center_id": "1125935657249627","budget_center_name": "储能事业部","budget_center_parent_path_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部","cabin_code": "V","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "2764.00","construction_cost": "0","create_time": "2025-04-30 12:03:27","days_in_advance": 11,"department": "储能系统研发部(青创)","department_id": "1125952302204506","departure_airport_code": "MUC","departure_airport_name": "慕尼黑机场","departure_city_id": "1000363","departure_city_name": "慕尼黑","departure_continent": "欧洲","departure_country": "德国","departure_time": "2025-05-11 17:55:00","employee_number": "REPT10007","ex_info_01": "SCBZHFY-2025","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 2644.0,"extend_info": "","extra_info": "","final_departure_time": "2025-05-11 17:55:00","flight_number": "LH1802","flight_segment_number": 1,"flight_segment_travel": "慕尼黑-马德里","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "瑞浦兰钧能源股份有限公司","group_2_code": "9","group_2_name": " 上海瑞浦青创新能源有限公司","group_3_code": "55","group_3_name": "研发中心","group_4_code": "789","group_4_name": "储能系统研发部(青创)","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125962610627050,"institution_name": "申请单模式（E职级）-1125962610815360","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "否","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125943364109870","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965423069307","origin_order_id": "1125965423069307","origin_ticket_id": "1125965423056263","out_legal_entity_id": "","out_requisition_id": "SHHR005202504046400","parent_institution_id": 1125951672828577,"parent_institution_name": "申请单模式（E职级）","passenger_dep_code": "789","passenger_dep_name": "储能系统研发部(青创)","passenger_group_1_code": "1","passenger_group_1_name": "瑞浦兰钧能源股份有限公司","passenger_group_2_code": "9","passenger_group_2_name": " 上海瑞浦青创新能源有限公司","passenger_group_3_code": "55","passenger_group_3_name": "研发中心","passenger_group_4_code": "789","passenger_group_4_name": "储能系统研发部(青创)","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125943364109870,"passenger_member_name": "LIU/SI","passenger_member_number": "REPT10007","passenger_name": "LIU/SI","passenger_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 上海瑞浦青创新能源有限公司>研发中心>储能系统研发部(青创)","pay_channel": "授信","pay_type": "企业支付","pnr_number": "5SP3W5","pre_order_id": "0","project_ext_info": "","rank_name": "E职级","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125962610815360","service_fee": "120.00","settlement_time": "2025-04-30 12:03:27","sub_account_company_name": "瑞浦兰钧能源股份有限公司","sub_company_no": "","supplier_order_id": "2202650899097","supplier_ticket_number": "220-2650899097","tax": "696.00","ticket_fee": "1948.00","ticket_id_text": "","total_fee": "2644.00","transaction_type": 0,"travel_purpose": "商务出行（拜访客户/供应商）","trip_description": "","trip_reason": "2025intersolar","unique_key": "1125965423056263-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "汉莎航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125962059749715","approval_normal_history": "2025-04-01 10:03:07OpenApi系统通过(0)审批完成","arrival_airport_code": "MAD","arrival_airport_name": "巴拉哈斯机场","arrival_city_id": "1000357","arrival_city_name": "马德里","arrival_continent": "欧洲","arrival_country": "西班牙","arrival_time": "2025-05-11 20:40:00","before_cut_service_fee": 0,"booking_date": "2025-04-30 13:14:12","booking_dep_code": "541","booking_dep_name": "大客户组（储能）","booking_member_id": 1125931241415638,"booking_member_name": "周娜","booking_member_number": "REPT36951","booking_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）>大客户组（储能）","budget_center_code": "541","budget_center_id": "1125936648657127","budget_center_name": "大客户组（储能）","budget_center_parent_path_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）>大客户组（储能）","cabin_code": "V","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "3292.00","construction_cost": "0","create_time": "2025-04-30 13:14:12","days_in_advance": 11,"department": "大客户组（储能）","department_id": "1125936648657127","departure_airport_code": "MUC","departure_airport_name": "慕尼黑机场","departure_city_id": "1000363","departure_city_name": "慕尼黑","departure_continent": "欧洲","departure_country": "德国","departure_time": "2025-05-11 17:55:00","employee_number": "REPT36951","ex_info_01": "","ex_info_01_code": "","ex_info_02": "储能","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 3172.0,"extend_info": "","extra_info": "","final_departure_time": "2025-05-11 17:55:00","flight_number": "LH1802","flight_segment_number": 1,"flight_segment_travel": "慕尼黑-马德里","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "瑞浦兰钧能源股份有限公司","group_2_code": "7","group_2_name": " 瑞浦兰钧能源股份有限公司","group_3_code": "659","group_3_name": "市场营销中心","group_4_code": "499","group_4_name": "储能事业部","group_5_code": "504","group_5_name": "海外储能","group_6_code": "522","group_6_name": "欧洲分公司（储能）","group_7_code": "541","group_7_name": "大客户组（储能）","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125962058575224,"institution_name": "申请单模式（ABC）差标-1125962059749715","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "否","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125931241415638","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965422077988","origin_order_id": "1125965422077988","origin_ticket_id": "1125965421942518","out_legal_entity_id": "","out_requisition_id": "RPKQ0052025032915191","parent_institution_id": 1125935437534864,"parent_institution_name": "申请单模式（ABC）差标","passenger_dep_code": "541","passenger_dep_name": "大客户组（储能）","passenger_group_1_code": "1","passenger_group_1_name": "瑞浦兰钧能源股份有限公司","passenger_group_2_code": "7","passenger_group_2_name": " 瑞浦兰钧能源股份有限公司","passenger_group_3_code": "659","passenger_group_3_name": "市场营销中心","passenger_group_4_code": "499","passenger_group_4_name": "储能事业部","passenger_group_5_code": "504","passenger_group_5_name": "海外储能","passenger_group_6_code": "522","passenger_group_6_name": "欧洲分公司（储能）","passenger_group_7_code": "541","passenger_group_7_name": "大客户组（储能）","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125931241415638,"passenger_member_name": "ZHOU/NA","passenger_member_number": "REPT36951","passenger_name": "ZHOU/NA","passenger_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 瑞浦兰钧能源股份有限公司>市场营销中心>储能事业部>海外储能>欧洲分公司（储能）>大客户组（储能）","pay_channel": "授信","pay_type": "企业支付","pnr_number": "3BITTT","pre_order_id": "0","project_ext_info": "","rank_name": "C职级","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125962059749715","service_fee": "120.00","settlement_time": "2025-04-30 13:14:12","sub_account_company_name": "瑞浦兰钧能源股份有限公司","sub_company_no": "","supplier_order_id": "2207288341185","supplier_ticket_number": "2207288341185","tax": "840.00","ticket_fee": "2332.00","ticket_id_text": "","total_fee": "3172.00","transaction_type": 0,"travel_purpose": "商务出行（拜访客户/供应商）","trip_description": "","trip_reason": "参加5月份德国Intersolar展会，展会前后在欧洲各国拜访客户。客户拜访行程尚未敲定，提前提行程购买去慕尼黑的机票","unique_key": "1125965421942518-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "卡塔尔航空,卡塔尔航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125964077974626","approval_normal_history": "2025-04-17 20:04:25OpenApi系统通过(0)审批完成","arrival_airport_code": "DOH,PVG","arrival_airport_name": "哈马德机场,浦东机场","arrival_city_id": "1001401,4","arrival_city_name": "多哈,上海","arrival_continent": "亚洲,亚洲","arrival_country": "卡塔尔,中国","arrival_time": "2025-05-12 04:25:00,2025-05-12 16:20:00","before_cut_service_fee": 0,"booking_date": "2025-04-30 11:42:13","booking_dep_code": "430","booking_dep_name": "储能项目部(青创)","booking_member_id": 1125936827481086,"booking_member_name": "刘丽","booking_member_number": "REPT10158","booking_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 上海瑞浦青创新能源有限公司>项目运营部(青创)>储能项目部(青创)","budget_center_code": "430","budget_center_id": "1125935657012376","budget_center_name": "储能项目部(青创)","budget_center_parent_path_name": "瑞浦兰钧能源股份有限公司> 上海瑞浦青创新能源有限公司>项目运营部(青创)>储能项目部(青创)","cabin_code": "K,K","cabin_name": "经济舱,经济舱","cabin_type": 0,"change_handle_cost": "0","company_real_pay": "7161.00","construction_cost": "0","create_time": "2025-04-30 11:42:13","days_in_advance": 11,"department": "储能项目部(青创)","department_id": "1125935657012376","departure_airport_code": "MUC,DOH","departure_airport_name": "慕尼黑机场,哈马德机场","departure_city_id": "1000363,1001401","departure_city_name": "慕尼黑,多哈","departure_continent": "欧洲,亚洲","departure_country": "德国,卡塔尔","departure_time": "2025-05-11 22:50:00,2025-05-12 07:40:00","employee_number": "REPT10158","ex_info_01": "PM-E-2024-008","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 7041.0,"extend_info": "","extra_info": "","final_departure_time": "2025-05-11 22:50:00,2025-05-12 07:40:00","flight_number": "QR058,QR870","flight_segment_number": 0,"flight_segment_travel": "慕尼黑-多哈,多哈-上海","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "瑞浦兰钧能源股份有限公司","group_2_code": "9","group_2_name": " 上海瑞浦青创新能源有限公司","group_3_code": "137","group_3_name": "项目运营部(青创)","group_4_code": "430","group_4_name": "储能项目部(青创)","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125964077694703,"institution_name": "申请单模式（D1-D2)-1125964077974626","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否,否","is_traveler": "否","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125936827481086","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965421700189","origin_order_id": "1125965421700189","origin_ticket_id": "1125965421712966","out_legal_entity_id": "","out_requisition_id": "SHHR005202504176482","parent_institution_id": 1125944033866726,"parent_institution_name": "申请单模式（D1-D2)","passenger_dep_code": "430","passenger_dep_name": "储能项目部(青创)","passenger_group_1_code": "1","passenger_group_1_name": "瑞浦兰钧能源股份有限公司","passenger_group_2_code": "9","passenger_group_2_name": " 上海瑞浦青创新能源有限公司","passenger_group_3_code": "137","passenger_group_3_name": "项目运营部(青创)","passenger_group_4_code": "430","passenger_group_4_name": "储能项目部(青创)","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125936827481086,"passenger_member_name": "LIU/LI","passenger_member_number": "REPT10158","passenger_name": "LIU/LI","passenger_parent_path_dep_name": "瑞浦兰钧能源股份有限公司> 上海瑞浦青创新能源有限公司>项目运营部(青创)>储能项目部(青创)","pay_channel": "授信","pay_type": "企业支付","pnr_number": "KGH9QP","pre_order_id": "0","project_ext_info": "","rank_name": "D1","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": ",","refund_handle_cost": "0","requisition_id": "1125964077974626","service_fee": "120.00","settlement_time": "2025-04-30 11:42:13","sub_account_company_name": "瑞浦兰钧能源股份有限公司","sub_company_no": "","supplier_order_id": "1576402793388","supplier_ticket_number": "157-6402793388","tax": "2581.00","ticket_fee": "4460.00","ticket_id_text": "","total_fee": "7041.00","transaction_type": 0,"travel_purpose": "商务出行（拜访客户/供应商）","trip_description": "","trip_reason": "Intersolar参加展会+客户拜访","unique_key": "1125965421712966-0","upgrade_cost": "0"}],"last_id": "1125958593802602","total": 45},"message": "成功","odin": "","status": 0,"traceid": "0a88ecca682fe70bc8b93ff400167886"}"""

    String internationalFlightBill = """{"data": {"is_last": true,"last_id": "20250430221242-1125965465485744-0-20250430221242:1125965465485744-0","orders": [{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "东方航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125962376836588","approval_normal_history": "2025-04-03 09:03:27赵俊(134****0980)赵俊 提交给 敖宇翔,2025-04-03 09:36:28敖宇翔(138****7165)敖宇翔 确认审批完成","arrival_airport_code": "HFE","arrival_airport_name": "新桥机场","arrival_city_id": "15","arrival_city_name": "合肥","arrival_continent": "亚洲","arrival_country": "中国","arrival_time": "2025-04-06 20:30:00","before_cut_service_fee": 0,"bill_id": 1125965578069534,"booking_date": "2025-04-03 09:58:26","booking_dep_code": "9000103","booking_dep_name": "PES Team","booking_member_id": 1125906580026581,"booking_member_name": "赵俊","booking_member_number": "","booking_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","budget_center_code": "","budget_center_id": "0","budget_center_name": "","budget_center_parent_path_name": "","cabin_code": "L","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "1628.00","construction_cost": "0","create_time": "2025-04-03 09:58:26","days_in_advance": 3,"department": "PES Team","department_id": "1125909095755529","departure_airport_code": "HKG","departure_airport_name": "香港国际机场","departure_city_id": "357","departure_city_name": "中国香港","departure_continent": "亚洲","departure_country": "中国香港","departure_time": "2025-04-06 18:10:00","employee_number": "","ex_info_01": "","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 1608.0,"extend_info": "","extra_info": "","final_departure_time": "2025-04-06 18:10:00","flight_number": "MU2068","flight_segment_number": 1,"flight_segment_travel": "中国香港-合肥","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "上海科创银行有限公司","group_2_code": "9","group_2_name": "上海总行","group_3_code": "9000103","group_3_name": "PES Team","group_4_code": "","group_4_name": "","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125962380155834,"institution_name": "因公出差-1125962376836588","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125906580026581","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125962381551155","origin_order_id": "1125962381551155","origin_ticket_id": "1125962381490870","out_legal_entity_id": "","out_requisition_id": "","parent_institution_id": 1125920278315109,"parent_institution_name": "","passenger_dep_code": "9000103","passenger_dep_name": "PES Team","passenger_group_1_code": "1","passenger_group_1_name": "上海科创银行有限公司","passenger_group_2_code": "9","passenger_group_2_name": "上海总行","passenger_group_3_code": "9000103","passenger_group_3_name": "PES Team","passenger_group_4_code": "","passenger_group_4_name": "","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125906580026581,"passenger_member_name": "ZHAO/JUN","passenger_member_number": "","passenger_name": "ZHAO/JUN","passenger_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","pay_channel": "授信","pay_type": "","pnr_number": "NZC7BV","pre_order_id": "0","project_ext_info": "","rank_name": "","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125962376836588","service_fee": "20.00","settlement_time": "2025-04-03 09:58:26","sub_account_company_name": "上海科创银行有限公司","sub_company_no": "","supplier_order_id": "7815455116171","supplier_ticket_number": "781-5455116171","tax": "354.00","ticket_fee": "1254.00","ticket_id_text": "","total_fee": "1608.00","transaction_type": 0,"travel_purpose": "用车原因","trip_description": "访客","trip_reason": "客户会提前到周一早上，需提前抵达合肥","unique_key": "1125962381490870-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "国泰航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125962056402471","approval_normal_history": "2025-04-01 09:33:52赵俊(134****0980)赵俊 提交给 敖宇翔,2025-04-01 13:54:01敖宇翔(138****7165)敖宇翔 确认审批完成","arrival_airport_code": "HKG","arrival_airport_name": "香港国际机场","arrival_city_id": "357","arrival_city_name": "中国香港","arrival_continent": "亚洲","arrival_country": "中国香港","arrival_time": "2025-04-10 20:35:00","before_cut_service_fee": 0,"bill_id": 1125965578069534,"booking_date": "2025-04-04 00:02:59","booking_dep_code": "9000103","booking_dep_name": "PES Team","booking_member_id": 1125906580026581,"booking_member_name": "赵俊","booking_member_number": "","booking_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","budget_center_code": "","budget_center_id": "0","budget_center_name": "","budget_center_parent_path_name": "","cabin_code": "Q","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "1045.00","construction_cost": "0","create_time": "2025-04-04 00:02:59","days_in_advance": 6,"department": "PES Team","department_id": "1125909095755529","departure_airport_code": "PEK","departure_airport_name": "首都机场","departure_city_id": "1","departure_city_name": "北京","departure_continent": "亚洲","departure_country": "中国","departure_time": "2025-04-10 16:40:00","employee_number": "","ex_info_01": "","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 1025.0,"extend_info": "","extra_info": "","final_departure_time": "2025-04-10 16:40:00","flight_number": "CX331","flight_segment_number": 1,"flight_segment_travel": "北京-中国香港","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "上海科创银行有限公司","group_2_code": "9","group_2_name": "上海总行","group_3_code": "9000103","group_3_name": "PES Team","group_4_code": "","group_4_name": "","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125962080932340,"institution_name": "因公出差-1125962056402471","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125906580026581","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125962475842058","origin_order_id": "1125962475842058","origin_ticket_id": "1125962475842433","out_legal_entity_id": "","out_requisition_id": "","parent_institution_id": 1125920278315109,"parent_institution_name": "","passenger_dep_code": "9000103","passenger_dep_name": "PES Team","passenger_group_1_code": "1","passenger_group_1_name": "上海科创银行有限公司","passenger_group_2_code": "9","passenger_group_2_name": "上海总行","passenger_group_3_code": "9000103","passenger_group_3_name": "PES Team","passenger_group_4_code": "","passenger_group_4_name": "","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125906580026581,"passenger_member_name": "ZHAO/JUN","passenger_member_number": "","passenger_name": "ZHAO/JUN","passenger_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","pay_channel": "授信","pay_type": "","pnr_number": "HXDD32","pre_order_id": "0","project_ext_info": "","rank_name": "","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125962056402471","service_fee": "20.00","settlement_time": "2025-04-04 00:02:59","sub_account_company_name": "上海科创银行有限公司","sub_company_no": "","supplier_order_id": "1606316138770","supplier_ticket_number": "160-6316138770","tax": "225.00","ticket_fee": "800.00","ticket_id_text": "","total_fee": "1025.00","transaction_type": 0,"travel_purpose": "用车原因","trip_description": "出差","trip_reason": "访客，CVCFO","unique_key": "1125962475842433-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "国泰航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125964400642558","approval_normal_history": "2025-04-21 10:40:20赵俊(134****0980)赵俊 提交给 敖宇翔,2025-04-21 10:42:32敖宇翔(138****7165)敖宇翔 确认审批完成","arrival_airport_code": "SHA","arrival_airport_name": "虹桥机场","arrival_city_id": "4","arrival_city_name": "上海","arrival_continent": "亚洲","arrival_country": "中国","arrival_time": "2025-04-23 12:05:00","before_cut_service_fee": 0,"bill_id": 1125965578069534,"booking_date": "2025-04-21 11:03:16","booking_dep_code": "9000103","booking_dep_name": "PES Team","booking_member_id": 1125906580026581,"booking_member_name": "赵俊","booking_member_number": "","booking_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","budget_center_code": "","budget_center_id": "0","budget_center_name": "","budget_center_parent_path_name": "","cabin_code": "M","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "1986.00","construction_cost": "0","create_time": "2025-04-21 11:03:16","days_in_advance": 2,"department": "PES Team","department_id": "1125909095755529","departure_airport_code": "HKG","departure_airport_name": "香港国际机场","departure_city_id": "357","departure_city_name": "中国香港","departure_continent": "亚洲","departure_country": "中国香港","departure_time": "2025-04-23 09:35:00","employee_number": "","ex_info_01": "","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 1966.0,"extend_info": "","extra_info": "","final_departure_time": "2025-04-23 09:35:00","flight_number": "CX342","flight_segment_number": 1,"flight_segment_travel": "中国香港-上海","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "上海科创银行有限公司","group_2_code": "9","group_2_name": "上海总行","group_3_code": "9000103","group_3_name": "PES Team","group_4_code": "","group_4_name": "","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125964400727651,"institution_name": "因公出差-1125964400642558","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125906580026581","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125964402465875","origin_order_id": "1125964402465875","origin_ticket_id": "1125964402485575","out_legal_entity_id": "","out_requisition_id": "","parent_institution_id": 1125920278315109,"parent_institution_name": "因公出差","passenger_dep_code": "9000103","passenger_dep_name": "PES Team","passenger_group_1_code": "1","passenger_group_1_name": "上海科创银行有限公司","passenger_group_2_code": "9","passenger_group_2_name": "上海总行","passenger_group_3_code": "9000103","passenger_group_3_name": "PES Team","passenger_group_4_code": "","passenger_group_4_name": "","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125906580026581,"passenger_member_name": "ZHAO/JUN","passenger_member_number": "","passenger_name": "ZHAO/JUN","passenger_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","pay_channel": "授信","pay_type": "","pnr_number": "KNS48E","pre_order_id": "0","project_ext_info": "","rank_name": "","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125964400642558","service_fee": "20.00","settlement_time": "2025-04-21 11:03:16","sub_account_company_name": "上海科创银行有限公司","sub_company_no": "","supplier_order_id": "1606402793172","supplier_ticket_number": "160-6402793172","tax": "416.00","ticket_fee": "1550.00","ticket_id_text": "","total_fee": "1966.00","transaction_type": 0,"travel_purpose": "用车原因","trip_description": "出差","trip_reason": "Client visit & MDP","unique_key": "1125964402485575-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "东方航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125964932485746","approval_normal_history": "2025-04-25 10:48:24赵俊(134****0980)赵俊 提交给 敖宇翔,2025-04-25 12:01:37敖宇翔(138****7165)敖宇翔 确认审批完成","arrival_airport_code": "HKG","arrival_airport_name": "香港国际机场","arrival_city_id": "357","arrival_city_name": "中国香港","arrival_continent": "亚洲","arrival_country": "中国香港","arrival_time": "2025-04-27 19:05:00","before_cut_service_fee": 0,"bill_id": 1125965578069534,"booking_date": "2025-04-25 23:50:08","booking_dep_code": "9000103","booking_dep_name": "PES Team","booking_member_id": 1125906580026581,"booking_member_name": "赵俊","booking_member_number": "","booking_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","budget_center_code": "","budget_center_id": "0","budget_center_name": "","budget_center_parent_path_name": "","cabin_code": "Y","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "3123.00","construction_cost": "0","create_time": "2025-04-25 23:50:08","days_in_advance": 2,"department": "PES Team","department_id": "1125909095755529","departure_airport_code": "PVG","departure_airport_name": "浦东机场","departure_city_id": "4","departure_city_name": "上海","departure_continent": "亚洲","departure_country": "中国","departure_time": "2025-04-27 16:20:00","employee_number": "","ex_info_01": "","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 3103.0,"extend_info": "","extra_info": "","final_departure_time": "2025-04-27 16:20:00","flight_number": "MU505","flight_segment_number": 1,"flight_segment_travel": "上海-中国香港","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "上海科创银行有限公司","group_2_code": "9","group_2_name": "上海总行","group_3_code": "9000103","group_3_name": "PES Team","group_4_code": "","group_4_name": "","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125964938714516,"institution_name": "因公出差-1125964932485746","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125906580026581","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965009104370","origin_order_id": "1125965009104370","origin_ticket_id": "1125965009069081","out_legal_entity_id": "","out_requisition_id": "","parent_institution_id": 1125920278315109,"parent_institution_name": "因公出差","passenger_dep_code": "9000103","passenger_dep_name": "PES Team","passenger_group_1_code": "1","passenger_group_1_name": "上海科创银行有限公司","passenger_group_2_code": "9","passenger_group_2_name": "上海总行","passenger_group_3_code": "9000103","passenger_group_3_name": "PES Team","passenger_group_4_code": "","passenger_group_4_name": "","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125906580026581,"passenger_member_name": "ZHAO/JUN","passenger_member_number": "","passenger_name": "ZHAO/JUN","passenger_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","pay_channel": "授信","pay_type": "","pnr_number": "JW99KJ","pre_order_id": "0","project_ext_info": "","rank_name": "","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125964932485746","service_fee": "20.00","settlement_time": "2025-04-25 23:50:08","sub_account_company_name": "上海科创银行有限公司","sub_company_no": "","supplier_order_id": "7816402793337","supplier_ticket_number": "781-6402793337","tax": "193.00","ticket_fee": "2910.00","ticket_id_text": "","total_fee": "3103.00","transaction_type": 0,"travel_purpose": "用车原因","trip_description": "访","trip_reason": "客户拜访","unique_key": "1125965009069081-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "深圳航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125964932485746","approval_normal_history": "2025-04-25 10:48:24赵俊(134****0980)赵俊 提交给 敖宇翔,2025-04-25 12:01:37敖宇翔(138****7165)敖宇翔 确认审批完成","arrival_airport_code": "HKG","arrival_airport_name": "香港国际机场","arrival_city_id": "357","arrival_city_name": "中国香港","arrival_continent": "亚洲","arrival_country": "中国香港","arrival_time": "2025-04-30 18:10:00","before_cut_service_fee": 0,"bill_id": 1125965578069534,"booking_date": "2025-04-25 23:54:48","booking_dep_code": "9000103","booking_dep_name": "PES Team","booking_member_id": 1125906580026581,"booking_member_name": "赵俊","booking_member_number": "","booking_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","budget_center_code": "","budget_center_id": "0","budget_center_name": "","budget_center_parent_path_name": "","cabin_code": "V","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "2333.00","construction_cost": "0","create_time": "2025-04-25 23:54:48","days_in_advance": 5,"department": "PES Team","department_id": "1125909095755529","departure_airport_code": "TFU","departure_airport_name": "天府国际机场","departure_city_id": "17","departure_city_name": "成都","departure_continent": "亚洲","departure_country": "中国","departure_time": "2025-04-30 15:30:00","employee_number": "","ex_info_01": "","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 2313.0,"extend_info": "","extra_info": "","final_departure_time": "2025-04-30 15:30:00","flight_number": "ZH8033","flight_segment_number": 1,"flight_segment_travel": "成都-中国香港","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "上海科创银行有限公司","group_2_code": "9","group_2_name": "上海总行","group_3_code": "9000103","group_3_name": "PES Team","group_4_code": "","group_4_name": "","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125964938714516,"institution_name": "因公出差-1125964932485746","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125906580026581","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965009333045","origin_order_id": "1125965009333045","origin_ticket_id": "1125965009398363","out_legal_entity_id": "","out_requisition_id": "","parent_institution_id": 1125920278315109,"parent_institution_name": "因公出差","passenger_dep_code": "9000103","passenger_dep_name": "PES Team","passenger_group_1_code": "1","passenger_group_1_name": "上海科创银行有限公司","passenger_group_2_code": "9","passenger_group_2_name": "上海总行","passenger_group_3_code": "9000103","passenger_group_3_name": "PES Team","passenger_group_4_code": "","passenger_group_4_name": "","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125906580026581,"passenger_member_name": "ZHAO/JUN","passenger_member_number": "","passenger_name": "ZHAO/JUN","passenger_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","pay_channel": "授信","pay_type": "","pnr_number": "JDXB22","pre_order_id": "0","project_ext_info": "","rank_name": "","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125964932485746","service_fee": "20.00","settlement_time": "2025-04-25 23:54:48","sub_account_company_name": "上海科创银行有限公司","sub_company_no": "","supplier_order_id": "4796402793338","supplier_ticket_number": "479-6402793338","tax": "193.00","ticket_fee": "2120.00","ticket_id_text": "","total_fee": "2313.00","transaction_type": 0,"travel_purpose": "用车原因","trip_description": "访客","trip_reason": "客户拜访","unique_key": "1125965009398363-0","upgrade_cost": "0"},{"added_cut_reason": "","added_es_cut_fee": 0,"added_goods_name": "","airline_simple_name": "东方航空","apply_change_time": "","apply_refund_time": "","approval_change_history": "","approval_history": "","approval_id": "1125965433690748","approval_normal_history": "2025-04-30 14:42:57赵俊(134****0980)赵俊 提交给 敖宇翔,2025-04-30 15:03:43敖宇翔(138****7165)敖宇翔 确认审批完成","arrival_airport_code": "PVG","arrival_airport_name": "浦东机场","arrival_city_id": "4","arrival_city_name": "上海","arrival_continent": "亚洲","arrival_country": "中国","arrival_time": "2025-05-06 15:40:00","before_cut_service_fee": 0,"bill_id": 1125965578069534,"booking_date": "2025-04-30 22:12:42","booking_dep_code": "9000103","booking_dep_name": "PES Team","booking_member_id": 1125906580026581,"booking_member_name": "赵俊","booking_member_number": "","booking_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","budget_center_code": "","budget_center_id": "0","budget_center_name": "","budget_center_parent_path_name": "","cabin_code": "N","cabin_name": "经济舱","cabin_type": 4,"change_handle_cost": "0","company_real_pay": "1377.00","construction_cost": "0","create_time": "2025-04-30 22:12:42","days_in_advance": 6,"department": "PES Team","department_id": "1125909095755529","departure_airport_code": "HKG","departure_airport_name": "香港国际机场","departure_city_id": "357","departure_city_name": "中国香港","departure_continent": "亚洲","departure_country": "中国香港","departure_time": "2025-05-06 12:50:00","employee_number": "","ex_info_01": "","ex_info_01_code": "","ex_info_02": "","ex_info_02_code": "","ex_info_03": "","ex_info_03_code": "","ex_info_04": "","ex_info_04_code": "","ex_info_05": "","ex_info_05_code": "","ex_info_06": "","ex_info_06_code": "","ex_info_07": "","ex_info_07_code": "","ex_info_08": "","ex_info_08_code": "","excluding_service_fee": 1357.0,"extend_info": "","extra_info": "","final_departure_time": "2025-05-06 12:50:00","flight_number": "MU502","flight_segment_number": 1,"flight_segment_travel": "中国香港-上海","flight_travel_type": 1,"fuelCost": "0","group_1_code": "1","group_1_name": "上海科创银行有限公司","group_2_code": "9","group_2_name": "上海总行","group_3_code": "9000103","group_3_name": "PES Team","group_4_code": "","group_4_name": "","group_5_code": "","group_5_name": "","group_6_code": "","group_6_name": "","group_7_code": "","group_7_name": "","group_8_code": "","group_8_name": "","group_9_code": "","group_9_name": "","institution_id": 1125965435134227,"institution_name": "因公出差-1125965433690748","invoice_entity_info": "北京小桔国际旅行社有限公司","is_agreement": "否","is_traveler": "","lastupdate_time": "","legal_entity_id": 0,"legal_entity_name": "","member_id": "1125906580026581","order_fix_settle_time": "","order_fix_type": 0,"order_id": "1125965465511295","origin_order_id": "1125965465511295","origin_ticket_id": "1125965465485744","out_legal_entity_id": "","out_requisition_id": "","parent_institution_id": 1125920278315109,"parent_institution_name": "因公出差","passenger_dep_code": "9000103","passenger_dep_name": "PES Team","passenger_group_1_code": "1","passenger_group_1_name": "上海科创银行有限公司","passenger_group_2_code": "9","passenger_group_2_name": "上海总行","passenger_group_3_code": "9000103","passenger_group_3_name": "PES Team","passenger_group_4_code": "","passenger_group_4_name": "","passenger_group_5_code": "","passenger_group_5_name": "","passenger_group_6_code": "","passenger_group_6_name": "","passenger_group_7_code": "","passenger_group_7_name": "","passenger_group_8_code": "","passenger_group_8_name": "","passenger_group_9_code": "","passenger_group_9_name": "","passenger_legal_entity_id": 0,"passenger_legal_entity_name": "","passenger_member_id": 1125906580026581,"passenger_member_name": "ZHAO/JUN","passenger_member_number": "","passenger_name": "ZHAO/JUN","passenger_parent_path_dep_name": "上海科创银行有限公司>上海总行>PES Team","pay_channel": "授信","pay_type": "","pnr_number": "QX60BM","pre_order_id": "0","project_ext_info": "","rank_name": "","rc_book": "","rc_level": "","rc_lowPrice": "","rc_time_period": "","reason": "","rebook": "","refund_handle_cost": "0","requisition_id": "1125965433690748","service_fee": "20.00","settlement_time": "2025-04-30 22:12:42","sub_account_company_name": "上海科创银行有限公司","sub_company_no": "","supplier_order_id": "7815472741284","supplier_ticket_number": "7815472741284","tax": "356.00","ticket_fee": "1001.00","ticket_id_text": "","total_fee": "1357.00","transaction_type": 0,"travel_purpose": "用车原因","trip_description": "出差","trip_reason": "访客","unique_key": "1125965465485744-0","upgrade_cost": "0"}],"total": 6},"message": "成功","odin": "","status": 0,"traceid": "0a88ecca682fe7890f877d1800167b86"}"""

}