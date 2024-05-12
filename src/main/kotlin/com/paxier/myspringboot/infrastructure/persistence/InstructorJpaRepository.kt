package com.paxier.myspringboot.infrastructure.persistence

import com.paxier.myspringboot.domain.entities.InstructorEntity
import org.springframework.data.jpa.repository.JpaRepository

interface InstructorJpaRepository: JpaRepository<InstructorEntity, Long> {
}