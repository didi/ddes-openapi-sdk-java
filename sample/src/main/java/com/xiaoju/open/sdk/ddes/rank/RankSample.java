package com.xiaoju.open.sdk.ddes.rank;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.CreateRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.CreateRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.DelRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.DelRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.ListRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.ListRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.RankInfo;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.UpdateRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.UpdateRankRequest;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class RankSample {

  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);
//    createRankTest(client);
//    delRankTest(client);
//    listRankTest(client);
//    updateRankTest(client);

  }

  /**
   * 职级新增
   * <p>
   * 说明 - 用于新增职级信息；  注意 - 公司职级总数限制 500 个;   param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | out_rank_id | 外部职级编号
   * | string | N | 限制 30 字符 | | name | 职级名称 | string | Y | 最长 30 字符，只能输入汉字、字母、数字、下划线、连字符、空格、点、括号、加、减和等号 |
   */
  public static void createRankTest(ApiClient client) throws Exception {
    CreateRankRequest request = CreateRankRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(RankInfo.builder()
            .outRankId("123")
            .name("自定义")
            .build())
        .build();
    CreateRankApiReply response = client.rank().v1().createRank(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 职级删除
   * <p>
   * 说明 - 用于删除职级信息；  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | rank_id | 滴滴侧职级 ID | string | N | 滴滴侧职级
   * ID和外部职级编号二者之一必填 | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 |
   */
  public static void delRankTest(ApiClient client) throws Exception {
    DelRankRequest request = DelRankRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(RankInfo.builder()
            .rankId("1125966903187442")
            .build())
        .build();
    DelRankApiReply response = client.rank().v1().delRank(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 职级查询
   * <p>
   * 说明 - 用于查询职级的列表信息
   */
  public static void listRankTest(ApiClient client) throws Exception {
    ListRankRequest request = ListRankRequest.builder()
        .companyId("替换成自己的companyId")
        .offset(0)
        .length(1)
        .build();
    ListRankApiReply response = client.rank().v1().listRank(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 职级修改
   * <p>
   * 说明 - 用于修改职级信息；  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | rank_id | 滴滴侧职级 ID | string | N | 滴滴侧职级
   * ID和外部职级编号二者之一必填 | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 | | name | 职级名称 | string | Y | 最长 30 字符，只能输入汉字、字母、数字、下划线、连字符、空格、点、括号、加、减和等号 |
   */
  public static void updateRankTest(ApiClient client) throws Exception {
    UpdateRankRequest request = UpdateRankRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(RankInfo.builder()
            .rankId("1125966903187442")
            .outRankId("1234")
            .name("自定义_修改")
            .build())
        .build();

    UpdateRankApiReply response = client.rank().v1().updateRank(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }
}
