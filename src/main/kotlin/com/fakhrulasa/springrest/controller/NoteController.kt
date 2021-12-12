package com.fakhrulasa.springrest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class NoteController {
    @GetMapping
    fun helloWorld():String{
        return "Hello World"
    }
}