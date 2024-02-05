package com.amarerichard.model

import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    val ID : String,
    var Title : String,
    var Description: String ="",
    var StartDate : String="",
    var EndDate : String="",
    var Type : String ="",
    var Priority : String="",
    val CreatedAt : String,
    var UpdatedAt : String=""
)
