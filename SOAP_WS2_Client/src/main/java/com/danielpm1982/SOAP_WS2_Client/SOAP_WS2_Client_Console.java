package com.danielpm1982.SOAP_WS2_Client;
import java.net.MalformedURLException;
import com.danielpm1982.SOAP_WS2_Client.helper.AppointmentManagerHelper;
import com.danielpm1982.SOAP_WS2_Client.helper.PersonManagerHelper;

public class SOAP_WS2_Client_Console {
	public static void main(String[] args) throws MalformedURLException {
		testAppointmentServices();
		testPersonServices();
		testServicesTogether();
	}
	private static void testAppointmentServices() {
		System.out.println("Listing all appointments:");
		AppointmentManagerHelper.getAllAppointments().forEach(System.out::println);
		AppointmentManagerHelper.createAppointmentSample1();
		AppointmentManagerHelper.createAppointmentSample2();
		AppointmentManagerHelper.createAppointmentSample3();
		System.out.println("Listing all appointments:");
		AppointmentManagerHelper.getAllAppointments().forEach(System.out::println);
		System.out.println("Getting 1st appointment:");
		System.out.println(AppointmentManagerHelper.getAppointmentById(1));
	}
	private static void testPersonServices() {
		System.out.println("Listing all Patients");
		PersonManagerHelper.getAllPatients().forEach(System.out::println);
		System.out.println("Listing all Professionals");
		PersonManagerHelper.getAllProfessionals().forEach(System.out::println);
	}
	private static void testServicesTogether() {
		System.out.println("Listing all appointments with Patients and Professionals:");
		AppointmentManagerHelper.getAllAppointments().forEach(x->System.out.println(x+" Patient: "+PersonManagerHelper.getPatientById(x.getPatientId().longValue())+" Professional: "+PersonManagerHelper.getProfessionalById(x.getProfessionalId().longValue())));
	}
}

//this is a console testing class. Use the other main class for testing of the project as a whole, including
//the web user interface.
