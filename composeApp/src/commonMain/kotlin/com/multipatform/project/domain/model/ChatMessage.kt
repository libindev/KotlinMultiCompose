package com.multipatform.project.domain.model



data class ChatMessage(
  val id: Long = 0L,
  val message: String,
  val role: String,
  val user: String
)