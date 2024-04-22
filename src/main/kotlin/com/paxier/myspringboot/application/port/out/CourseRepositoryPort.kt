package com.paxier.myspringboot.application.port.out

import com.paxier.myspringboot.domain.api.Course
import com.paxier.myspringboot.domain.api.Instructor

interface CourseRepositoryPort {
    fun save(course: Course, instructor: Instructor?): Course
    fun findAll(): List<Course>
    fun findByName(name: String): List<Course>
}