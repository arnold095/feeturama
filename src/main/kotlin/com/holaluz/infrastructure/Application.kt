package com.holaluz.infrastructure

import com.holaluz.application.UserFinder
import com.holaluz.domain.UserRepository
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.holaluz.plugins.*
import org.koin.dsl.module
import org.koin.ktor.plugin.koin

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
            .start(wait = true)
}

fun Application.module() {
    dependencyInjection()
    configureRouting()
}

fun Application.dependencyInjection() {
    koin {
        modules(
            sharedDependencies
        )
    }
}

val sharedDependencies = module {
    single<UserRepository> { InMemoryUserRepository() }
    single{ UserFinder() }
}