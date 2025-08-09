package com.multipatform.project

import org.koin.core.module.Module
import org.koin.dsl.module

actual fun databaseModule(): Module = module {
    single { getIosDatabaseBuilder() }
}
