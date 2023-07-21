package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.model.Ticket_Booking;
import com.example.repo.TicketRepo;

@Service
public class TicketService {
	
	@Autowired
	TicketRepo repo;
	
	public List<Ticket_Booking> getall(){
		return repo.findAll();
	}
	
	public void addBooking(Ticket_Booking ticket) {
		try {
			repo.save(ticket);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBooking(int id) {
		if(repo.findById(id).isPresent()==false) {
			throw new ResourceNotFoundException("Resource Not Found with ID "+id);
		}else {
			repo.deleteById(id);
		}
	}
	
	public void updateBooking(int id, Ticket_Booking ticket) {
		if(repo.findById(id).isPresent()==false) {
			throw new ResourceNotFoundException("Resource Not found with ID "+id);
		}else {
			repo.save(ticket);
		}
	}

}
