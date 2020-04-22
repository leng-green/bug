package com.spc.base.exceptions

import com.spc.base.error.ErrorCodeEnum
import com.spc.base.error.ReserveErrorCodeEnum


class SpcCloudException : RuntimeException {

     var code: Int? = null

    constructor(cause: Throwable) : super(cause)

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(code: Int, message: String) : super(message) {
        this.code = code
    }

    constructor(codeEnum: ErrorCodeEnum, vararg arg: Any) : super(String.format(codeEnum.msg(), *arg)) {
        this.code = codeEnum.code()

    }

    constructor(codeEnum: ReserveErrorCodeEnum, vararg arg: Any) : super(String.format(codeEnum.msg(), *arg)) {
        this.code = codeEnum.code()

    }
}