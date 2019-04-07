package com.danielpm1982.SOAP_WS2_Client.helper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import com.danielpm1982.soap_ws2.ws.Patient;
import com.danielpm1982.soap_ws2.ws.PersonManager;
import com.danielpm1982.soap_ws2.ws.PersonManagerService;
import com.danielpm1982.soap_ws2.ws.Professional;

public class PersonManagerHelper {
	private static PersonManagerService personManagerService;
	private static PersonManager personManagerPort;
	static {
		try {
			personManagerService = new PersonManagerService(new URL("http://localhost:8080/SOAP_WS2/api/personService?wsdl"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		personManagerPort = personManagerService.getPersonManagerPort();
	}
	public static List<Patient> getAllPatients(){
		return personManagerPort.getPatientAll();
	}
	public static Patient getPatientById(long patientId){
		return personManagerPort.getPatientById(patientId);
	}
	public static List<Professional> getAllProfessionals(){
		return personManagerPort.getProfessionalAll();
	}
	public static Professional getProfessionalById(long professionalId){
		return personManagerPort.getProfessionalById(professionalId);
	}
}
