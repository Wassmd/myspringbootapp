package com.paxier.myspringboot.infrastructure.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/abtestgroups")
class ABTestGroup {

    @GetMapping
    fun getABTestGroups(): Map<String, List<Any>> {
        return mapOf("testgroups" to listOf("a", "b"), "test1" to listOf("c"))
    }
}