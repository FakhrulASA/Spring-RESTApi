package com.fakhrulasa.springrest.service

import com.fakhrulasa.springrest.data.Notes
import com.fakhrulasa.springrest.model.Post
import org.springframework.stereotype.Service

@Service
class NoteService(private val dataSource:Notes) {
    fun getNotes():Collection<Post> = dataSource.getNotes()
    fun getNote(id:String):Post = dataSource.getNote(id)
    fun addNote(post: Post): Post = dataSource.addNote(post)
}