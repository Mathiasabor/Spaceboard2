package com.amarerichard.plugins

import com.amarerichard.routes.Projectroutes
import com.amarerichard.routes.Ticketlistroutes
import com.amarerichard.routes.Ticketroutes
import com.amarerichard.services.Projectservice
import com.amarerichard.utils.RabbitMQFactory
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Application.configureRouting() {


    routing {

        Projectroutes()
        Ticketlistroutes()
        Ticketroutes()
        RabbitMQFactory().defaultChannelAndQueue().listeningMessage()
       get("/") {
           val projectservice = Projectservice()
           val list = projectservice.getAllProject()
           val jsonString = Json.encodeToString(list)
           RabbitMQFactory().sendMessage(jsonString.toByteArray())

           call.respond(jsonString)
       }


    }
}
