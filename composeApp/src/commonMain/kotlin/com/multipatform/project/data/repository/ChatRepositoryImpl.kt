            package com.multipatform.project.data.repository

            import com.multipatform.project.data.dataSource.ChatLocalDataSource
            import com.multipatform.project.data.mappers.toDomainModel
            import com.multipatform.project.domain.mappers.toDbEntity
            import com.multipatform.project.domain.model.ChatMessage
            import com.multipatform.project.domain.repository.ChatRepository
            import kotlinx.coroutines.flow.Flow
            import kotlinx.coroutines.flow.map


            class ChatRepositoryImpl(private val dataSource: ChatLocalDataSource) : ChatRepository {

                override fun getAllMessages(): Flow<List<ChatMessage>> {
                    return dataSource.getAllChat().map {
                        entityList -> entityList.map { it.toDomainModel() }
                    }
                } // Mapper function

                override suspend fun insertMessage(message: ChatMessage) {
                    dataSource.insertChat(message.toDbEntity())
                }

                override suspend fun deleteMessage(message: ChatMessage) {
                    TODO("Not yet implemented")
                }
            }



            