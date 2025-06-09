package com.xiaoju.open.sdk.didies.service.budgetcenter;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.CreateBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.CreateBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.DelBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.DelBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.GetBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.GetBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.UpdateBudgetCenterApiReply;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.UpdateBudgetCenterRequest;
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.V1;

public class BudgetCenter extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public BudgetCenter(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

