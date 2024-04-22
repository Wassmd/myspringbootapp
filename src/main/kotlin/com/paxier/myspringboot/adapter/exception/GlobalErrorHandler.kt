package com.paxier.myspringboot.adapter.exception

import com.paxier.myspringboot.application.exception.InstructorNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    @ExceptionHandler
    fun handle(ex: InstructorNotFoundException): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(GlobalErrorHandler::class.java)
    }
}