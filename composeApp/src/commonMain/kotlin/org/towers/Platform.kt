package org.towers

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform