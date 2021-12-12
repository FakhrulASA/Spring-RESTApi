package com.fakhrulasa.springrest.data

import com.fakhrulasa.springrest.model.Post

interface Notes {
    fun getNotes():Collection<Post>
    fun getNote(id:String):Post
}