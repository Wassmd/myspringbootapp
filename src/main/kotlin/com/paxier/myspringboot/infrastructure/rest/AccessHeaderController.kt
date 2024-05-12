package com.paxier.myspringboot.infrastructure.rest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pids")
class AccessHeaderController {

    @GetMapping(produces = ["application/vnd.pid-v2+json"])
    fun getPId(@RequestHeader headers: Map<String, String>): PId {
        headers.forEach { (key, value) -> Logger.debug("Header: $key = $value")  }
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