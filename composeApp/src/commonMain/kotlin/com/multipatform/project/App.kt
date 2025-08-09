package com.multipatform.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.multipatform.project.domain.model.ChatMessage
import com.multipatform.project.presentation.ChatViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {

    val viewModel = koinViewModel<ChatViewModel>()
    val people by viewModel.messages.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                showContent = !showContent
            }) {
                Text("Add Message")
            }

            LazyColumn {
                items(people.size) {
                    ChatMessageItem(people[it])
                }
            }
        }

        AddChatMessageDialog(
            showDialog = showContent,
            onDismissRequest = {
                showContent = false
            },
            onSendMessage = {user, messageText ->
                viewModel.insertMessage(user,messageText)
                showContent = false

            }
        )
    }


}



@Composable
fun ChatMessageItem(message: ChatMessage) {

    val isCurrentUser = message.user == "Alice" // Example: Define how to check current user

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = if (isCurrentUser) 64.dp else 0.dp, // Indent if not current user's message
                end = if (isCurrentUser) 0.dp else 64.dp    // Indent if current user's message
            ),
        horizontalAlignment = if (isCurrentUser) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = if (isCurrentUser) 16.dp else 0.dp,
                        bottomEnd = if (isCurrentUser) 0.dp else 16.dp
                    )
                )
                .background(
                    if (isCurrentUser) MaterialTheme.colorScheme.primaryContainer
                    else MaterialTheme.colorScheme.secondaryContainer
                )
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Column {
                Text(
                    text = message.user,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = if (isCurrentUser) MaterialTheme.colorScheme.onPrimaryContainer
                    else MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = message.message,
                    fontSize = 16.sp,
                    color = if (isCurrentUser) MaterialTheme.colorScheme.onPrimaryContainer
                    else MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}

@Composable
fun AddChatMessageDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    onSendMessage: (user: String, messageText: String) -> Unit
) {
    if (showDialog) {
        val focusRequester = remember { FocusRequester() }

        var user by remember { mutableStateOf("") }
        var messageText by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text("New Message") },
            text = {
                Column {

                    OutlinedTextField(
                        value = user,
                        onValueChange = { newText -> user = newText },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        label = { Text("User Name..") },
                        singleLine = false, // Allow multi-line messages if desired
                        maxLines = 5
                    )
                    OutlinedTextField(
                        value = messageText,
                        onValueChange = { newText -> messageText = newText },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        label = { Text("Type your message...") },
                        singleLine = false, // Allow multi-line messages if desired
                        maxLines = 5
                    )


                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onSendMessage(user,messageText)
                    }
                ) {
                    Text("Send")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissRequest
                ) {
                    Text("Cancel")
                }
            },
            properties = DialogProperties(dismissOnClickOutside = true, dismissOnBackPress = true)
        )

        // Request focus on the TextField when the dialog appears
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}