package main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import main.Dto.PatientDto;
import main.Entity.Patient;
import main.Service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	
	
	@Autowired
	
	private PatientService service;
	
	
	//register
	
	@PostMapping("/register")
	public String createPatient(@Valid @RequestBody PatientDto dto) {
		
		return service.createPatient(dto);
	}
	
	
	@GetMapping("/getById/{id}")
	public Patient getbyid(@PathVariable Integer id) {
		
		return service.getbyid(id);
	}

}
