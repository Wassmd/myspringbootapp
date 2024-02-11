package com.paxier.myspringboot.adapter.persistence

import com.paxier.myspringboot.application.port.out.CourseRepositoryPort
import com.paxier.myspringboot.domain.api.Course
import org.springframework.stereotype.Service

@Service
class CourseRepository(private val courseJpaRepository: CourseJpaRepository): CourseRepositoryPort {
    override fun save(course: Course): Course =
        courseJpaRepository.save(course.toEntity()).toDomain()
}