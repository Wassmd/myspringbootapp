package com.paxier.myspringboot.adapter.rest

import com.paxier.myspringboot.application.port.`in`.InstructorServicePort
import com.paxier.myspringboot.domain.api.Instructor
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/instructors")
@Validated
class InstructorController(private val instructorService: InstructorServicePort) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createInstructor(@RequestBody @Valid body: Instructor): Instructor =
        instructorService.createInstructor(body)

//    @GetMapping
//    fun getAllCourses(@RequestParam courseName: String?): List<Course> =
//        instructorService.getAllCourses(courseName)
}