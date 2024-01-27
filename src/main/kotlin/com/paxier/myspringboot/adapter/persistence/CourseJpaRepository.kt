package com.paxier.myspringboot.adapter.persistence

import com.paxier.myspringboot.domain.entities.CourseEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CourseJpaRepository: JpaRepository<CourseEntity, Long> {
}