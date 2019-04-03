package com.danielpm1982.SOAP_WS2.dto;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Professional")
@XmlAccessorType(XmlAccessType.FIELD)
public class Professional {
	@XmlElement(name="professionalId", required=true)
	private BigInteger professionalId;
	@XmlElement(name="professionalName", required=true)
	private String professionalName;
	@XmlElement(name="professionalAddress", required=true)
	private String professionalAddress;
	@XmlElement(name="professionalEmail", required=true)
	private String professionalEmail;
	@XmlElement(name="professionalPhoneNo", required=true)
	private String professionalPhoneNo;
	@XmlElement(name="professionalProfession", required=true)
	private String professionalProfession;
	@XmlElement(name="professionalSpecialty", required=true)
	private String professionalSpecialty;
	@XmlElement(name="professionalRegistry", required=true)
	private String professionalRegistry;
	public Professional() {
	}
	public Professional(BigInteger professionalId, String professionalName, String professionalAddress, String professionalEmail, String professionalPhoneNo, String professionalProfession, String professionalSpecialty, String professionalRegistry) {
		this.professionalId = professionalId;
		this.professionalName = professionalName;
		this.professionalAddress = professionalAddress;
		this.professionalEmail = professionalEmail;
		this.professionalPhoneNo = professionalPhoneNo;
		this.professionalProfession = professionalProfession;
		this.professionalSpecialty = professionalSpecialty;
		this.professionalRegistry = professionalRegistry;
	}
	public BigInteger getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(BigInteger professionalId) {
		this.professionalId = professionalId;
	}
	public String getProfessionalName() {
		return professionalName;
	}
	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}
	public String getProfessionalAddress() {
		return professionalAddress;
	}
	public void setProfessionalAddress(String professionalAddress) {
		this.professionalAddress = professionalAddress;
	}
	public String getProfessionalEmail() {
		return professionalEmail;
	}
	public void setProfessionalEmail(String professionalEmail) {
		this.professionalEmail = professionalEmail;
	}
	public String getProfessionalPhoneNo() {
		return professionalPhoneNo;
	}
	public void setProfessionalPhoneNo(String professionalPhoneNo) {
		this.professionalPhoneNo = professionalPhoneNo;
	}
	public String getProfessionalProfession() {
		return professionalProfession;
	}
	public void setProfessionalProfession(String professionalProfession) {
		this.professionalProfession = professionalProfession;
	}
	public String getProfessionalSpecialty() {
		return professionalSpecialty;
	}
	public void setProfessionalSpecialty(String professionalSpecialty) {
		this.professionalSpecialty = professionalSpecialty;
	}
	public String getProfessionalRegistry() {
		return professionalRegistry;
	}
	public void setProfessionalRegistry(String professionalRegistry) {
		this.professionalRegistry = professionalRegistry;
	}
	@Override
	public String toString() {
		return "id: "+professionalId+" name: "+professionalName+" address: "+professionalAddress+" email: "+professionalEmail+" phoneNo: "+professionalPhoneNo+" registry: "+professionalRegistry+" profession: "+professionalProfession+" specialty: "+professionalSpecialty;
	}
}
