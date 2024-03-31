package com.paxier.myspringboot.adapter.rest

import com.paxier.myspringboot.application.port.`in`.GreetingServicePort
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Thread.sleep

@RestController
class GreetingController(val greetingService: GreetingServicePort) {

    @GetMapping
    @RequestMapping("/api/greetings")
    fun greeting(@RequestParam(value = "name") userName: String): ResponseEntity<String> {
        val greetingMessage = greetingService.greetPolitely(userName)
        logger.info("Greeting message: $greetingMessage")
        return ResponseEntity.ok(greetingMessage)
    }

    @GetMapping
    @RequestMapping("/api/mappings/{customerId}")
    fun getUniqueId(@PathVariable(value = "customerId") customerId: String): IdDto {
        logger.info("uniqueId for customer: $customerId")

        sleep(20000)
        return IdDto("1234")
    }

    data class IdDto(
        val uniqueId: String,
    )

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(GreetingController::class.java)
    }
}
