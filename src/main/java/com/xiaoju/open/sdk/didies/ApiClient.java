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
import com.xiaoju.open.sdk.didies.service.workspace.Workspace;
import lombok.Getter;

public class ApiClient {

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
   * @param config      配置信息
   * @param tokenHolder 自定义token缓存逻辑
   */
  public ApiClient(Config config, ITokenHolder tokenHolder) {
    this.config = config;
    this.tokenHolder = tokenHolder;
  }

  public AfterApproval afterapproval() {
    return new AfterApproval(tokenHolder, config);
  }

  public Approval approval() {
    return new Approval(tokenHolder, config);
  }

  public Auth auth() {
    return new Auth(tokenHolder, config);
  }

  public Bill bill() {
    return new Bill(tokenHolder, config);
  }

  public BudgetCenter budgetcenter() {
    return new BudgetCenter(tokenHolder, config);
  }

  public City city() {
    return new City(tokenHolder, config);
  }

  public Extend extend() {
    return new Extend(tokenHolder, config);
  }

  public LegalEntity legalentity() {
    return new LegalEntity(tokenHolder, config);
  }

  public Login login() {
    return new Login(tokenHolder, config);
  }

  public Member member() {
    return new Member(tokenHolder, config);
  }

  public Order order() {
    return new Order(tokenHolder, config);
  }

  public OutApproval outapproval() {
    return new OutApproval(tokenHolder, config);
  }

  public Rank rank() {
    return new Rank(tokenHolder, config);
  }

  public Regulation regulation() {
    return new Regulation(tokenHolder, config);
  }

  public Role role() {
    return new Role(tokenHolder, config);
  }

  public Traveler traveler() {
    return new Traveler(tokenHolder, config);
  }

  public Workspace workspace() {
    return new Workspace(tokenHolder, config);
  }

}

