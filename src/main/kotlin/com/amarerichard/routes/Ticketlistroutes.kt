package com.amarerichard.routes

import com.amarerichard.handlers.TicketlistHandler
import io.ktor.server.routing.*

fun Route.Ticketlistroutes()
{
    route("/ticketlist")
    {
        this.TicketlistHandler()
    }
}