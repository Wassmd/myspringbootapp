package com.paxier.myspringboot.infrastructure.webclient

import com.paxier.myspringboot.domain.api.Course
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class MyWebClient(
    webClientBuilder: WebClient.Builder,
    circuitBreakerRegistry: CircuitBreakerRegistry
    ) {
    private val webClient = webClientBuilder
        .baseUrl("http://localhost:8081")
        .build()
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("courses-circuit-breaker")


    fun getCourses(): List<Course>? =
        circuitBreaker.executeSupplier { webClient.get()
            .uri("/api/courses")
            .retrieve()
            .bodyToMono(
                object :ParameterizedTypeReference<List<Course>>(){}
            )
            .block()
        }

    private fun handleRecovery(throwable: Throwable): List<Course>? {
        // Log the exception and return a fallback value
        println("Exception occurred: ${throwable.message}")
        return emptyList()
    }
}