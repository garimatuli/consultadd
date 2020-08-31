package com.garima.defectracking.repository;

import com.garima.defectracking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

//    @Query(value = "SELECT * FROM ticket WHERE ticket.application_id=?",nativeQuery = true)
//    Set<Ticket> getTicketsByAppId(long appId);
}
