package com.multipatform.project.domain.usecase

import com.multipatform.project.domain.model.ChatMessage
import com.multipatform.project.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow


/**
 * Use case that encapsulates the business logic for fetching the Chat Message feature data.
 */
class GetChatMessageUseCase  constructor(
    private val repository: ChatRepository
) {

    /**
     * Executes the use case.
     */
    suspend operator fun invoke(): Flow<List<ChatMessage>> {
        return repository.getAllMessages()
    }
}