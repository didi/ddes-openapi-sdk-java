package com.xiaoju.open.sdk.didies.service.bill;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.BillConfirmApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.BillConfirmRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetAdjustBillDataResultApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetAdjustBillDataResultRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfDaiJiaApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfDaiJiaRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfDomesticFlightApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfDomesticFlightRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfDomesticHotelApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfDomesticHotelRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfInterFlightApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfInterFlightRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfInterHotelApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfInterHotelRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfManualOrderApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfManualOrderRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfTaxiApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfTaxiRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfTrainTicketApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfTrainTicketRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfWangYCApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillDetailOfWangYCRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillStructureApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillStructureRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillSummaryApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetBillSummaryRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfDaiJiaApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfDaiJiaRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfFlightApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfFlightRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfHotelApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfHotelRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfInterFlightApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfInterFlightRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfInterHotelApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfInterHotelRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfManualOrderApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfManualOrderRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfTaxiApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfTaxiRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfTrainApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfTrainRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfWangYCApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetNotGenBillDetailOfWangYCRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetTransactionBillDetailApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetTransactionBillDetailOfTaxiApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetTransactionBillDetailOfTaxiRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.GetTransactionBillDetailRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.ListBillApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.ListBillRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.UpdateAdjustBillDataApiReply;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.UpdateAdjustBillDataRequest;
import com.xiaoju.open.sdk.didies.service.bill.v1.V1;

public class Bill extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Bill(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

