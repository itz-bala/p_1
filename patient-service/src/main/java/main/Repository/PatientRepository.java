package main.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{
	
	Optional<Patient>findById(Integer id);
	
	boolean existsByEmail(String email);
	
	

}
