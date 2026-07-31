package com.xiaoju.open.sdk.didies.replay

import com.xiaoju.open.sdk.didies.ApiClient

/**
 * 回放 entry：uri -> 接口元数据（对齐 Go replayEntry）。
 *
 * build:  从 fixture.in 构造 Request（river 走逐字段反射，open-apis 走 param_json 注入）。
 * call:   调用 service 方法，返回 ApiReply（其 errno 用于断言）。
 * reply:  从 ApiReply 提取 (errno, data)（字段覆盖对比的目标）。
 */
class ReplayEntry {
    /** river / open-apis */
    String family
    /** in -> Request；失败抛异常，调用方捕获计入 buildFail */
    Closure build
    /** (client, request) -> ApiReply；失败抛异常，调用方捕获计入 callFail */
    Closure call
    /** resp -> [errno, data]（errno 可 null，data 可 null） */
    Closure reply
}
