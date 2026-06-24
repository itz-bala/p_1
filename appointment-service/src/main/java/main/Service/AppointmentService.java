package main.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.Valid;
import main.Dto.AppointmentDto;
import main.Dto.PatientDto;
import main.Entity.Appointment;
import main.Exception.PatientNotFoundException;
import main.Repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	
	@Autowired
	private AppointmentRepository repo;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	//booking

	public String booking( AppointmentDto dto) {
		// TODO Auto-generated method stub
		
	PatientDto patient=restTemplate.getForObject("http://localhost:8001/patient/getById/"+dto.getPatient_id(), PatientDto.class);	
		
	if(patient==null) {
		
		
	throw new PatientNotFoundException("patient is not found");	
		
	}
	
	Appointment appointment=new Appointment();
	
	appointment.setDoctor_name(dto.getDoctor_name());
	appointment.setPatient_id(dto.getPatient_id());
	appointment.setAppointment_date(dto.getAppointment_date());
	
	repo.save(appointment);
	
	
		return "appointment booked successfully";
	}

}
