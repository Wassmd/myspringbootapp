package com.paxier.myspringboot.adapter.exception

import com.paxier.myspringboot.application.exception.InstructorNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalErrorHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun handle(ex: InstructorNotFoundException): ResponseEntity<Any> =
        ResponseEntity.of(
            ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex::class.simpleName ?: "-"
            ).apply {
                title = ex.message
                setProperty("validationErrors", "Some info")
            }
        ).build()

    companion object {
        private val LOGGER = LoggerFactory.getLogger(GlobalErrorHandler::class.java)
    }
}