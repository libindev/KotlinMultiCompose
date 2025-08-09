package com.multipatform.project.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.multipatform.project.data.model.ChatMessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
  @Insert
  suspend fun addMessage(msg: ChatMessageEntity)

  @Query("select * from ChatMessageEntity")
  fun getMessages(): Flow<List<ChatMessageEntity>>
}