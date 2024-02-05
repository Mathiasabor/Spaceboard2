package com.amarerichard.plugins

import com.example.routes.Projectroutes
import com.example.routes.Ticketlistroutes
import com.example.routes.Ticketroutes
import com.example.utils.RabbitMQFactory
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {

        Projectroutes()
        Ticketlistroutes()
        Ticketroutes()
        RabbitMQFactory().defaultChannelAndQueue().listeningMessage()

        get("/") {
            call.respondText("Hello World!")
        }
    }
}
