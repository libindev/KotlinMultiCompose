package com.multipatform.project.data.di

import com.multipatform.project.data.repository.ChatRepositoryImpl
import com.multipatform.project.domain.repository.ChatRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val provideChatRepositoryModule = module {
    singleOf(::ChatRepositoryImpl) { bind<ChatRepository>() }
}