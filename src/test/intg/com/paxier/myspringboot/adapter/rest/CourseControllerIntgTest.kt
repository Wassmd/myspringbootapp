package com.paxier.myspringboot.adapter.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.paxier.myspringboot.domain.api.Course
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CourseControllerIntgTest  {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `course created and returned with 201 status code`() {
        // Given
        val course = Course(null, "Kotlin", "Programming")
        val body = objectMapper.writeValueAsString(course)

        // When
        val response = webTestClient.post()
            .uri("/api/courses")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .exchange()
            .expectStatus().isCreated
            .expectBody(Course::class.java)
            .returnResult()
            .responseBody

        // Then
        response!!.id shouldNotBe null
        response.name shouldBe "Kotlin"
        response.category shouldBe "Programming"
    }

    @Test
    fun `bad request for missing name`() {
        //given
        val course = """
            {
                "name": "",
                "category": "Programming"
            }
        """

        //when
        val responseSpec = webTestClient
            .post()
            .uri("/api/courses")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(course)
            .exchange()

        //then
        responseSpec.expectStatus().isBadRequest
        responseSpec.expectBody()
            .jsonPath("$.message").isEqualTo("Validation failed for object='course'. Error count: 1")
    }
}