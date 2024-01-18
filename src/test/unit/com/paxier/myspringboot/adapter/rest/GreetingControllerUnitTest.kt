package com.paxier.myspringboot.adapter.rest

import com.ninjasquad.springmockk.MockkBean
import com.paxier.myspringboot.application.port.`in`.GreetingServicePort
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [GreetingController::class])
class GreetingControllerUnitTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var greetingService: GreetingServicePort

    @Test
    fun `correct greeting with 200 status`() {
        every { greetingService.greetPolitely(any()) } returns "Hello Wasim!"

        val result = webTestClient.get()
            .uri("/api/greetings?name=Wasim")
            .exchange()
            .expectStatus().isOk
            .expectBody(String::class.java)
            .returnResult()

        result.responseBody shouldBe "Hello Wasim!"
    }
}
