package com.amarerichard.model.callModel

import com.amarerichard.model.Author
import com.amarerichard.model.Ticket
import com.amarerichard.model.Ticketlist
import kotlinx.serialization.Serializable

@Serializable
data class cProject(
    val name : String,
    val author: Author
)
@Serializable
data class cTicketlist(
    val projectid : String,
    val name : String
)
@Serializable
data class cDeleteticketlist(
    val projectid : String,
    val ticketlistid : String
)

@Serializable
data class cUpdateTicketlist(
    val projectid : String,
    val ticketlisttoupdate: Ticketlist
)

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
@Serializable
data class cTicket(
    val projectid: String,
    val ticketlistid: String,
    val name: String
)

@Serializable
data class cDeleteTicket(
    val projectid: String,
    val ticketlistid: String,
    val ticketid: String
)

@Serializable
data class cUpdateTicket(
    val projectid: String,
    val ticketlistid: String,
    val tickettoupdate: Ticket
)

@Serializable
data class cAllTicket(
    val projectid: String,
    val ticketlistid: String,
)



