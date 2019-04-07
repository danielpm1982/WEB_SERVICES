package com.danielpm1982.SOAP_WS2.ws;
import java.util.ArrayList;
import java.util.List;
import com.danielpm1982.SOAP_WS2.dto.Appointment;

public class AppointmentManager implements AppointmentManagerInterface{
	List<Appointment> appointmentList;
	public AppointmentManager() {
		appointmentList = new  ArrayList<>();
	}
	@Override
	public Appointment getAppointmentById(long appointmentId) {
		Appointment appointment = appointmentList.stream().parallel().filter(x->x.getAppointmentId().longValue()==appointmentId).findFirst().orElse(null);
		if(appointment!=null){
			return appointment; 
		} else {
			throw new RuntimeException("No Appointment found for that Id!");
		}
	}
	@Override
	public List<Appointment> getAppointmentAll() {
		return appointmentList;
	}
	@Override
	public Appointment createAppointment(Appointment appointment) {
		if(appointmentList.stream().filter(x->x.getAppointmentId().longValue()==appointment.getAppointmentId().longValue()).findAny().orElse(null)==null){
			appointmentList.add(appointment);
		} else {
			throw new RuntimeException("AppointmentId already exists! Cannot overwrite the same appointment registry!");
		}
		return appointment;
	}
}
