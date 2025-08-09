package com.multipatform.project.di

import com.multipatform.project.data.dataSource.di.provideDataSourceModule
import com.multipatform.project.data.di.provideChatRepositoryModule
import com.multipatform.project.databaseModule
import com.multipatform.project.domain.di.provideDomainModule
import com.multipatform.project.presentation.di.provideChatViewModelModule

fun appModule() = listOf(providehttpClientModule,provideChatViewModelModule,provideDomainModule,
    provideDataSourceModule,provideChatRepositoryModule, provideviewModelModule,databaseModule())
