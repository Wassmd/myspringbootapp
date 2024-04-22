package com.paxier.myspringboot.domain.api

import com.paxier.myspringboot.domain.entities.CourseEntity
import jakarta.validation.constraints.NotBlank

data class Course(
    val id: Long?,
    @field:NotBlank(message = " Course name is mandatory")
    val name: String,
    val category: String,
    var instructorId: Long?

) {
    fun toEntity(instructor: Instructor?): CourseEntity =
        CourseEntity(id, name, category, instructor?.toEntity() )
}