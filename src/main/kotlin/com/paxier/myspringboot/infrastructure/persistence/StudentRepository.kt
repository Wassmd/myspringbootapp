package com.paxier.myspringboot.infrastructure.persistence

import com.paxier.myspringboot.application.port.out.StudentRepositoryPort
import com.paxier.myspringboot.domain.api.Student
import org.springframework.stereotype.Service

@Service
class StudentRepository(private val studentJpaRespository: StudentJpaRespository): StudentRepositoryPort  {
    override fun getStudentsWithAverageGradeLessThan(averageGrade: Short): Set<Student> =
        studentJpaRespository.findByAverageGradeIsLessThan(averageGrade).map { it.toDomainModel() }.toSet()

    override fun getStudentsWithNameStartsWith(name: String): Set<Student> =
        studentJpaRespository.findByNameStartsWithIgnoreCase(name).map { it.toDomainModel() }.toSet()

}