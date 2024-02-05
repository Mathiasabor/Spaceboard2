package com.amarerichard.handlers

import com.amarerichard.model.callModel.cDeleteticketlist
import com.amarerichard.model.callModel.cTicketlist
import com.amarerichard.model.callModel.cUpdateTicketlist
import com.amarerichard.services.Ticketlistservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.TicketlistHandler()
{
    val ticketlistservice = Ticketlistservice()
    get ("/all"){
        val projectid = call.receiveText()
        call.respond(ticketlistservice.getAllTicketlist(projectid))
    }

    post ("/create"){
        val cticketlist = call.receive<cTicketlist>()
        call.respond(ticketlistservice.addTicketlist(cticketlist))


    }

    delete("/delete"){
        val cdeleteticketlist = call.receive<cDeleteticketlist>()

        call.respond(ticketlistservice.deleteTicketlist(cdeleteticketlist))
    }

    put("/update")
    {
        val cupdateticketlist = call.receive<cUpdateTicketlist>()
        call.respond(ticketlistservice.updateTicketlist(cupdateticketlist))

    }
}