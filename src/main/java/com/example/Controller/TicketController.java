package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Service.TicketService;
import com.example.Service.UserService;
import com.example.model.Ticket_Booking;
import com.example.model.Users;

import net.bytebuddy.build.RepeatedAnnotationPlugin;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService service;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/home")
	public String showAll(Model model) {
		model.addAttribute("tickets", service.getall());
		return "home";
	}
	
	@GetMapping("/add")
	public String addBooking(Model model) {
		Ticket_Booking tb = new Ticket_Booking();
		model.addAttribute("addticket", tb);
		return "addBooking";
	}
	
	@PostMapping("/savebooking")
	public String saveBooking(@ModelAttribute("addticket")Ticket_Booking tb) {
		service.addBooking(tb);
		return "redirect:/ticket/home";
	}
	
	@GetMapping("/del")
	public String delBooking(@RequestParam("id") int id) {
		service.deleteBooking(id);
		return "redirect:/ticket/home";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user")Users user) {
		user.setPasscode(encoder.encode(user.getPasscode()));
		userservice.SaveUser(user);
		return "redirect:/ticket/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
