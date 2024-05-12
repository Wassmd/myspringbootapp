package com.paxier.myspringboot.infrastructure.persistence

import com.paxier.myspringboot.application.port.out.InstructorRepositoryPort
import com.paxier.myspringboot.domain.api.Instructor
import org.springframework.stereotype.Repository

@Repository
class InstructorRepository(private val repository: InstructorJpaRepository): InstructorRepositoryPort {
    override fun save(instructor: Instructor): Instructor =
        repository.save(instructor.toEntity()).toDomain()

    override fun findAll(): List<Instructor> = repository.findAll().map { it.toDomain() }
    override fun findById(id: Long): Instructor? = repository.findById(id).orElse(null)?.toDomain()
}