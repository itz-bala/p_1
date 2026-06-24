package main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{
	
	

}
