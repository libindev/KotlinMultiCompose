package com.multipatform.project.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatMessageEntity(
  @PrimaryKey(autoGenerate = true) // this one is required
  val id: Long = 0L,
  val message: String,
  val user: String,
  val role: String // user or bot or whatever
)

