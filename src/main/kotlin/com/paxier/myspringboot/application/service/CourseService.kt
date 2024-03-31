package com.paxier.myspringboot.application.service

import com.paxier.myspringboot.application.port.`in`.CourseServicePort
import com.paxier.myspringboot.application.port.`in`.InstructorServicePort
import com.paxier.myspringboot.application.port.out.CourseRepositoryPort
import com.paxier.myspringboot.domain.api.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val courseRepository: CourseRepositoryPort,
    private val instructorService: InstructorServicePort
    ) : CourseServicePort {
    override fun createCourse(course: Course): Course {
        val instructor = instructorService.findInstructorId(course.instructor!!.id!!)
        return courseRepository.save(course)
    }

    override fun getAllCourses(courseName: String?): List<Course> {
        courseName?.let {
            return courseRepository.findByName(it)
        } ?: return courseRepository.findAll()
    }
}