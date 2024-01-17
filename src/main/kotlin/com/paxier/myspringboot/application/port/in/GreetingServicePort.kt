package com.paxier.myspringboot.application.port.`in`

interface GreetingServicePort {
    fun greetPolitely(name: String): String
}