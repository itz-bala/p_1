package main.Dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AppointmentDto {
	
	@NotNull(message="patient id is ,must be")
	private  Integer patient_id;
	
	@NotBlank(message="doctor name must be")
	private String doctor_name;
	
	
	@NotNull(message="appointment date is must be")
	private LocalDateTime appointment_date;


	public Integer getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}


	public String getDoctor_name() {
		return doctor_name;
	}


	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}


	public LocalDateTime getAppointment_date() {
		return appointment_date;
	}


	public void setAppointment_date(LocalDateTime appointment_date) {
		this.appointment_date = appointment_date;
	}
	
	
	


}
