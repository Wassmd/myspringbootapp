package com.paxier.myspringboot.domain

import com.paxier.myspringboot.domain.api.Student
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test

class StudentunitTest {
    @Test
    fun `objects are equal when name is equal`() {
        val student1 = Student(1, "Wasim", 7)
        val student2 = Student(1, "Maryam", 8)

        student1 shouldBeEqual student2

    }
}