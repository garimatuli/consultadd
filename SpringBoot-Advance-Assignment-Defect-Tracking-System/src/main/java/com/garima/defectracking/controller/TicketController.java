package com.garima.defectracking.controller;

import com.garima.defectracking.common.AppException;
import com.garima.defectracking.common.ResourceNotFound;
import com.garima.defectracking.entity.Ticket;
import com.garima.defectracking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController

@RequestMapping("/defectracking")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/getTickets")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Ticket> getTickets(){
        List<Ticket> tickets = ticketService.getTickets();
        return tickets;
    }

    @GetMapping("/application/{appId}/getTicketsByAppId")
    public @ResponseBody
    Set<Ticket> getTicketsByAppId(@PathVariable(value = "appId") long appId) throws AppException {
        try {
            return ticketService.getTicketsByAppId(appId);
        }catch (AppException e){
            throw new AppException(e.getMessage());
        }
    }


    @PostMapping("/postTicket")
    public ResponseEntity<String> addTicket(@RequestBody Ticket ticket) throws AppException {
        try {
            String message = ticketService.postTicket(ticket);
            return new ResponseEntity<String >(message,HttpStatus.OK);
        }catch (AppException e){
            throw new AppException(e.getMessage());
        }
    }

    @PutMapping("/updateTicket/{ticketId}")
    public ResponseEntity<String> updateTicket(@PathVariable (value = "ticketId") long ticketId, @RequestBody Ticket ticket) {
        try {
            String msg = ticketService.updateTicket(ticketId,ticket);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (ResourceNotFound e){
            throw new ResourceNotFound("Ticket",ticketId);
        }
    }


    @DeleteMapping("/deleteTicket/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable(value = "id") long id) throws AppException {
        try {
            String msg = ticketService.deleteTicket(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (AppException e){
            throw new AppException(e.getMessage());
        }
    }
}
