package com.paxier.myspringboot.domain.entities

import com.paxier.myspringboot.domain.api.Course
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.security.ProtectionDomain

@Entity
@Table(name = "course")
data class CourseEntity(
    @Id @GeneratedValue val id: Long?,
    val name: String,
    val category: String,
) {
    fun toDomain(): Course = Course(id, name, category)
}
