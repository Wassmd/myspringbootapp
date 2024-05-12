package com.paxier.myspringboot.infrastructure.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/mappings/{customerId}")
class UniqueIdController {

    @GetMapping
    fun getUniqueId(@PathVariable(value = "customerId") customerId: String): IdDto {
        Thread.sleep(20000)
        return IdDto(customerId)
    }

    data class IdDto(val uniqueId: String)
}