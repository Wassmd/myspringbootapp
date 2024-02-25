package com.paxier.myspringboot.domain.entities

import com.paxier.myspringboot.domain.api.Instructor
import jakarta.persistence.*

@Entity
@Table(name = "INSTRUCTORS")
data class InstructorEntity(
    @Id @GeneratedValue val id: Long?,
    val name: String,
    @OneToMany(
        mappedBy = "instructor",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    val courses: List<CourseEntity> = mutableListOf()
) {
    fun toDomain() = Instructor(id, name)
}