package com.paxier.myspringboot.infrastructure.rest

import com.paxier.myspringboot.application.service.StudentService
import com.paxier.myspringboot.domain.api.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/students")
class StudentController(private val studentService: StudentService) {
    @GetMapping("name-and-grade")
    fun getStudentsWithNameStartsWithGradeLessThan(
        @RequestParam(name ="prefix") prefix: String,
        @RequestParam("grade") grade: Short
    ): Set<Student> {
        val students = studentService.getStudentsWithNameStartsWith(prefix).toMutableSet()
        students.retainAll(studentService.getStudentsWithAverageGradeLessThan(grade))
        return students
    }
}