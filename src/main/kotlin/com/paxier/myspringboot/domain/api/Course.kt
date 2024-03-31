package com.paxier.myspringboot.domain.api

import com.paxier.myspringboot.domain.entities.CourseEntity
import com.paxier.myspringboot.domain.entities.InstructorEntity
import jakarta.validation.constraints.NotBlank

data class Course(
    val id: Long?,
    @field:NotBlank(message = " Course name is mandatory")
    val name: String,
    val category: String,
    val instructor: Instructor?

) {
    fun toInstructorEntity() = InstructorEntity(instructor!!.id, instructor.name)
    fun toEntity(): CourseEntity = CourseEntity(id, name, category, toInstructorEntity())
}