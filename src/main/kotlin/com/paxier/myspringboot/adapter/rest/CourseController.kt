package com.paxier.myspringboot.adapter.rest

import com.paxier.myspringboot.application.port.`in`.CourseServicePort
import com.paxier.myspringboot.domain.api.Course
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/courses")
class CourseController(private val courseService: CourseServicePort) {

    @PostMapping
    fun createCourse(@RequestBody body: Course): ResponseEntity<Course> {
        val newCourse = courseService.createCourse(body)
        return ResponseEntity.ok(newCourse)
    }
}