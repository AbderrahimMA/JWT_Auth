package com.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content";
	}
	
	@GetMapping("/citizen")
	@PreAuthorize("hasRole('CITIZEN') or hasRole('AGENT') or hasRole('ADMINISTRATOR')")
	public String citizenAccess() {
		return "Citizen Content";
	}
	
	/*
	 * @GetMapping("/agent")
	 * 
	 * @PreAuthorize("hasRole('AGENT')") 
	 * public String moderatorAccess() { 
	 * return "Agent Content"; 
	 * }
	 */
	
	@GetMapping("/administration")
	@PreAuthorize("hasRole('ADMINISTRATOR') or hasRole('AGENT')")
	public String administratorAccess() {
		return "Administration Content";
	}

}
