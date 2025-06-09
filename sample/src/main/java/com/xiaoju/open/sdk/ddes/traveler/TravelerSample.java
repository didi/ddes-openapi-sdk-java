package com.xiaoju.open.sdk.ddes.traveler;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;
import com.xiaoju.open.sdk.didies.service.member.enums.MemberGenderEnum;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.CreateTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.CreateTravelerRequest;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.DelTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.DelTravelerRequest;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.TravelCardInfo;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.TravelerInfo;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.UpdateTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.UpdateTravelerRequest;
import com.xiaoju.open.sdk.didies.utils.AesUtils;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

import java.util.ArrayList;
import java.util.List;

public class TravelerSample {

  // 敏感信息加密秘钥，需单独申请，和config中的signKey不同
  private static final String signKey = "your_sign_key";

  public static void main(String[] args) throws Exception {
    Config config = Config.builder()
        .clientId("your_client_id")
        .clientSecret("your_client_secret")
        .signKey("your_sign_key")
        .build();
    ApiClient client = new ApiClient(config);

  }

  /**
   * 外部出行人新增【请求参数组装比较繁琐】
   * <p>
   * 注意  - 用于事先同步外部出行人信息；   param字段列表 | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | phone | 外部出行人 手机号 | string | Y |  | |
   * name | 外部出行人姓名 | string | Y | 不大于 26 字符 | | english_surname | 英文姓 | string | N |  | | english_name | 英文名 | string | N | （英文姓 + 英文名 不大于 26 字符）
   * | | remark | 备注信息 | string | N | 不大于 64 字符 | | sex | 性别 | int | N | 0-空，1-男，2-女 | | out_traveler_id | 外部出行人唯一ID | string | N | 不大于 32 字符 | |
   * birth_date | 出生日期 | string | N | （YYYY-MM-DD），加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;
   * 2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | | card_list | 身份证件信息 | list&lt;card&gt; | N |  |   card list字段 | 字段名 | 字段说明 | 字段类型
   * | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | card_type | 证件类型 | int | Y | 枚举值数字：1. 身份证，2. 护照，3. 港澳台居民居住证，4. 台胞证，5. 军官证，6. 回乡证，7.
   * 外国人永久居留身份证&lt;br&gt;注意：身份证如果有值，则校验身份证长度必须合规。 | | card_no | 证件号码 | string | Y | 加密传输，不大于 26 字符 注：&lt;br&gt;
   * 1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | | expire_date | 证件有效期 | string | N
   * | YYYYMMDD （需加密） 加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） |
   */
  public static void createTravelerTest(ApiClient client) throws Exception {

    String encryptBirthDate = AesUtils.encrypt("1999-01-01", signKey, EncryptTypeEnum.AES128);
    String encryptCardNo = AesUtils.encrypt("5xxx", signKey, EncryptTypeEnum.AES128);
    String encryptExpireDate = AesUtils.encrypt("20300101", signKey, EncryptTypeEnum.AES128);

    List<TravelCardInfo> cardList = new ArrayList<>();
    cardList.add(TravelCardInfo.builder()
        .cardType(1)
        .cardNo(encryptCardNo)
        .expireDate(encryptExpireDate)
        .build());
    CreateTravelerRequest request = CreateTravelerRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(TravelerInfo.builder()
            .phone("18888888887")
            .name("测试_证件信息")
            .englishSurname("test")
            .englishName("test")
            .sex(MemberGenderEnum.MALE.getCode())
            .birthDate(encryptBirthDate)
            .cardList(cardList)
            .build())
        .build();
    CreateTravelerApiReply response = client.traveler().v1().createTraveler(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 外部出行人删除
   * <p>
   * 说明  - 用于删除外部出行人信息；   param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | traveler_id | 滴滴侧出行人ID | string | Y |  |
   */
  public static void delTravelerTest(ApiClient client) throws Exception {
    DelTravelerRequest request = DelTravelerRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(TravelerInfo.builder()
            .travelerId("1125966892396041")
            .build())
        .build();
    DelTravelerApiReply response = client.traveler().v1().delTraveler(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 外部出行人修改
   * <p>
   * 说明  - 用于修改外部出行人信息；  注意  - 修改接口不传或者传空代表不更新，对证件信息编辑时，如果想要新增证件类型，之前想要保留的证件类型数据也需要传输，不然会被清空；   **param字段列表** | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | |
   * ---- | ---- | ---- | ---- | ---- | | traveler_id | 滴滴侧出行人ID | string | Y | 滴滴侧出行人ID | | phone | 外部出行人 手机号 | string | Y | 外部出行人 手机号 | | name |
   * 外部出行人姓名 | string | Y | 不大于 26 字符 | | english_surname | 英文姓 | string | N |  | | english_name | 英文名 | string | N | （英文姓 + 英文名 不大于 26 字符） | |
   * remark | 备注信息 | string | N | 不大于 64 字符 | | sex | 性别 | int | N | 0-空，1-男，2-女 | | out_traveler_id | 外部出行人唯一ID | string | N | 不大于 32 字符 | |
   * birth_date | 出生日期 | string | N | （YYYY-MM-DD），加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;
   * 2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | | card_list | 身份证件信息 | list&lt;card&gt; | N |  | | force_clear_fields | 强制清空字段 |
   * []string | N | 目前只支持传 card_list |   card list字段 | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | card_type | 证件类型 | int
   * | Y | 枚举值数字：1. 身份证，2. 护照，3. 港澳台居民居住证，4. 台胞证，5. 军官证，6. 回乡证，7. 外国人永久居留身份证&lt;br&gt;注意：身份证如果有值，则校验身份证长度必须合规。 | | card_no | 证件号码 | string | Y |
   * 加密传输，不大于 26 字符 注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） | |
   * expire_date | 证件有效期 | string | N | YYYYMMDD （需加密） 加密传输注：&lt;br&gt;1、若采用AES256/AES128整体加密，此字段需明文传输，无需单独再加密&lt;br&gt;
   * 2、若不整体加密传输时，此字段只可采用AES128加密传输（AES128单独加密时，此接口密钥特殊，需单独申请） |
   */
  public static void updateTravelerTest(ApiClient client) throws Exception {
    String encryptBirthDate = AesUtils.encrypt("1999-01-01", signKey, EncryptTypeEnum.AES128);
    UpdateTravelerRequest request = UpdateTravelerRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(TravelerInfo.builder()
            .travelerId("1125966892396041")
            .phone("18888888889")
            .name("测试_修改不传cartList")
            .travelerId("1125966892396041")
            .birthDate(encryptBirthDate)
            .build())
        .build();
    UpdateTravelerApiReply response = client.traveler().v1().updateTraveler(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }
}
