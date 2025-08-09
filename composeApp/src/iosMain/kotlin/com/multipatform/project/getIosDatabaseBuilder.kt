package com.multipatform.project

import androidx.room.Room
import androidx.room.RoomDatabase
import com.multipatform.project.data.db.ChatDatabase
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask


fun getIosDatabaseBuilder(): RoomDatabase.Builder<ChatDatabase> {
  val docDir = NSFileManager.defaultManager.URLForDirectory(
    directory = NSDocumentDirectory,
    inDomain = NSUserDomainMask,
    appropriateForURL = null,
    create = false,
    error = null
  )
  val dbFilePath = requireNotNull(docDir?.path) + "/chat_db"
  return Room.databaseBuilder<ChatDatabase>(
    name = dbFilePath
  )
}