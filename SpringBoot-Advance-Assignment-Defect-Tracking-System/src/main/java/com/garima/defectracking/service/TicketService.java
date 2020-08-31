package com.garima.defectracking.service;

import com.garima.defectracking.common.AppException;
//import com.garima.defectracking.dto.TicketDTO;
import com.garima.defectracking.entity.Ticket;

import java.util.List;
import java.util.Set;

public interface TicketService {
    public List<Ticket> getTickets();
    String postTicket(Ticket ticket) throws AppException;
    public Set<Ticket> getTicketsByAppId(long appId) throws AppException;
    public String updateTicket(long ticketId, Ticket ticket);
    public String deleteTicket(long id) throws AppException;
}
