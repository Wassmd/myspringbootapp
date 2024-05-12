package com.paxier.myspringboot.infrastructure.persistence

import com.paxier.myspringboot.application.port.out.CourseRepositoryPort
import com.paxier.myspringboot.domain.api.Course
import com.paxier.myspringboot.domain.api.Instructor
import org.springframework.stereotype.Service

@Service
class CourseRepository(private val courseJpaRepository: CourseJpaRepository): CourseRepositoryPort {
    override fun save(course: Course, instructor: Instructor?): Course =
        courseJpaRepository.save(course.toEntity(instructor)).toDomain()

    override fun findAll(): List<Course> = courseJpaRepository.findAll().map { it.toDomain() }
    override fun findByName(name: String): List<Course> =
        courseJpaRepository.findByNameContainsIgnoreCase(name).map { it.toDomain() }
}