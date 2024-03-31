package com.paxier.myspringboot.domain.entities

import com.paxier.myspringboot.domain.api.Course
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

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
    fun toDomain(): Course = Course(id, name, category, instructor!!.toDomain())
}
