package com.multipatform.project.domain.di

import com.multipatform.project.domain.usecase.GetChatMessageUseCase
import com.multipatform.project.domain.usecase.InsertChatMessageUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Koin module that provides domain layer dependencies (use cases) for the features.
 */
val provideDomainModule = module {
    singleOf(::GetChatMessageUseCase)
    singleOf(::InsertChatMessageUseCase)
}