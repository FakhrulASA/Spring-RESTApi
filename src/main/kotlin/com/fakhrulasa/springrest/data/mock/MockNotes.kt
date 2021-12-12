package com.fakhrulasa.springrest.data.mock

import com.fakhrulasa.springrest.data.Notes
import com.fakhrulasa.springrest.model.Post
import org.springframework.stereotype.Repository

@Repository
class MockNotes : Notes {
    val notes = listOf(Post("1", "Meeting", "Meeting at 2PM"),
            Post("2", "Lunch", "Lunch at 2PM"),
            Post("3", "Breakfast", "Breakfast at 2PM"))

    override fun getNotes(): Collection<Post> = notes
    override fun getNote(id: String): Post {
        return notes.firstOrNull{
            it.postId == id
        } ?: throw NoSuchElementException("Could not find a note with the id $id")
    }
}