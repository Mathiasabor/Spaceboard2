package com.amarerichard.model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val Id : String,
    val Name : String,
    val Author : Author,
    val Members : MutableList<Member> = mutableListOf(),
    val Ticketlists : MutableList<Ticketlist> = mutableListOf()
)
