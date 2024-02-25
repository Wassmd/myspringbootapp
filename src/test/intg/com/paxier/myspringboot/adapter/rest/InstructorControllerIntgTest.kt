package com.paxier.myspringboot.adapter.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.paxier.myspringboot.domain.api.Instructor
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class InstructorControllerIntgTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `when instructor created then 201 returned`() {
        val instructor = Instructor(null, "John Doe")

       val response = webTestClient.post()
            .uri("api/instructors")
           .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(objectMapper.writeValueAsString(instructor))
            .exchange()
           .expectStatus().isCreated
           .expectBody(Instructor::class.java)
           .returnResult()
           .responseBody

        response!!.name shouldBe "John Doe"
        response.id shouldBe 1


    }
}