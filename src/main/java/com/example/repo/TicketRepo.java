package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Ticket_Booking;

@Repository
public interface TicketRepo extends JpaRepository<Ticket_Booking, Integer>{

}
