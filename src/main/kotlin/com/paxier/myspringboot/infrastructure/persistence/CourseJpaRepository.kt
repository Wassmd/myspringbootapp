package com.paxier.myspringboot.infrastructure.persistence

import com.paxier.myspringboot.domain.entities.CourseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CourseJpaRepository: JpaRepository<CourseEntity, Long> {
    fun findByNameContainsIgnoreCase(name: String): List<CourseEntity>

    @Query("SELECT c FROM CourseEntity c WHERE c.name like %:name%")
    fun courseByName(name: String):  List<CourseEntity>
}