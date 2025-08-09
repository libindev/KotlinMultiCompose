            package com.multipatform.project.domain.repository

            import com.multipatform.project.domain.model.ChatMessage // Assuming you move/copy ChatMessage here
            import kotlinx.coroutines.flow.Flow

            interface ChatRepository {
                fun getAllMessages(): Flow<List<ChatMessage>>
                suspend fun insertMessage(message: ChatMessage)
                suspend fun deleteMessage(message: ChatMessage)
                // Add other necessary operations
            }