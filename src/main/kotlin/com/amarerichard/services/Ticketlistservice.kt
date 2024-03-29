package com.amarerichard.services

import com.amarerichard.database.repository.TicketlistRepository
import com.amarerichard.model.Ticketlist
import com.amarerichard.model.callModel.cDeleteticketlist
import com.amarerichard.model.callModel.cTicketlist
import com.amarerichard.model.callModel.cUpdateTicketlist
import org.bson.types.ObjectId

class Ticketlistservice {
    private val ticketlistRepository = TicketlistRepository()
    private val projectservice = Projectservice()
    suspend fun addTicketlist(cTicketlist: cTicketlist): String
    {
        val ticketlist = Ticketlist(Id = ObjectId().toString(),Title = cTicketlist.name)
       return ticketlistRepository.addticketlist(cTicketlist.projectid, ticketlist)
    }

    suspend fun deleteTicketlist(cDeleteticketlist: cDeleteticketlist) : Long
    {
        return ticketlistRepository.deleteticketlist(cDeleteticketlist.projectid, cDeleteticketlist.ticketlistid)

    }

    suspend fun updateTicketlist(cUpdateTicketlist: cUpdateTicketlist) : Long
    {
        return ticketlistRepository.updateticketlist(cUpdateTicketlist.projectid, cUpdateTicketlist.ticketlisttoupdate)
    }

    suspend fun getAllTicketlist(projectid: String) : List<Ticketlist>
    {
        return ticketlistRepository.getAllTicketlist(projectid)
    }
}