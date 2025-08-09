package com.multipatform.project

import androidx.compose.ui.window.ComposeUIViewController
import com.multipatform.project.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }