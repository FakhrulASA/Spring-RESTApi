package com.fakhrulasa.springrest.data.mock

import com.fakhrulasa.springrest.data.Notes
import com.fakhrulasa.springrest.model.Post
import org.springframework.stereotype.Repository

@Repository
class MockNotes : Notes {
    val notes = mutableListOf(Post("1", "Meeting", "Meeting at 2PM"),
            Post("2", "Lunch", "Lunch at 2PM"),
            Post("3", "Breakfast", "Breakfast at 2PM"))

    override fun getNotes(): Collection<Post> = notes
    override fun getNote(id: String): Post {
        return notes.firstOrNull {
            it.postId == id
        } ?: throw NoSuchElementException("Could not find a note with the id $id")
    }

    override fun addNote(id:String,title:String,detail:String): Post {
        if (notes.any {
                    it.postId == id
                }) {
            throw IllegalArgumentException("A note is already existed with $id this id")
        }
        val post=Post(id,title,detail)
        notes.add(post)
        return post
    }
}