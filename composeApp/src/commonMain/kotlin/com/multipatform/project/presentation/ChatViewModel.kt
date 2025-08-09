package com.multipatform.project.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multipatform.project.domain.model.ChatMessage
import com.multipatform.project.domain.usecase.GetChatMessageUseCase
import com.multipatform.project.domain.usecase.InsertChatMessageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class ChatViewModel(
    private val getChatMessagesUseCase: GetChatMessageUseCase,
    private val insertChatMessageUseCase: InsertChatMessageUseCase

) : ViewModel() { // Or your preferred ViewModel base

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())

    val messages: StateFlow<List<ChatMessage>> = _messages
    private val _error = MutableStateFlow<String?>(null)

    val error: StateFlow<String?> = _error

    init {
        loadMessages()
    }

    private  fun loadMessages() {
        viewModelScope.launch {
            getChatMessagesUseCase()
                .onEach { messageList ->
                    _messages.value = messageList
                }
                .launchIn(viewModelScope)
        }
       // Use the ViewModel's scope
    }

   fun insertMessage(user: String, messageText: String){
       viewModelScope.launch {
           val message = ChatMessage(message = messageText, user = user, role = "admin")
           insertChatMessageUseCase.invoke(message)
       }
   }


}
