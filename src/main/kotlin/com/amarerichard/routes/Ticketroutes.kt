package com.amarerichard.routes

import com.amarerichard.handlers.Tickethandler
import io.ktor.server.routing.*

fun Route.Ticketroutes()
{
    route("/ticket")
    {
        this.Tickethandler()
    }
}