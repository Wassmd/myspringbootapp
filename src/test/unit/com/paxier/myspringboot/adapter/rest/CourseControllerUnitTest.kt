package com.paxier.myspringboot.adapter.rest

import com.ninjasquad.springmockk.MockkBean
import com.paxier.myspringboot.application.port.`in`.CourseServicePort
import com.paxier.myspringboot.domain.api.Course
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [CourseController::class])
class CourseControllerUnitTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseService: CourseServicePort

    @Test
    fun `bad request for missing name`() {
        //given
        every {  courseService.createCourse(any()) } returns Course(null,"dummy", "dummy", 1)
        val body = "{\n" +
                "            \"name\": \"\",\n" +
                "            \"category\": \"Programming\"\n" +
                "        }"

        //when
        val response = webTestClient
            .post()
            .uri("/api/courses")
            .contentType(APPLICATION_JSON)
            .bodyValue(body)
            .exchange()

        //then
        response.expectStatus().isBadRequest
    }
}