package com.paxier.myspringboot.infrastructure.rest

import com.ninjasquad.springmockk.MockkBean
import com.paxier.myspringboot.application.port.`in`.InstructorServicePort
import com.paxier.myspringboot.domain.api.Instructor
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [InstructorController::class])
class InstructorControllerUnitTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var instructorService: InstructorServicePort

    @Test
    fun `bad request for missing instructor name`() {
        every { instructorService.createInstructor(any()) } returns Instructor(1, "john")
        webTestClient.post()
            .uri("/api/instructors")
            .contentType(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isBadRequest

    }

}