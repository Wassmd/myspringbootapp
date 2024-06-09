package com.paxier.myspringboot.domain.entities

import com.paxier.myspringboot.domain.api.Student
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.util.*


@Entity
@Table(name = "student")
data class StudentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val name: String,
    private val averageGrade: Short,
) {
    fun toDomainModel(): Student = Student (id, name, averageGrade)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as StudentEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}