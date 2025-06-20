package com.xiaoju.open.sdk.ddes.member;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;
import com.xiaoju.open.sdk.didies.service.member.enums.MemberGenderEnum;
import com.xiaoju.open.sdk.didies.service.member.enums.MemberIdCardTypeEnum;
import com.xiaoju.open.sdk.didies.service.member.enums.MemberTypeEnum;
import com.xiaoju.open.sdk.didies.service.member.v1.model.CardInfo;
import com.xiaoju.open.sdk.didies.service.member.v1.model.CreateMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.CreateMemberRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.DelMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.DelMemberRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberDetailApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberDetailRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberQuotaApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberQuotaRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.ListMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.ListMemberRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.MemberInfo;
import com.xiaoju.open.sdk.didies.service.member.v1.model.UpdateMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.UpdateMemberRequest;
import com.xiaoju.open.sdk.didies.utils.AesUtils;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

import java.util.ArrayList;
import java.util.List;

public class MemberSample {

  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);

//    createMemberTest(client);
//    delMemberTest(client);
//    getMemberDetailTest(client);
//    getMemberQuotaTest(client);
//    listMemberTest(client);
//    updateMemberTest(client);
  }


  /**
   * 用户新增
   * <p>
   * 注意  - 常驻地目前只支持如“北京”、“北京市”、“北京市海淀区”格式，不支持“海淀区”此类格式，如果传参中带了区县则必须把“市”、“区“、”县”字段都带上。 - 同一公司。连续添加员工，需要间隔 150ms -
   * 人员唯一值可以在手机号，员工编号，邮箱中指定一个，如果多个一起传递时，会一起校验企业级内是否有存在重复的信息并报错返回。
   */
  public static void createMemberTest(ApiClient client) throws Exception {

    String signKey = "your_sign_key"; // 请注意：这里的signKey和config中的signKey不一样,需联系客服单独申请
    String encryptCardNo = AesUtils.encrypt("511xxxxxxxxxxxxxx4672", signKey, EncryptTypeEnum.AES128); // 如果接口采用整体加密，无需要加密此信息
    List<CardInfo> cardList = new ArrayList<>();
    cardList.add(CardInfo.builder().cardType(MemberIdCardTypeEnum.ID_CARD.getCode().toString()).cardNo(encryptCardNo).build());
    CreateMemberRequest request = CreateMemberRequest.builder()
        .companyId("替换成自己的companyId")
        .dataObj(MemberInfo.builder()
            .realname("自定义_")
            .email("xxxx@qq.com")
            .memberType(MemberTypeEnum.EMAIL.getCode())
            .cardList(cardList)
            .build())
        .build();
    CreateMemberApiReply response = client.member().v1().createMember(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 用户删除
   * <p>
   * 说明： * 用于删除滴滴ES后台人员信息；
   */
  public static void delMemberTest(ApiClient client) throws Exception {
    DelMemberRequest request = DelMemberRequest.builder()
        .companyId("替换成自己的companyId")
        .memberId("1125966624062758")
        .build();

    DelMemberApiReply response = client.member().v1().delMember(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 员工明细
   * <p>
   * 注意： * 员工工号、手机号是精确查询，名字为模糊查询; * offset必须可以被length整除，如offset&#x3D;0,length&#x3D;100,0可以被100整除，合法；offset&#x3D;1,length&#x3D;100,1不能被100整除，不合法;
   * 说明：   * 用户如果传了 last_id，除了 status，其他检索条件会失效;  * 当 status 为空或者没传，返回的为正常、离职和未绑手机号的员工;  * birth_date加密格式，返回的参数需要重新提供；
   */
  public static void getMemberDetailTest(ApiClient client) throws Exception {
    GetMemberDetailRequest request = GetMemberDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .memberId("1125966624062758")
        .build();
    GetMemberDetailApiReply response = client.member().v1().getMemberDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 员工限额查询
   * <p>
   * 用于查询滴滴ES后台已有的人员的限额信息。   说明：   * 限额查询请求的开始日期和结束日期时间跨度不能大于六个月。若只传开始日期，则返回结果为开始日期后当月；若只传结束日期，则返回结果为结束日期当月；  * 按指定类型返回对应查询日期内的限额信息；  *
   * 若限额类型为自然月，开始、结束日期应传自然月开始日、结束日；若未传自然月开始日、结束日，则按自然月查询（只取年+月份），如：2020-05-03 至 2020-06-22，则按照2020-05-01 至 2020-06-31查询；
   */
  public static void getMemberQuotaTest(ApiClient client) throws Exception {
    GetMemberQuotaRequest request = GetMemberQuotaRequest.builder()
        .companyId("替换成自己的companyId")
        .memberIds("1125966624062758")
        .build();
    GetMemberQuotaApiReply response = client.member().v1().getMemberQuota(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 员工列表（批量查询）
   * <p>
   * 注意： * 员工工号、手机号是精确查询，名字为模糊查询; * offset必须可以被length整除，如offset&#x3D;0,length&#x3D;100,0可以被100整除，合法；offset&#x3D;1,length&#x3D;100,1不能被100整除，不合法
   * 说明：   * 用户如果传了 last_id，除了 status，其他检索条件会失效，首次查询时需要从0开始传递;  * 当 status 为空或者没传，返回的为正常、离职和未绑手机号的员工; * birth_date加密格式，返回的参数需要重新提供;
   */
  public static void listMemberTest(ApiClient client) throws Exception {
    ListMemberRequest request = ListMemberRequest.builder()
        .companyId("替换成自己的companyId")
        .offset(0)
        .length(1)
        .build();
    ListMemberApiReply response = client.member().v1().listMember(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 用户修改【缺响应示例】
   * <p>
   * 注意：  - 常驻地目前只支持如“北京”、“北京市”、“北京市海淀区”格式，不支持“海淀区”此类格式，如果传参中带了区县则必须把“市”、“区“、”县”字段都带上。  - 同一公司。连续添加员工，需要间隔 150ms
   */
  public static void updateMemberTest(ApiClient client) throws Exception {

    UpdateMemberRequest request = UpdateMemberRequest.builder()
        .companyId("替换成自己的companyId")
        .memberId(1125966624062758L)
        .dataObj(MemberInfo.builder()
            .realname("测试")
            .sex(MemberGenderEnum.MALE.getCode())
            .build())
        .build();
    UpdateMemberApiReply response = client.member().v1().updateMember(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }
}
