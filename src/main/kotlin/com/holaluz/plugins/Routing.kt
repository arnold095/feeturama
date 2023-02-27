package com.holaluz.plugins

import com.holaluz.application.UserFinder
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val useCase by inject<UserFinder>()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/users/{id}") {
            val user = useCase.find(call.parameters["id"]!!)

            call.respondText("Hello ${user.name}")
        }
    }
}
