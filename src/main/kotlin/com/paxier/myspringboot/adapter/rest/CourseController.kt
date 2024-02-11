package com.paxier.myspringboot.adapter.rest

import com.paxier.myspringboot.application.port.`in`.CourseServicePort
import com.paxier.myspringboot.domain.api.Course
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/courses")
class CourseController(private val courseService: CourseServicePort) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createCourse(@RequestBody body: Course): Course =
        courseService.createCourse(body)
}