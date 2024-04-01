package com.paxier.myspringboot.adapter.rest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/{apiKey}/events/users/{pushId}")
class EventsController {
    @PostMapping
    fun postEvent(
        @PathVariable apiKey: String,
        @PathVariable pushId: String,
        @RequestBody body: String,
    ): BatchTokenResponse {

        logger.info("Request body: $body")
        Thread.sleep(8000)
        logger.info("token delivered")
        return BatchTokenResponse("some-token")
    }

    data class BatchTokenResponse(
        val token: String,
    )
    companion object {
        private val logger = LoggerFactory.getLogger(EventsController::class.java)
    }
}