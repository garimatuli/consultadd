package com.garima.defectracking.service;

import com.garima.defectracking.common.AppException;
//import com.garima.defectracking.dto.TicketDTO;
import com.garima.defectracking.common.ResourceNotFound;
import com.garima.defectracking.entity.Application;
import com.garima.defectracking.entity.Ticket;
import com.garima.defectracking.repository.ApplicationRepository;
import com.garima.defectracking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public List<Ticket> getTickets() {
        List<Ticket> ticketList = ticketRepository.findAll();
        return ticketList;
//        List<TicketDTO> ticketDTOList = new ArrayList<>();
//        for (Ticket ticket: ticketList) {
//            TicketDTO ticketDTO = new TicketDTO();
//            ticketDTO.setTicketId(ticket.getTicketId());
//            ticketDTO.setTicketTitle(ticket.getTicketTitle());
//            ticketDTO.setTicketDescription(ticket.getTicketDescription());
//            ticketDTO.setTicketStatus(ticket.getTicketStatus());
//            Optional<Application> application = applicationRepository.findById(ticket.getApplication().getAppId());
//            ticketDTO.setApplication(application.get());
//            ticketDTOList.add(ticketDTO);
//        }
//            return ticketDTOList;
    }

    @Override
      public Set<Ticket> getTicketsByAppId(long appId) throws AppException {
        Optional<Application> app = applicationRepository.findById(appId);
        if (app.isPresent()) {
            Application foundApp = app.get();
            Set<Ticket> ticketSet = foundApp.getTickets();
            return ticketSet;
        }
        else
//            throw new ResourceNotFoundException("Application with id " + appId + " not found");
        throw new AppException("No Application exists with id " + appId);
    }

    @Override
    public String postTicket(Ticket ticket) throws AppException {

//        Ticket ticket = new Ticket();
//        ticket.setTicketStatus(ticketDTO.getTicketStatus());
//        ticket.setTicketDescription(ticketDTO.getTicketDescription());
//        ticket.setTicketTitle(ticketDTO.getTicketTitle());
//        ticket.setApplication(ticketDTO.getApplication());
        Date date = new Date();
        ticket.setCreationDate(date);
        ticket.setLastModifiedDate(date);
        Ticket addedTicket = ticketRepository.save(ticket);
        if(addedTicket.equals(null))
            throw new AppException("Error in ticket creation");
        else
            return "Ticket created successfully";
    }

    @Override
    public String updateTicket(long ticketId, Ticket ticket){
        Optional<Ticket> foundTicketWithId = ticketRepository.findById(ticketId);
        Date date = new Date();
        if (foundTicketWithId.isPresent()) {
            Ticket foundTicket = foundTicketWithId.get();
            foundTicket.setTicketTitle(ticket.getTicketTitle());
            foundTicket.setTicketStatus(ticket.getTicketStatus());
            foundTicket.setTicketDescription(ticket.getTicketDescription());
            foundTicket.setApplication(ticket.getApplication());
            foundTicket.setLastModifiedDate(date);
            ticketRepository.save(foundTicket);
            return "Ticket updated successfully";
        } else {
            throw new ResourceNotFound("Ticket",ticketId);
        }
    }

    @Override
    public String deleteTicket(long id) throws AppException {
        Optional<Ticket> foundTicket = ticketRepository.findById(id);
        if (foundTicket.isPresent()) {
            ticketRepository.deleteById(id);
//            ticketRepository.delete(foundTicket.get());
            return "Ticket deleted successfully";
        }else {
            throw new AppException("No such ticket exists with id "+id);
        }
    }
}
