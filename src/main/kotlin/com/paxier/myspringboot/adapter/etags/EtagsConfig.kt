package com.paxier.myspringboot.adapter.etags

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.ShallowEtagHeaderFilter

@Configuration
class EtagsConfig {
    // Etags
    @Bean
    fun shallowEtagHeaderFilter(): FilterRegistrationBean<ShallowEtagHeaderFilter> {
        val filterRegistrationBean = FilterRegistrationBean(ShallowEtagHeaderFilter())
        filterRegistrationBean.addUrlPatterns("/foos/*")
        filterRegistrationBean.setName("etagFilter")
        return filterRegistrationBean
    }
}