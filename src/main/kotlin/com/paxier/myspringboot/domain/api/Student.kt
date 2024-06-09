package com.paxier.myspringboot.domain.api

import java.util.*

data class Student(
    val id: Long?,
    val name: String,
    val averageGrade: Short
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val otherStudent: Student = other as Student
        return otherStudent.id == id
    }

    override fun hashCode(): Int {
        return Objects.hashCode(id)
    }
}
