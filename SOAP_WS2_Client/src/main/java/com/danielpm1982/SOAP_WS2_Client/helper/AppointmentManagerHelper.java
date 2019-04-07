package com.danielpm1982.SOAP_WS2_Client.helper;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import com.danielpm1982.soap_ws2.ws.Appointment;
import com.danielpm1982.soap_ws2.ws.AppointmentManager;
import com.danielpm1982.soap_ws2.ws.AppointmentManagerService;

public class AppointmentManagerHelper {
	private static AppointmentManagerService appointmentManagerService;
	private static AppointmentManager appointmentManagerPort;
	static {
		try {
			appointmentManagerService = new AppointmentManagerService(new URL("http://localhost:8080/SOAP_WS2/api/appointmentService?wsdl"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		appointmentManagerPort = appointmentManagerService.getAppointmentManagerPort();
	}
	public static List<Appointment> getAllAppointments(){
		return appointmentManagerPort.getAppointmentAll();
	}
	public static Appointment getAppointmentById(long appointmentId){
		return appointmentManagerPort.getAppointmentById(appointmentId);
	}
	public static Appointment createAppointmentSample1(){
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(BigInteger.valueOf(1));
		appointment.setPatientId(BigInteger.valueOf(1));
		appointment.setProfessionalId(BigInteger.valueOf(3));
		appointment.setAppointmentAddress("appointment1Address");
		appointment.setAppointmentLocalDateTimeString(java.time.LocalDateTime.now().toString());
		appointment.setAppointmentDetails("none.");
		appointmentManagerPort.createAppointment(appointment);
		return appointment;
	}
	public static Appointment createAppointmentSample2(){
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(BigInteger.valueOf(2));
		appointment.setPatientId(BigInteger.valueOf(2));
		appointment.setProfessionalId(BigInteger.valueOf(2));
		appointment.setAppointmentAddress("appointment2Address");
		appointment.setAppointmentLocalDateTimeString(java.time.LocalDateTime.now().toString());
		appointment.setAppointmentDetails("none.");
		appointmentManagerPort.createAppointment(appointment);
		return appointment;
	}
	public static Appointment createAppointmentSample3(){
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(BigInteger.valueOf(3));
		appointment.setPatientId(BigInteger.valueOf(2));
		appointment.setProfessionalId(BigInteger.valueOf(1));
		appointment.setAppointmentAddress("appointment3Address");
		appointment.setAppointmentLocalDateTimeString(java.time.LocalDateTime.now().toString());
		appointment.setAppointmentDetails("none.");
		appointmentManagerPort.createAppointment(appointment);
		return appointment;
	}
	public static String getLocalizedDateTimeString(String localDateTimeString) {
		String result;
		try {
			result = LocalDateTime.parse(localDateTimeString).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM));
		} catch (Exception e) {
			System.out.println(e);
			result = "LocalDateTime parsing failed. Maybe localDateTimeString is in an invalid format. Valid format is: 'yyyy-mm-ddThh:mm:ss'";
		}
		return result;
	}
}
