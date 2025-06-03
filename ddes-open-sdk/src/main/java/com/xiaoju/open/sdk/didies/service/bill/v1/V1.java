package com.xiaoju.open.sdk.didies.service.bill.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.*;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 商旅、网约车账单确认
    * 
    * @param billConfirmRequest  (required)
    * @return BillConfirmApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public BillConfirmApiReply billConfirm(BillConfirmRequest billConfirmRequest) throws Exception {
        
        return doPost(billConfirmRequest, "/river/Bill/confirm", BillConfirmApiReply.class, 0);
    }
    /**
    * 调账查询结果
    * 响应参数同调账提交接口
    * @param getAdjustBillDataResultRequest  (required)
    * @return GetAdjustBillDataResultApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetAdjustBillDataResultApiReply getAdjustBillDataResult(GetAdjustBillDataResultRequest getAdjustBillDataResultRequest) throws Exception {
        
        return doPost(getAdjustBillDataResultRequest, "/river/Bill/queryAdjustBillDataResult", GetAdjustBillDataResultApiReply.class, 0);
    }
    /**
    * 已出账单(按业务类型拆分 - 代驾)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfDaiJiaRequest  (required)
    * @return GetBillDetailOfDaiJiaApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfDaiJiaApiReply getBillDetailOfDaiJia(GetBillDetailOfDaiJiaRequest getBillDetailOfDaiJiaRequest) throws Exception {
        return doGet(getBillDetailOfDaiJiaRequest, "/river/Bill/detail", GetBillDetailOfDaiJiaApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 国内机票)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfDomesticFlightRequest  (required)
    * @return GetBillDetailOfDomesticFlightApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfDomesticFlightApiReply getBillDetailOfDomesticFlight(GetBillDetailOfDomesticFlightRequest getBillDetailOfDomesticFlightRequest) throws Exception {
        return doGet(getBillDetailOfDomesticFlightRequest, "/river/Bill/detail", GetBillDetailOfDomesticFlightApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 国内酒店)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfDomesticHotelRequest  (required)
    * @return GetBillDetailOfDomesticHotelApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfDomesticHotelApiReply getBillDetailOfDomesticHotel(GetBillDetailOfDomesticHotelRequest getBillDetailOfDomesticHotelRequest) throws Exception {
        return doGet(getBillDetailOfDomesticHotelRequest, "/river/Bill/detail", GetBillDetailOfDomesticHotelApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 国际机票)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfInterFlightRequest  (required)
    * @return GetBillDetailOfInterFlightApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfInterFlightApiReply getBillDetailOfInterFlight(GetBillDetailOfInterFlightRequest getBillDetailOfInterFlightRequest) throws Exception {
        return doGet(getBillDetailOfInterFlightRequest, "/river/Bill/detail", GetBillDetailOfInterFlightApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 海外酒店)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfInterHotelRequest  (required)
    * @return GetBillDetailOfInterHotelApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfInterHotelApiReply getBillDetailOfInterHotel(GetBillDetailOfInterHotelRequest getBillDetailOfInterHotelRequest) throws Exception {
        return doGet(getBillDetailOfInterHotelRequest, "/river/Bill/detail", GetBillDetailOfInterHotelApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 增值手工单)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfManualOrderRequest  (required)
    * @return GetBillDetailOfManualOrderApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfManualOrderApiReply getBillDetailOfManualOrder(GetBillDetailOfManualOrderRequest getBillDetailOfManualOrderRequest) throws Exception {
        return doGet(getBillDetailOfManualOrderRequest, "/river/Bill/detail", GetBillDetailOfManualOrderApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 出租车)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfTaxiRequest  (required)
    * @return GetBillDetailOfTaxiApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfTaxiApiReply getBillDetailOfTaxi(GetBillDetailOfTaxiRequest getBillDetailOfTaxiRequest) throws Exception {
        return doGet(getBillDetailOfTaxiRequest, "/river/Bill/detail", GetBillDetailOfTaxiApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 火车票)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfTrainTicketRequest  (required)
    * @return GetBillDetailOfTrainTicketApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfTrainTicketApiReply getBillDetailOfTrainTicket(GetBillDetailOfTrainTicketRequest getBillDetailOfTrainTicketRequest) throws Exception {
        return doGet(getBillDetailOfTrainTicketRequest, "/river/Bill/detail", GetBillDetailOfTrainTicketApiReply.class, 0);
        
    }
    /**
    * 已出账单(按业务类型拆分 - 网约车)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getBillDetailOfWangYCRequest  (required)
    * @return GetBillDetailOfWangYCApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillDetailOfWangYCApiReply getBillDetailOfWangYC(GetBillDetailOfWangYCRequest getBillDetailOfWangYCRequest) throws Exception {
        return doGet(getBillDetailOfWangYCRequest, "/river/Bill/detail", GetBillDetailOfWangYCApiReply.class, 0);
        
    }
    /**
    * 网约车、商旅账单树查询
    * 
    * @param getBillStructureRequest  (required)
    * @return GetBillStructureApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillStructureApiReply getBillStructure(GetBillStructureRequest getBillStructureRequest) throws Exception {
        return doGet(getBillStructureRequest, "/river/Bill/getBillStructure", GetBillStructureApiReply.class, 0);
        
    }
    /**
    * 账单汇总查询-商旅、网约车、出租车
    * 
    * @param getBillSummaryRequest  (required)
    * @return GetBillSummaryApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetBillSummaryApiReply getBillSummary(GetBillSummaryRequest getBillSummaryRequest) throws Exception {
        return doGet(getBillSummaryRequest, "/river/Bill/summary", GetBillSummaryApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 代驾)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfDaiJiaRequest  (required)
    * @return GetNotGenBillDetailOfDaiJiaApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfDaiJiaApiReply getNotGenBillDetailOfDaiJia(GetNotGenBillDetailOfDaiJiaRequest getNotGenBillDetailOfDaiJiaRequest) throws Exception {
        return doGet(getNotGenBillDetailOfDaiJiaRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfDaiJiaApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 国内机票)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfFlightRequest  (required)
    * @return GetNotGenBillDetailOfFlightApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfFlightApiReply getNotGenBillDetailOfFlight(GetNotGenBillDetailOfFlightRequest getNotGenBillDetailOfFlightRequest) throws Exception {
        return doGet(getNotGenBillDetailOfFlightRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfFlightApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 国内酒店)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfHotelRequest  (required)
    * @return GetNotGenBillDetailOfHotelApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfHotelApiReply getNotGenBillDetailOfHotel(GetNotGenBillDetailOfHotelRequest getNotGenBillDetailOfHotelRequest) throws Exception {
        return doGet(getNotGenBillDetailOfHotelRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfHotelApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 国际机票)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfInterFlightRequest  (required)
    * @return GetNotGenBillDetailOfInterFlightApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfInterFlightApiReply getNotGenBillDetailOfInterFlight(GetNotGenBillDetailOfInterFlightRequest getNotGenBillDetailOfInterFlightRequest) throws Exception {
        return doGet(getNotGenBillDetailOfInterFlightRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfInterFlightApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 海外酒店)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfInterHotelRequest  (required)
    * @return GetNotGenBillDetailOfInterHotelApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfInterHotelApiReply getNotGenBillDetailOfInterHotel(GetNotGenBillDetailOfInterHotelRequest getNotGenBillDetailOfInterHotelRequest) throws Exception {
        return doGet(getNotGenBillDetailOfInterHotelRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfInterHotelApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 增值手工单)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfManualOrderRequest  (required)
    * @return GetNotGenBillDetailOfManualOrderApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfManualOrderApiReply getNotGenBillDetailOfManualOrder(GetNotGenBillDetailOfManualOrderRequest getNotGenBillDetailOfManualOrderRequest) throws Exception {
        return doGet(getNotGenBillDetailOfManualOrderRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfManualOrderApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 出租车)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfTaxiRequest  (required)
    * @return GetNotGenBillDetailOfTaxiApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfTaxiApiReply getNotGenBillDetailOfTaxi(GetNotGenBillDetailOfTaxiRequest getNotGenBillDetailOfTaxiRequest) throws Exception {
        return doGet(getNotGenBillDetailOfTaxiRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfTaxiApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 火车票)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfTrainRequest  (required)
    * @return GetNotGenBillDetailOfTrainApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfTrainApiReply getNotGenBillDetailOfTrain(GetNotGenBillDetailOfTrainRequest getNotGenBillDetailOfTrainRequest) throws Exception {
        return doGet(getNotGenBillDetailOfTrainRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfTrainApiReply.class, 0);
        
    }
    /**
    * 未出账单(按业务类型拆分 - 网约车)
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getNotGenBillDetailOfWangYCRequest  (required)
    * @return GetNotGenBillDetailOfWangYCApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetNotGenBillDetailOfWangYCApiReply getNotGenBillDetailOfWangYC(GetNotGenBillDetailOfWangYCRequest getNotGenBillDetailOfWangYCRequest) throws Exception {
        return doGet(getNotGenBillDetailOfWangYCRequest, "/river/Bill/getNotGeneratedBillDetail", GetNotGenBillDetailOfWangYCApiReply.class, 0);
        
    }
    /**
    * 网约车、出租车交易明细 ~ 网约车
    * 因网约车和出租车返回数据类型问题，根据业务类型进行了拆分；
    * @param getTransactionBillDetailRequest  (required)
    * @return GetTransactionBillDetailApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetTransactionBillDetailApiReply getTransactionBillDetail(GetTransactionBillDetailRequest getTransactionBillDetailRequest) throws Exception {
        return doGet(getTransactionBillDetailRequest, "/river/Bill/transactionDetail", GetTransactionBillDetailApiReply.class, 0);
        
    }
    /**
    * 网约车、出租车交易明细 ~ 出租车
    * 注意：此接口无法直接在postman中调用，需删除/__rep__及之后的部分后才可发起请求；__rep__及之后的部分内容将会在代码生成时被删除
    * @param getTransactionBillDetailOfTaxiRequest  (required)
    * @return GetTransactionBillDetailOfTaxiApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetTransactionBillDetailOfTaxiApiReply getTransactionBillDetailOfTaxi(GetTransactionBillDetailOfTaxiRequest getTransactionBillDetailOfTaxiRequest) throws Exception {
        return doGet(getTransactionBillDetailOfTaxiRequest, "/river/Bill/transactionDetail", GetTransactionBillDetailOfTaxiApiReply.class, 0);
        
    }
    /**
    * 账单列表接口
    * 
    * @param listBillRequest  (required)
    * @return ListBillApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListBillApiReply listBill(ListBillRequest listBillRequest) throws Exception {
        return doGet(listBillRequest, "/river/Bill/get", ListBillApiReply.class, 0);
        
    }
    /**
    * 账单调整提交接口
    * 
    * @param updateAdjustBillDataRequest  (required)
    * @return UpdateAdjustBillDataApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateAdjustBillDataApiReply updateAdjustBillData(UpdateAdjustBillDataRequest updateAdjustBillDataRequest) throws Exception {
        
        return doPost(updateAdjustBillDataRequest, "/river/Bill/adjustBillData", UpdateAdjustBillDataApiReply.class, 0);
    }
}

