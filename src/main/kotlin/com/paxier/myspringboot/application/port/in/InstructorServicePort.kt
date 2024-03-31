package com.paxier.myspringboot.application.port.`in`

import com.paxier.myspringboot.domain.api.Instructor

interface InstructorServicePort {
    fun createInstructor(instructor: Instructor): Instructor
    fun findInstructorId(id: Long): Instructor?
}