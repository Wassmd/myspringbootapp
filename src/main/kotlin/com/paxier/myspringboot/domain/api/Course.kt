package com.paxier.myspringboot.domain.api

import com.paxier.myspringboot.domain.entities.CourseEntity

data class Course(
    val id: Long?,
    val name: String,
    val category: String,

) {
    fun toEntity(): CourseEntity = CourseEntity(id, name, category)
}