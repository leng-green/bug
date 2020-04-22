package com.spc.base.resp


// 定义返回（状态 消息 内容）
data class SpcResponse(
  var status: Int? = null,
  var message: String? = null,
  var content: Any? = null
) {
  // 静态方法（成功 失败）
  companion object {

    @JvmStatic
    fun success(status: Int = 200, msg: String = "", content: Any? = null): SpcResponse {
      return SpcResponse(status, msg, content)
    }

    @JvmStatic
    fun failure(status: Int, msg: String?): SpcResponse {
      return SpcResponse(status, msg)
    }
  }
}
