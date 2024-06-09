package com.paxier.myspringboot.infrastructure.persistence

import com.paxier.myspringboot.domain.entities.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentJpaRespository: JpaRepository<StudentEntity, Long> {
    fun findByAverageGradeIsLessThan(averageGrade: Short): Set<StudentEntity>
    fun findByNameStartsWithIgnoreCase(name: String): Set<StudentEntity>
}