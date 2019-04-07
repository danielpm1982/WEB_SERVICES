package com.danielpm1982.SOAP_WS2.ws;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import com.danielpm1982.SOAP_WS2.dto.Patient;
import com.danielpm1982.SOAP_WS2.dto.Professional;

public class PersonManager implements PersonManagerInterface{
	private List<Patient> patientList;
	private List<Professional> professionalList;
	public PersonManager() {
		Patient patient1 = new Patient(BigInteger.valueOf(1), "patient1Name", "patient1Address", "patient1Email", "patient1PhoneNo");
		Patient patient2 = new Patient(BigInteger.valueOf(2), "patient2Name", "patient2Address", "patient2Email", "patient2PhoneNo");
		Professional professional1 = new Professional(BigInteger.valueOf(1), "professional1Name", "professional1Address", "professional1Email", "professional1PhoneNo", "professional1Profession", "professional1Specialty", "professional1Registry");
		Professional professional2 = new Professional(BigInteger.valueOf(2), "professional2Name", "professional2Address", "professional2Email", "professional2PhoneNo", "professional2Profession", "professional2Specialty", "professional2Registry");
		Professional professional3 = new Professional(BigInteger.valueOf(3), "professional3Name", "professional3Address", "professional3Email", "professional3PhoneNo", "professional3Profession", "professional3Specialty", "professional3Registry");
		patientList = Arrays.asList(patient1, patient2);
		professionalList = Arrays.asList(professional1, professional2, professional3);
	}
	@Override
	public Patient getPatientById(long patientId) {
		Patient patient = patientList.stream().parallel().filter(x->x.getPatientId().longValue()==patientId).findFirst().orElse(null);
		if(patient!=null){
			return patient; 
		} else {
			throw new RuntimeException("No Patient found for that Id!");
		}
	}
	@Override
	public List<Patient> getPatientAll() {
		return patientList;
	}
	@Override
	public List<Professional> getProfessionalAll() {
		return professionalList;
	}
	@Override
	public Professional getProfessionalById(long professionalId) {
		Professional professional = professionalList.stream().parallel().filter(x->x.getProfessionalId().longValue()==professionalId).findFirst().orElse(null);
		if(professional!=null){
			return professional; 
		} else {
			throw new RuntimeException("No Professional found for that Id!");
		}
	}
}
