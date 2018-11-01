package com.example.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/foobar")
class FoobarController {

    @Get("/")
    fun index(): HttpStatus {
        return HttpStatus.OK
    }
}