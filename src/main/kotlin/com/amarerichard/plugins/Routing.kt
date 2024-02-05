package com.amarerichard.plugins

import com.amarerichard.routes.Projectroutes
import com.amarerichard.routes.Ticketlistroutes
import com.amarerichard.routes.Ticketroutes
import com.amarerichard.utils.RabbitMQFactory
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
