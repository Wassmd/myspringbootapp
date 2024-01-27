package com.paxier.myspringboot.application.port.`in`

import com.paxier.myspringboot.domain.api.Course

interface CourseServicePort {
    fun createCourse(course: Course): Course
}