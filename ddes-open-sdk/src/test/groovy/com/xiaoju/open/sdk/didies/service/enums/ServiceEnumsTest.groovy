package com.xiaoju.open.sdk.didies.service.enums

import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalResultEnum
import com.xiaoju.open.sdk.didies.service.bill.enums.BillStatusEnum
import com.xiaoju.open.sdk.didies.service.member.enums.MemberStatusEnum
import spock.lang.Specification
import spock.lang.Unroll

class ServiceEnumsTest extends Specification {

    // ==================== ApprovalResultEnum Tests ====================
    def "ApprovalResultEnum should have two values"() {
        expect:
        ApprovalResultEnum.values().length == 2
    }

    @Unroll
    def "ApprovalResultEnum #enum should have correct code and description"() {
        expect:
        approvalResult.code == expectedCode
        approvalResult.description == expectedDescription

        where:
        approvalResult              | expectedCode | expectedDescription
        ApprovalResultEnum.APPROVED | 1            | "通过"
        ApprovalResultEnum.REJECTED | 2            | "拒绝"
    }

    // ==================== BillStatusEnum Tests ====================
    def "BillStatusEnum should have four values"() {
        expect:
        BillStatusEnum.values().length == 4
    }

    @Unroll
    def "BillStatusEnum #enum should have correct code and description"() {
        expect:
        billStatus.code == expectedCode
        billStatus.description == expectedDescription

        where:
        billStatus                           | expectedCode | expectedDescription
        BillStatusEnum.GENERATING             | 0            | "生成中"
        BillStatusEnum.TO_BE_CONFIRMED        | 1            | "生成成功（待确认）"
        BillStatusEnum.GENERATION_FAILED      | 2            | "生成失败"
        BillStatusEnum.CONFIRMED              | 3            | "已确认"
    }

    // ==================== MemberStatusEnum Tests ====================
    def "MemberStatusEnum should have three values"() {
        expect:
        MemberStatusEnum.values().length == 3
    }

    @Unroll
    def "MemberStatusEnum #enum should have correct code and description"() {
        expect:
        memberStatus.code == expectedCode
        memberStatus.description == expectedDescription

        where:
        memberStatus                  | expectedCode | expectedDescription
        MemberStatusEnum.NORMAL       | 1            | "正常"
        MemberStatusEnum.RESIGNED     | 4            | "离职"
        MemberStatusEnum.UNBOUND_PHONE | 6            | "未绑定手机号"
    }

    // ==================== Common Enum Tests ====================
    @Unroll
    def "valueOf should return correct enum for #enumClass"() {
        expect:
        Enum.valueOf(enumClass, name) == expectedEnum

        where:
        enumClass              | name           | expectedEnum
        ApprovalResultEnum     | "APPROVED"     | ApprovalResultEnum.APPROVED
        ApprovalResultEnum     | "REJECTED"     | ApprovalResultEnum.REJECTED
        BillStatusEnum         | "GENERATING"   | BillStatusEnum.GENERATING
        BillStatusEnum         | "CONFIRMED"    | BillStatusEnum.CONFIRMED
        MemberStatusEnum       | "NORMAL"       | MemberStatusEnum.NORMAL
        MemberStatusEnum       | "RESIGNED"     | MemberStatusEnum.RESIGNED
    }

    @Unroll
    def "valueOf should throw exception for invalid name in #enumClass"() {
        when:
        Enum.valueOf(enumClass, "INVALID")

        then:
        thrown(IllegalArgumentException)

        where:
        enumClass << [ApprovalResultEnum, BillStatusEnum, MemberStatusEnum]
    }

    @Unroll
    def "all enums should have non-null code and description"() {
        expect:
        enumClass.values().every { it.code != null }
        enumClass.values().every { it.description != null }

        where:
        enumClass << [ApprovalResultEnum, BillStatusEnum, MemberStatusEnum]
    }

    @Unroll
    def "all codes in #enumClass should be unique"() {
        expect:
        enumClass.values().collect { it.code }.size() ==
            enumClass.values().collect { it.code }.unique().size()

        where:
        enumClass << [ApprovalResultEnum, BillStatusEnum, MemberStatusEnum]
    }

    @Unroll
    def "getter methods should work for #enumClass"() {
        expect:
        enumValue.getCode() != null
        enumValue.getDescription() != null

        where:
        enumClass          | enumValue
        ApprovalResultEnum | ApprovalResultEnum.APPROVED
        BillStatusEnum     | BillStatusEnum.GENERATING
        MemberStatusEnum   | MemberStatusEnum.NORMAL
    }

    def "enum values should be in correct order"() {
        expect:
        ApprovalResultEnum.values()[0] == ApprovalResultEnum.APPROVED
        ApprovalResultEnum.values()[1] == ApprovalResultEnum.REJECTED

        BillStatusEnum.values()[0] == BillStatusEnum.GENERATING
        BillStatusEnum.values()[3] == BillStatusEnum.CONFIRMED

        MemberStatusEnum.values()[0] == MemberStatusEnum.NORMAL
        MemberStatusEnum.values()[2] == MemberStatusEnum.UNBOUND_PHONE
    }

    def "enum descriptions should contain Chinese characters"() {
        expect:
        ApprovalResultEnum.APPROVED.description == "通过"
        ApprovalResultEnum.REJECTED.description == "拒绝"

        BillStatusEnum.GENERATING.description == "生成中"
        BillStatusEnum.TO_BE_CONFIRMED.description.contains("待确认")

        MemberStatusEnum.NORMAL.description == "正常"
        MemberStatusEnum.RESIGNED.description == "离职"
    }

    def "enum codes should be integers"() {
        expect:
        ApprovalResultEnum.APPROVED.code instanceof Integer
        BillStatusEnum.GENERATING.code instanceof Integer
        MemberStatusEnum.NORMAL.code instanceof Integer
    }
}
