package com.paxier.myspringboot.adapter.rest

import com.paxier.myspringboot.application.port.`in`.GreetingServicePort
import io.swagger.v3.oas.annotations.Operation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/greetings")
class GreetingController(val greetingService: GreetingServicePort) {

    @Operation(
        summary = "Greeting event",
        description = "Greetings",
    )

    @GetMapping
    fun greeting(@RequestParam(value = "name") userName: String): ResponseEntity<String> {
        val greetingMessage = greetingService.greetPolitely(userName)
        logger.info("Greeting message: $greetingMessage")
        return ResponseEntity.ok(greetingMessage)
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(GreetingController::class.java)
    }
}
