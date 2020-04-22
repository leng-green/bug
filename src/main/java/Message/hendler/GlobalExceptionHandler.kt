package com.spc.file.core.hendler

import com.spc.base.error.ErrorCodeEnum
import com.spc.base.exceptions.SpcCloudException
import com.spc.base.resp.SpcResponse
import feign.RetryableException

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.nio.file.AccessDeniedException

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getILoggerFactory().getLogger(this.javaClass.simpleName)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.OK)
    fun illegalArgumentException(e: IllegalArgumentException): SpcResponse {
        if (logger.isErrorEnabled) logger.error("参数非法异常:${e.message}")
        return SpcResponse.failure(ErrorCodeEnum.GL99990100.code(), ErrorCodeEnum.GL99990100.msg())
    }


    @ExceptionHandler(AccessDeniedException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun unAuthorizedException(e: AccessDeniedException): SpcResponse {
        if (logger.isErrorEnabled) logger.error("无权限访问:${e.message}")
        return SpcResponse.failure(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg())
    }

    @ExceptionHandler(SpcCloudException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun appSecretException(e: SpcCloudException): SpcResponse {
        if (logger.isErrorEnabled) logger.error("文件服务异常:${e.message}")
        return SpcResponse.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.message)
    }

    @ExceptionHandler(RetryableException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun retryableException(e: RetryableException):SpcResponse{
      if (logger.isErrorEnabled) {
        logger.error("服务调用失败,详情：${e.message}")
      }
      return SpcResponse.failure(500,HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun defaultException(e: Exception): SpcResponse {
      if (logger.isErrorEnabled) logger.error("业务异常,详情：${e.message}")
      return SpcResponse(500,"服务器异常")
    }
}