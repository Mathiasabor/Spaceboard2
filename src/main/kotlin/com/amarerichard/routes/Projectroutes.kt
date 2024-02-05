package com.amarerichard.routes


import com.amarerichard.handlers.Projecthandler
import io.ktor.server.routing.*

fun Route.Projectroutes()
{
    route("/project")
    {
        this.Projecthandler()
    }
}

