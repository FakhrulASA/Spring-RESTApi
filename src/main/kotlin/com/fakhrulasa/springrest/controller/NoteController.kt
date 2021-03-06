package com.fakhrulasa.springrest.controller

import com.fakhrulasa.springrest.model.Post
import com.fakhrulasa.springrest.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/notes")
class NoteController(private val service: NoteService) {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleException(e:NoSuchElementException):ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRsponse(e:IllegalArgumentException):ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getNotes():Collection<Post> = service.getNotes()

    @GetMapping("/{id}")
    fun getNote(@PathVariable id:String)= service.getNote(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNote(@RequestBody id: String,@RequestBody title: String,@RequestBody detail: String)=service.addNote(id,title,detail)

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateNote(@RequestBody post: Post): Post=service.updateNote(post)

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    fun deleteNote(@PathVariable postId:String):Unit=service.deleteNote(postId)
}