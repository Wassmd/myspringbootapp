package com.paxier.myspringboot.application.service

import com.paxier.myspringboot.application.port.out.StudentRepositoryPort
import com.paxier.myspringboot.domain.api.Student
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepositoryPort) {
    fun getStudentsWithAverageGradeLessThan(averageGrade: Short): Set<Student> =
        studentRepository.getStudentsWithAverageGradeLessThan(averageGrade)

    fun getStudentsWithNameStartsWith(name: String): Set<Student> =
        studentRepository.getStudentsWithNameStartsWith(name)
}