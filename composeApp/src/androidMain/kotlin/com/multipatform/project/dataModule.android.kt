package com.multipatform.project

import com.multipatform.project.data.db.ChatDatabase
import org.koin.core.module.Module
import org.koin.android.ext.koin.androidApplication
import org.koin.core.scope.get
import org.koin.dsl.module

/*actual fun databaseModule(): Module = module {
    single { getAndroidDbBuilder(
        ctx = androidApplication(),
    ) }
}*/

actual fun databaseModule() = module {
    single<ChatDatabase> { getAndroidDbBuilder(get()) }
}