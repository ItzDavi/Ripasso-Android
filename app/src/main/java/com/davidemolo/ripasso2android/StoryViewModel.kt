package com.davidemolo.ripasso2android

class StoryViewModel(
    private val storyAuthor: String,
    private val storyImage: String
)
{
    fun getStoryAuthor(): String = this.storyAuthor
    fun getStoryImage(): String = this.storyImage
}