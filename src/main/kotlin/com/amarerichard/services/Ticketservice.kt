package com.amarerichard.services

import com.amarerichard.database.repository.TicketRepository
import com.amarerichard.model.Ticket
import com.amarerichard.model.callModel.cAllTicket
import com.amarerichard.model.callModel.cDeleteTicket
import com.amarerichard.model.callModel.cTicket
import com.amarerichard.model.callModel.cUpdateTicket
import org.bson.types.ObjectId
import java.util.Date

class Ticketservice {
    private val ticketRepository = TicketRepository()

    suspend fun addTicket(cTicket: cTicket) : Long
    {
        val ticket = Ticket(
            ID = ObjectId().toString(),
            Title = cTicket.name,
            CreatedAt = Date().time.toString()
        )
       return ticketRepository.addticket(cTicket.projectid, cTicket.ticketlistid, ticket)
    }

    suspend fun deleteTicket(cDeleteTicket: cDeleteTicket) : Long
    {
      return ticketRepository.deleteticket(cDeleteTicket.projectid, cDeleteTicket.ticketlistid, cDeleteTicket.ticketid)

    }

    suspend fun updateTicket(cUpdateTicket: cUpdateTicket) : Long
    {
       return ticketRepository.updateticket(cUpdateTicket.projectid, cUpdateTicket.ticketlistid,cUpdateTicket.tickettoupdate)

    }

    suspend fun getAllTicket(cAllTicket: cAllTicket) : List<Ticket>
    {
       return ticketRepository.getAllTicket(cAllTicket.projectid, cAllTicket.ticketlistid)

    }

    suspend fun moveTicket()
    {
       // ticketRepository.movetiket()
        TODO("Not yet implemented")
    }
}