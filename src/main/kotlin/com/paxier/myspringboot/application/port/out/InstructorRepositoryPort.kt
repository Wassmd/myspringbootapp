package com.paxier.myspringboot.application.port.out

import com.paxier.myspringboot.domain.api.Instructor

interface InstructorRepositoryPort {
    fun save(instructor: Instructor): Instructor
    fun findAll(): List<Instructor>
    fun findById(id: Long): Instructor?
}