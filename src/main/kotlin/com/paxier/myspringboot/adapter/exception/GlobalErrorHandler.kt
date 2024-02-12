package com.paxier.myspringboot.adapter.exception

import org.slf4j.LoggerFactory
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler
    fun handle(ex: MethodArgumentNotValidException) {
        LOGGER.error(ex.message, ex)
        throw(ex)
    }

    @ExceptionHandler
    fun handle(ex: HttpMessageNotReadableException) {
        LOGGER.error(ex.message, ex)
        throw(ex)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(GlobalErrorHandler::class.java)
    }
}