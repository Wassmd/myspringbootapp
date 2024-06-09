package com.paxier.myspringboot.application.port.out

import com.paxier.myspringboot.domain.api.Student

interface StudentRepositoryPort {
    fun getStudentsWithNameStartsWith(name: String): Set<Student>
    fun getStudentsWithAverageGradeLessThan(averageGrade: Short): Set<Student>
}