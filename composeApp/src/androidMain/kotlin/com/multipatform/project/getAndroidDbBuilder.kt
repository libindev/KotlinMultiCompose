package com.multipatform.project

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.multipatform.project.data.db.ChatDatabase
import kotlinx.coroutines.Dispatchers


// In androidMain
fun getAndroidDbBuilder(ctx: Context): ChatDatabase {
  val dbFile = ctx.getDatabasePath("chat_db")
  return Room.databaseBuilder<ChatDatabase>(ctx, dbFile.absolutePath)
    .setDriver(BundledSQLiteDriver())
    .setQueryCoroutineContext(Dispatchers.IO)
    .build()
}