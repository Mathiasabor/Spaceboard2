package com.amarerichard.model

import kotlinx.serialization.Serializable

@Serializable
data class Projectwithrole(
    val Projectid :String,
    val Role : String
)
