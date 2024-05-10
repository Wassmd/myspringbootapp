package com.paxier.myspringboot.adapter.persistence

import com.paxier.myspringboot.domain.entities.CourseEntity
import com.paxier.myspringboot.testcontainers.ContainerInitializer
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.stream.Stream

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryIntgTest : ContainerInitializer() {

    @Autowired
    lateinit var courseJpaRepository: CourseJpaRepository

    @BeforeEach
    fun setup() {
        val courses = listOf(
            CourseEntity(1, "java", "programming"),
            CourseEntity(2, "iOS", "programming"),
            CourseEntity(3, "kotlin", "programming"),
            CourseEntity(3, "Advanced kotlin", "programming")
        )
        courseJpaRepository.saveAll(courses)
    }


    @ParameterizedTest
    @ValueSource(strings = ["java", "iOS", "kotlin"])
    @CsvSource(value = ["java, 1", "iOS, 1", "kotlin, 2"])
    fun `query course by word containing name`(name: String, expectedSize: Int) {
        val courses = courseJpaRepository.findByNameContainsIgnoreCase(name)
        courses.size shouldBeGreaterThanOrEqual expectedSize
    }

    @ParameterizedTest
    @CsvSource(value = ["java, 1", "iOS, 1", "kotlin, 2"])
    fun `query course by word containing name 2`(name: String, expectedSize: Int) {
        val courses = courseJpaRepository.courseByName(name)
        courses.size shouldBeGreaterThanOrEqual expectedSize
    }

    @ParameterizedTest
    @MethodSource("courseAndSize")
    fun `query course by word containing name 3`(name: String, expectedSize: Int) {
        val courses = courseJpaRepository.courseByName(name)
        courses.size shouldBeGreaterThanOrEqual expectedSize
    }

    companion object {
        @JvmStatic
        fun courseAndSize(): Stream<Arguments> {
            return Stream.of(
            Arguments.arguments("java", 1),
                Arguments.arguments("iOS", 1),
                Arguments.arguments("Kotlin", 2)
            )
        }
    }
}