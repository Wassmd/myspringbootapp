package com.paxier.myspringboot.domain.api

import com.paxier.myspringboot.domain.entities.CourseEntity
import jakarta.validation.constraints.NotBlank

data class Course(
    val id: Long?,
    @field:NotBlank(message = " Course name is mandatory")
    val name: String,
    val category: String,

) {
    fun toEntity(): CourseEntity = CourseEntity(id, name, category)
}