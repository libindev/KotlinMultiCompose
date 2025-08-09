package com.multipatform.project.data.mappers

import com.multipatform.project.data.model.ChatMessageEntity
import com.multipatform.project.domain.model.ChatMessage

fun ChatMessageEntity.toDomainModel(): ChatMessage {
    return ChatMessage(id = this.id, message = this.message,user=this.user, role = this.role )
}


