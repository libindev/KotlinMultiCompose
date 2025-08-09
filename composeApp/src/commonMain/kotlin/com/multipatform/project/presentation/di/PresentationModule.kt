package com.multipatform.project.presentation.di

import com.multipatform.project.presentation.ChatViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


/**
 * Koin module that provides presentation layer dependencies (ViewModel) for the Vvv feature.
 */


val provideChatViewModelModule = module {
    viewModelOf(::ChatViewModel)
}