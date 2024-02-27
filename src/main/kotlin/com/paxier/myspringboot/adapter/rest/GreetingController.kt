package com.paxier.myspringboot.adapter.rest

import com.paxier.myspringboot.application.port.`in`.GreetingServicePort
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Thread.sleep

@RestController
@RequestMapping("/api/greetings")
class GreetingController(val greetingService: GreetingServicePort) {

    @GetMapping
    fun greeting(@RequestParam(value = "name") userName: String): ResponseEntity<String> {
        val greetingMessage = greetingService.greetPolitely(userName)
        logger.info("Greeting message: $greetingMessage")
        return ResponseEntity.ok(greetingMessage)
    }

    companion object {
        val logger = LoggerFactory.getLogger(GreetingController::class.java)
    }

    @GetMapping
    @RequestMapping("/api/mappings/{customerId}")
    fun getReweId(@RequestParam(value = "customerId") customerId: String): IdDto {
        sleep(30000)
        logger.info("Reweid for customer: $customerId")
        return IdDto("1234")
    }

    data class IdDto(
        val reweID: String,
    )
}
