package com.multipatform.project.domain.mappers

import com.multipatform.project.data.model.ChatMessageEntity
import com.multipatform.project.domain.model.ChatMessage



fun ChatMessage.toDbEntity(): ChatMessageEntity {
    return ChatMessageEntity(id = this.id, message = this.message,user=this.user, role= this.role)
}
