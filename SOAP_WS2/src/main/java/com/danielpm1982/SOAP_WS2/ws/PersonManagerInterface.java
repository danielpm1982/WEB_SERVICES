package com.danielpm1982.SOAP_WS2.ws;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.danielpm1982.SOAP_WS2.dto.Patient;
import com.danielpm1982.SOAP_WS2.dto.Professional;

@WebService(name="PersonManager")
public interface PersonManagerInterface{
	@WebMethod
	public Patient getPatientById(long patientId);
	@WebMethod
	public Professional getProfessionalById(long professionalId);
	@WebMethod
	public List<Patient> getPatientAll();
	@WebMethod
	public List<Professional> getProfessionalAll();
}
