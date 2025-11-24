package com.xiaoju.open.sdk.didies.service.extend.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateExtendBatchRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 档案code，150字符以内
     * 
     */
    @JsonProperty("root_code")
    private String rootCode;
    /**
     * 档案名称，150字符以内
     * 
     */
    @JsonProperty("root_name")
    private String rootName;
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

