package com.paxier.myspringboot.adapter.rest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pids")
class AccessHeaderController {

    @GetMapping(produces = ["application/vnd.pid-v2+json"])
    fun getPId(): PId {
        Logger.debug("application/vnd.pid-v2+json")
        return PId("some id from pid-v2+json")
    }

    @GetMapping
    fun getPId1(): PId {
        Logger.debug("application/json")
        return PId("some id from getPId1")
    }

    data class PId(
        val id: String
    )


    companion object {
        private val Logger = LoggerFactory.getLogger(AccessHeaderController::class.java)
    }
}