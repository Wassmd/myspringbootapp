package com.paxier.myspringboot.infrastructure.rest

import com.paxier.myspringboot.application.port.`in`.InstructorServicePort
import com.paxier.myspringboot.domain.api.Instructor
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/instructors")
@Validated
class InstructorController(private val instructorService: InstructorServicePort) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createInstructor(@RequestBody @Valid body: Instructor): Instructor =
        instructorService.createInstructor(body)

    @GetMapping
    fun getAllInstructor(): List<Instructor> =
        instructorService.getAllInstructor()

}