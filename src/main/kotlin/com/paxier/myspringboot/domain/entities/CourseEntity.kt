package com.paxier.myspringboot.domain.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "course")
data class CourseEntity(
    @Id val id: Int?,
    val name: String,
    val category: String,
)
