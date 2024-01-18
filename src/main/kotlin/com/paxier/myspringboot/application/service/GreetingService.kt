package com.paxier.myspringboot.application.service

import com.paxier.myspringboot.application.port.`in`.GreetingServicePort
import org.springframework.stereotype.Service

@Service
class GreetingService: GreetingServicePort {
    override fun greetPolitely(name: String): String = "Hello $name!"
}