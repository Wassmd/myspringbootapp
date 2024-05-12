package com.paxier.myspringboot.infrastructure.rest

import com.paxier.myspringboot.domain.api.Course
import com.paxier.myspringboot.infrastructure.webclient.MyWebClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/webclient/courses")
class WebClientController(private val myWebClient: MyWebClient) {

    @GetMapping
    fun getCourses(): List<Course> =
        myWebClient.getCourses() ?: emptyList()
}