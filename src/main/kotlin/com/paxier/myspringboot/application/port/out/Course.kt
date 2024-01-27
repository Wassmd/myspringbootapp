package com.paxier.myspringboot.application.port.out

import com.paxier.myspringboot.domain.api.Course

interface CourseRepositoryPort {
    fun save(course: Course): Course
}