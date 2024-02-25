package com.paxier.myspringboot.domain.entities

import com.paxier.myspringboot.domain.api.Course
import jakarta.persistence.*

@Entity
@Table(name = "course")
data class CourseEntity(
    @Id @GeneratedValue val id: Long?,
    val name: String,
    val category: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSTRUCTOR_ID", nullable = false)
    val instructor: InstructorEntity? = null

) {
    fun toDomain(): Course = Course(id, name, category)
}
