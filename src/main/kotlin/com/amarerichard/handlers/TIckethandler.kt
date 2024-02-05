package com.amarerichard.handlers

import com.amarerichard.model.callModel.cAllTicket
import com.amarerichard.model.callModel.cDeleteTicket
import com.amarerichard.model.callModel.cTicket
import com.amarerichard.model.callModel.cUpdateTicket
import com.amarerichard.services.Ticketservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.Tickethandler(){
    val ticketservice = Ticketservice()
    get("/all") {
       val cAllTicket = call.receive<cAllTicket>()
    call.respond(ticketservice.getAllTicket(cAllTicket))

    }

    post("/create") {
        val cticket = call.receive<cTicket>()
        call.respond(ticketservice.addTicket(cticket))
    }

    delete ("/delete"){
        val cDeleteTicket = call.receive<cDeleteTicket>()
        call.respond(ticketservice.deleteTicket(cDeleteTicket))
    }

    put ("/update"){
        val cUpdateTicket = call.receive<cUpdateTicket>()
        call.respond(ticketservice.updateTicket(cUpdateTicket))
    }

    put ("/move"){

    }
}