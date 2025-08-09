package com.multipatform.project.di

import com.multipatform.project.presentation.ChatViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val provideviewModelModule = module {
    viewModelOf(::ChatViewModel)
}