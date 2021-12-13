package com.fakhrulasa.springrest.data

import com.fakhrulasa.springrest.model.Post

interface Notes {
    fun getNotes():Collection<Post>
    fun getNote(id:String):Post
    fun addNote(id:String,title:String,detail:String):Post
    fun uodateNote(post: Post):Post
    fun deleteNotes(id: String)
}