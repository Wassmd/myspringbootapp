package com.paxier.myspringboot.domain.api

import com.paxier.myspringboot.domain.entities.InstructorEntity
import jakarta.validation.constraints.NotBlank

data class Instructor(
    val id: Long?,
    @get:NotBlank(message = "Instructor name must not be blank")
    val name: String
) {
    fun toEntity() = InstructorEntity(id, name)
}