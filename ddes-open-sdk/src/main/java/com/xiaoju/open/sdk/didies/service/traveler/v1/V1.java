package com.xiaoju.open.sdk.didies.service.traveler.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.CreateTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.CreateTravelerRequest;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.DelTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.DelTravelerRequest;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.UpdateTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.UpdateTravelerRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 外部出行人新增【请求参数组装比较繁琐】
    * 注意  - 用于事先同步外部出行人信息；   param字段列表 | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | phone | 外部出行人 手机号 | string | Y |  | | name | 外部出行人姓名 | string | Y | 不大于 26 字符 | | english_surname | 英文姓 | string | N |  | | english_name | 英文名 | string | N | （英文姓 + 英文名 不大于 26 字符） | | remark | 备注信息 | string | N | 不大于 64 字符 | | sex | 性别 | int | N | 0-空，1-男，2-女 | | out_traveler_id | 外部出行人唯一ID | string | N | 不大于 32 字符 | | birth_date | 出生日期 | string | N | （YYYY-MM-DD），加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | | card_list | 身份证件信息 | list&lt;card&gt; | N |  |   card list字段 | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | card_type | 证件类型 | int | Y | 枚举值数字：1. 身份证，2. 护照，3. 港澳台居民居住证，4. 台胞证，5. 军官证，6. 回乡证，7. 外国人永久居留身份证&lt;br&gt;注意：身份证如果有值，则校验身份证长度必须合规。 | | card_no | 证件号码 | string | Y | 加密传输，不大于 26 字符 注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | | expire_date | 证件有效期 | string | N | YYYYMMDD （需加密） 加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | 
    * @param createTravelerRequest  (required)
    * @return CreateTravelerApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreateTravelerApiReply createTraveler(CreateTravelerRequest createTravelerRequest) throws Exception {
        
        return doPost(createTravelerRequest, "/open-apis/v1/traveler/create", CreateTravelerApiReply.class, 0);
    }
    /**
    * 外部出行人删除
    * 说明  - 用于删除外部出行人信息；   param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | traveler_id | 滴滴侧出行人ID | string | Y |  |
    * @param delTravelerRequest  (required)
    * @return DelTravelerApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public DelTravelerApiReply delTraveler(DelTravelerRequest delTravelerRequest) throws Exception {
        
        return doPost(delTravelerRequest, "/open-apis/v1/traveler/del", DelTravelerApiReply.class, 0);
    }
    /**
    * 外部出行人修改
    * 说明  - 用于修改外部出行人信息；  注意  - 修改接口不传或者传空代表不更新，对证件信息编辑时，如果想要新增证件类型，之前想要保留的证件类型数据也需要传输，不然会被清空；   **param字段列表** | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | traveler_id | 滴滴侧出行人ID | string | Y | 滴滴侧出行人ID | | phone | 外部出行人 手机号 | string | Y | 外部出行人 手机号 | | name | 外部出行人姓名 | string | Y | 不大于 26 字符 | | english_surname | 英文姓 | string | N |  | | english_name | 英文名 | string | N | （英文姓 + 英文名 不大于 26 字符） | | remark | 备注信息 | string | N | 不大于 64 字符 | | sex | 性别 | int | N | 0-空，1-男，2-女 | | out_traveler_id | 外部出行人唯一ID | string | N | 不大于 32 字符 | | birth_date | 出生日期 | string | N | （YYYY-MM-DD），加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | | card_list | 身份证件信息 | list&lt;card&gt; | N |  | | force_clear_fields | 强制清空字段 | []string | N | 目前只支持传 card_list |   card list字段 | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | card_type | 证件类型 | int | Y | 枚举值数字：1. 身份证，2. 护照，3. 港澳台居民居住证，4. 台胞证，5. 军官证，6. 回乡证，7. 外国人永久居留身份证&lt;br&gt;注意：身份证如果有值，则校验身份证长度必须合规。 | | card_no | 证件号码 | string | Y | 加密传输，不大于 26 字符 注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | | expire_date | 证件有效期 | string | N | YYYYMMDD （需加密） 加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | 
    * @param updateTravelerRequest  (required)
    * @return UpdateTravelerApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateTravelerApiReply updateTraveler(UpdateTravelerRequest updateTravelerRequest) throws Exception {
        
        return doPost(updateTravelerRequest, "/open-apis/v1/traveler/update", UpdateTravelerApiReply.class, 0);
    }
}

