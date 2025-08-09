package com.multipatform.project.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.multipatform.project.data.model.ChatMessageEntity

// In your commonMain
@Database(entities = [ChatMessageEntity::class], version = 1)

abstract class ChatDatabase: RoomDatabase() {
  abstract fun getChatDao(): ChatDao
}