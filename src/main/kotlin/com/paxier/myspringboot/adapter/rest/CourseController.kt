package com.paxier.myspringboot.adapter.rest

import com.paxier.myspringboot.application.port.`in`.CourseServicePort
import com.paxier.myspringboot.domain.api.Course
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/courses")
@Validated
class CourseController(private val courseService: CourseServicePort) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createCourse(@RequestBody @Valid body: Course): Course =
        courseService.createCourse(body)
}