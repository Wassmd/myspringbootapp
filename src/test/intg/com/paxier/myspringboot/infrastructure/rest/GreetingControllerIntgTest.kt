package com.paxier.myspringboot.infrastructure.rest

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class GreetingControllerIntgTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun `correct greeting with 200 status`() {
        val result = webTestClient.get()
            .uri("/api/greetings?name=Wasim")
            .exchange()
            .expectStatus().isOk
            .expectBody(String::class.java)
            .returnResult()

        result.responseBody shouldBe "Hello Wasim!"
    }
}