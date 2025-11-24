package com.xiaoju.open.sdk.didies;


import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.core.LocalTokenHolder;
import com.xiaoju.open.sdk.didies.service.afterapproval.AfterApproval;
import com.xiaoju.open.sdk.didies.service.approval.Approval;
import com.xiaoju.open.sdk.didies.service.auth.Auth;
import com.xiaoju.open.sdk.didies.service.bill.Bill;
import com.xiaoju.open.sdk.didies.service.budgetcenter.BudgetCenter;
import com.xiaoju.open.sdk.didies.service.city.City;
import com.xiaoju.open.sdk.didies.service.extend.Extend;
import com.xiaoju.open.sdk.didies.service.legalentity.LegalEntity;
import com.xiaoju.open.sdk.didies.service.login.Login;
import com.xiaoju.open.sdk.didies.service.member.Member;
import com.xiaoju.open.sdk.didies.service.order.Order;
import com.xiaoju.open.sdk.didies.service.outapproval.OutApproval;
import com.xiaoju.open.sdk.didies.service.rank.Rank;
import com.xiaoju.open.sdk.didies.service.regulation.Regulation;
import com.xiaoju.open.sdk.didies.service.role.Role;
import com.xiaoju.open.sdk.didies.service.traveler.Traveler;
import com.xiaoju.open.sdk.didies.service.workplace.Workplace;
import lombok.Getter;

/**
 * ApiClient
 *
 * @author didi
 */
public class ApiClient {

    /**
    * 配置信息
    */
    @Getter
    private final Config config;
    /**
    * 一个客户端持有一个TokenHolder
    */
    private final ITokenHolder tokenHolder;
    /**
    * 默认使用LocalTokenHolder
    *
    * @param config 配置信息
    */
    public ApiClient(Config config) {
        this.config = config;
        this.tokenHolder = new LocalTokenHolder(this);
    }

    /**
    * 用户可自定义TokenHolder
    *
    * @param config 配置信息
    * @param tokenHolder  自定义token缓存逻辑
    */
    public ApiClient(Config config, ITokenHolder tokenHolder) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 获取AfterApproval
    *
    * @return AfterApproval
    */
    public AfterApproval afterapproval() {
        return new AfterApproval(tokenHolder, config);
    }
    /**
    * 获取Approval
    *
    * @return Approval
    */
    public Approval approval() {
        return new Approval(tokenHolder, config);
    }
    /**
    * 获取Auth
    *
    * @return Auth
    */
    public Auth auth() {
        return new Auth(tokenHolder, config);
    }
    /**
    * 获取Bill
    *
    * @return Bill
    */
    public Bill bill() {
        return new Bill(tokenHolder, config);
    }
    /**
    * 获取BudgetCenter
    *
    * @return BudgetCenter
    */
    public BudgetCenter budgetcenter() {
        return new BudgetCenter(tokenHolder, config);
    }
    /**
    * 获取City
    *
    * @return City
    */
    public City city() {
        return new City(tokenHolder, config);
    }
    /**
    * 获取Extend
    *
    * @return Extend
    */
    public Extend extend() {
        return new Extend(tokenHolder, config);
    }
    /**
    * 获取LegalEntity
    *
    * @return LegalEntity
    */
    public LegalEntity legalentity() {
        return new LegalEntity(tokenHolder, config);
    }
    /**
    * 获取Login
    *
    * @return Login
    */
    public Login login() {
        return new Login(tokenHolder, config);
    }
    /**
    * 获取Member
    *
    * @return Member
    */
    public Member member() {
        return new Member(tokenHolder, config);
    }
    /**
    * 获取Order
    *
    * @return Order
    */
    public Order order() {
        return new Order(tokenHolder, config);
    }
    /**
    * 获取OutApproval
    *
    * @return OutApproval
    */
    public OutApproval outapproval() {
        return new OutApproval(tokenHolder, config);
    }
    /**
    * 获取Rank
    *
    * @return Rank
    */
    public Rank rank() {
        return new Rank(tokenHolder, config);
    }
    /**
    * 获取Regulation
    *
    * @return Regulation
    */
    public Regulation regulation() {
        return new Regulation(tokenHolder, config);
    }
    /**
    * 获取Role
    *
    * @return Role
    */
    public Role role() {
        return new Role(tokenHolder, config);
    }
    /**
    * 获取Traveler
    *
    * @return Traveler
    */
    public Traveler traveler() {
        return new Traveler(tokenHolder, config);
    }
    /**
    * 获取Workplace
    *
    * @return Workplace
    */
    public Workplace workplace() {
        return new Workplace(tokenHolder, config);
    }

}
