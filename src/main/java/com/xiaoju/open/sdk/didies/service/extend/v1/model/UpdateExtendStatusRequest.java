package com.xiaoju.open.sdk.didies.service.extend.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.ExtendInfo;
import java.util.ArrayList;
import java.util.List;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateExtendStatusRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 档案code
     * 
     */
    @JsonProperty("root_code")
    private String rootCode;
    /**
     * 状态;1为正常，2为停用，3为删除
     * 
     */
    @JsonProperty("root_status")
    private Integer rootStatus;
    /**
     * 子档案列表，json字符串
     * 
     */
    @JsonProperty("item_list")
    private String itemList;
    /**
     * 子档案列表Obj(脚本转为json后赋值给item_list字段)
     * 
     */
    @JsonProperty("item_list__obj__")
    private List<ExtendInfo> itemListObj;
}

