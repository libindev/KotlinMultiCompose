package com.multipatform.project.data.dataSource

import com.multipatform.project.data.model.ChatMessageEntity
import kotlinx.coroutines.flow.Flow

interface ChatLocalDataSource {
     fun getAllChat(): Flow<List<ChatMessageEntity>>
   suspend  fun insertChat(toDbEntity: ChatMessageEntity)

}