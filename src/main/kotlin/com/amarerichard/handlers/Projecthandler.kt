package com.amarerichard.handlers

import com.amarerichard.model.Project

import com.amarerichard.model.callModel.cProject

import com.amarerichard.services.Projectservice
import com.amarerichard.utils.RabbitMQFactory
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Route.Projecthandler()
{
    val projectservice = Projectservice()
    get ("/all"){

        val list = projectservice.getAllProject()
        val jsonString = Json.encodeToString(list)
        RabbitMQFactory().sendMessage(jsonString.toByteArray())

        call.respond(projectservice.getAllProject())
    }

    post ("/create"){
        val projectTocreate = call.receive<cProject>()
        call.respond(projectservice.addProject(projectTocreate))
    }

    delete("/delete"){
        val projectid = call.parameters["projectid"]
        call.respond(projectservice.deleteProject(projectid!!))
    }

    put("/update")
    {
        val projectToUpdate = call.receive<Project>()
        call.respond(projectservice.updateProject(projectToUpdate))
    }

}





