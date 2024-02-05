package com.amarerichard.model

import kotlinx.serialization.Serializable

@Serializable
data class Ticketlist(
    val Id : String,
    val Title : String,
    var Tickets : MutableList<Ticket> = mutableListOf()
)
