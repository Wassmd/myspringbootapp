package com.paxier.myspringboot.infrastructure.rest

import com.paxier.myspringboot.domain.api.Course
import com.paxier.myspringboot.domain.entities.CourseEntity
import com.paxier.myspringboot.infrastructure.persistence.CourseJpaRepository
import com.paxier.myspringboot.testcontainers.ContainerInitializer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.ParameterizedTypeReference
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
class WebClientControllerIntgTest: ContainerInitializer() {
    @Autowired
    lateinit var webTestClient: WebTestClient
    @Autowired
    lateinit var courseJpaRepository: CourseJpaRepository

    var courses: List<CourseEntity> = emptyList()

    @BeforeEach
    fun setup() {
        courses = listOf(
            CourseEntity(1, "java", "programming"),
            CourseEntity(2, "iOS", "programming"),
            CourseEntity(3, "kotlin", "programming"),
            CourseEntity(4, "Advanced kotlin", "programming")
        )
        courseJpaRepository.saveAll(courses)
    }

    @Test
    fun `get courses from webclient`() {
       val response = webTestClient.get()
            .uri("/api/webclient/courses")
            .exchange()
           .expectStatus()
           .isOk
           .returnResult(object : ParameterizedTypeReference<List<Course>>(){})
           .responseBody
           .blockLast()

        response?.isEmpty()

    }
}