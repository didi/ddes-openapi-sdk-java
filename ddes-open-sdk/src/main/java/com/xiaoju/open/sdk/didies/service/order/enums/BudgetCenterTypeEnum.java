package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum BudgetCenterTypeEnum {

    DEPARTMENT(1, "部门"),
    PROJECT(2, "项目");

    private final Integer code;
    private final String description;

    BudgetCenterTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
