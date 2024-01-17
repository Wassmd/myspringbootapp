package com.paxier.myspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyspringbootApplication

fun main(args: Array<String>) {
	runApplication<MyspringbootApplication>(*args)
}
