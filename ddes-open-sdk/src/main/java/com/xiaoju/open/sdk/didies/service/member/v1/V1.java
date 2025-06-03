package com.xiaoju.open.sdk.didies.service.member.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
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
import com.xiaoju.open.sdk.didies.service.member.v1.model.UpdateMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.UpdateMemberRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 用户新增
    * 注意  - 常驻地目前只支持如“北京”、“北京市”、“北京市海淀区”格式，不支持“海淀区”此类格式，如果传参中带了区县则必须把“市”、“区“、”县”字段都带上。 - 同一公司。连续添加员工，需要间隔 150ms - 人员唯一值可以在手机号，员工编号，邮箱中指定一个，如果多个一起传递时，会一起校验企业级内是否有存在重复的信息并报错返回。
    * @param createMemberRequest  (required)
    * @return CreateMemberApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreateMemberApiReply createMember(CreateMemberRequest createMemberRequest) throws Exception {
        
        return doPost(createMemberRequest, "/river/Member/single", CreateMemberApiReply.class, 0);
    }
    /**
    * 用户删除
    * 说明： * 用于删除滴滴ES后台人员信息；
    * @param delMemberRequest  (required)
    * @return DelMemberApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public DelMemberApiReply delMember(DelMemberRequest delMemberRequest) throws Exception {
        
        return doPost(delMemberRequest, "/river/Member/del", DelMemberApiReply.class, 0);
    }
    /**
    * 员工明细
    * 注意： * 员工工号、手机号是精确查询，名字为模糊查询; * offset必须可以被length整除，如offset&#x3D;0,length&#x3D;100,0可以被100整除，合法；offset&#x3D;1,length&#x3D;100,1不能被100整除，不合法;   说明：   * 用户如果传了 last_id，除了 status，其他检索条件会失效;  * 当 status 为空或者没传，返回的为正常、离职和未绑手机号的员工;  * birth_date加密格式，返回的参数需要重新提供；
    * @param getMemberDetailRequest  (required)
    * @return GetMemberDetailApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetMemberDetailApiReply getMemberDetail(GetMemberDetailRequest getMemberDetailRequest) throws Exception {
        return doGet(getMemberDetailRequest, "/river/Member/detail", GetMemberDetailApiReply.class, 0);
        
    }
    /**
    * 员工限额查询
    * 用于查询滴滴ES后台已有的人员的限额信息。   说明：   * 限额查询请求的开始日期和结束日期时间跨度不能大于六个月。若只传开始日期，则返回结果为开始日期后当月；若只传结束日期，则返回结果为结束日期当月；  * 按指定类型返回对应查询日期内的限额信息；  * 若限额类型为自然月，开始、结束日期应传自然月开始日、结束日；若未传自然月开始日、结束日，则按自然月查询（只取年+月份），如：2020-05-03 至 2020-06-22，则按照2020-05-01 至 2020-06-31查询；
    * @param getMemberQuotaRequest  (required)
    * @return GetMemberQuotaApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetMemberQuotaApiReply getMemberQuota(GetMemberQuotaRequest getMemberQuotaRequest) throws Exception {
        return doGet(getMemberQuotaRequest, "/river/Member/getQuota", GetMemberQuotaApiReply.class, 0);
        
    }
    /**
    * 员工列表（批量查询）
    * 注意： * 员工工号、手机号是精确查询，名字为模糊查询; * offset必须可以被length整除，如offset&#x3D;0,length&#x3D;100,0可以被100整除，合法；offset&#x3D;1,length&#x3D;100,1不能被100整除，不合法   说明：   * 用户如果传了 last_id，除了 status，其他检索条件会失效，首次查询时需要从0开始传递;  * 当 status 为空或者没传，返回的为正常、离职和未绑手机号的员工; * birth_date加密格式，返回的参数需要重新提供;
    * @param listMemberRequest  (required)
    * @return ListMemberApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListMemberApiReply listMember(ListMemberRequest listMemberRequest) throws Exception {
        return doGet(listMemberRequest, "/river/Member/get", ListMemberApiReply.class, 0);
        
    }
    /**
    * 用户修改
    * 注意：  - 常驻地目前只支持如“北京”、“北京市”、“北京市海淀区”格式，不支持“海淀区”此类格式，如果传参中带了区县则必须把“市”、“区“、”县”字段都带上。  - 同一公司。连续添加员工，需要间隔 150ms
    * @param updateMemberRequest  (required)
    * @return UpdateMemberApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateMemberApiReply updateMember(UpdateMemberRequest updateMemberRequest) throws Exception {
        
        return doPost(updateMemberRequest, "/river/Member/edit", UpdateMemberApiReply.class, 0);
    }
}

