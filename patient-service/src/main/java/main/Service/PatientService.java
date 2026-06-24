package main.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import main.Dto.PatientDto;
import main.Entity.Patient;
import main.Exception.EmailExistsException;
import main.Exception.PatientNotFoundException;
import main.Repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository repo;

	public String createPatient(@Valid PatientDto dto) {
		// TODO Auto-generated method stub
		
		if(repo.existsByEmail(dto.getEmail())) {
			
			throw new EmailExistsException("this email already registered");
		}
		
		
		Patient patient=new Patient();
		
		patient.setEmail(dto.getEmail());
		patient.setMobilenum(dto.getMobilenum());
		patient.setName(dto.getName());
		
		
		repo.save(patient);
		
		
		return null;
	}

	public Patient getbyid(Integer id) {
		// TODO Auto-generated method stub
		
		
		Patient patient=repo.findById(id)
				.orElseThrow(()->new PatientNotFoundException("this id not register based on email"));
		
		return patient;
	}
	
	
	
	//register
	
	
	

}
