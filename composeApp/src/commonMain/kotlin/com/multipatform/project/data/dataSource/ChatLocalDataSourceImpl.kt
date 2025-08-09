package com.multipatform.project.data.dataSource

import com.multipatform.project.data.db.ChatDatabase
import com.multipatform.project.data.model.ChatMessageEntity
import kotlinx.coroutines.flow.Flow


class ChatLocalDataSourceImpl(private val appDatabase: ChatDatabase) : ChatLocalDataSource {
    override  fun getAllChat(): Flow<List<ChatMessageEntity>> = appDatabase.getChatDao().getMessages()
    override suspend fun insertChat(toDbEntity: ChatMessageEntity) {
        appDatabase.getChatDao().addMessage(toDbEntity)
    }


}