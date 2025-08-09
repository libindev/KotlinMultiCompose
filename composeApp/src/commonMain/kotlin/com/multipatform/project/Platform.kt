package com.multipatform.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform