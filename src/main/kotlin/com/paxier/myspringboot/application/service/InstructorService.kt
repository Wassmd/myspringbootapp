package com.paxier.myspringboot.application.service

import com.paxier.myspringboot.application.port.`in`.InstructorServicePort
import com.paxier.myspringboot.application.port.out.InstructorRepositoryPort
import com.paxier.myspringboot.domain.api.Instructor
import org.springframework.stereotype.Service

@Service
class InstructorService(private val instructorRepository: InstructorRepositoryPort): InstructorServicePort {
    override fun createInstructor(instructor: Instructor) = instructorRepository.save(instructor)
}