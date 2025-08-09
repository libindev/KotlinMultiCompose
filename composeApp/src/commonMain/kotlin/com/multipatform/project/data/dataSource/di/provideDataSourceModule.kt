package com.multipatform.project.data.dataSource.di

import com.multipatform.project.data.dataSource.ChatLocalDataSource
import com.multipatform.project.data.dataSource.ChatLocalDataSourceImpl

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val provideDataSourceModule = module {
    singleOf(::ChatLocalDataSourceImpl).bind(ChatLocalDataSource::class)
}
