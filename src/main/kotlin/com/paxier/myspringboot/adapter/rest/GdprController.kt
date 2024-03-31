package com.paxier.myspringboot.adapter.rest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GdprController {
    @PostMapping
    @RequestMapping("/{apiKey}/gdpr/request")
    fun postEvent(
        @PathVariable apiKey: String,
        @RequestBody body: String,
    ): BatchTokenResponse {

        logger.info("Request body: $body")
        Thread.sleep(11000)
        logger.info("gdpr delivered")
        return BatchTokenResponse("some-token")
    }

    data class BatchTokenResponse(
        val token: String,
    )
    companion object {
        private val logger = LoggerFactory.getLogger(EventsController::class.java)
    }
}