package main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import main.Dto.AppointmentDto;
import main.Service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	
	@Autowired
	private AppointmentService service;
	

//booking
	
	@PostMapping("/booking")
	public String booking(@Valid @RequestBody AppointmentDto dto) {
		
		
		return service.booking(dto);
	}
	



}
