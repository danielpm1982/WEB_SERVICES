package com.danielpm1982.SOAP_WS2.dto;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {
	@XmlElement(name="patientId", required=true)
	private BigInteger patientId;
	@XmlElement(name="patientName", required=true)
	private String patientName;
	@XmlElement(name="patientAddress", required=true)
	private String patientAddress;
	@XmlElement(name="patientEmail", required=true)
	private String patientEmail;
	@XmlElement(name="patientPhoneNo", required=true)
	private String patientPhoneNo;
	public Patient() {
	}
	public Patient(BigInteger patientId, String patientName, String patientAddress, String patientEmail, String patientPhoneNo) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.patientEmail = patientEmail;
		this.patientPhoneNo = patientPhoneNo;
	}
	public BigInteger getPatientId() {
		return patientId;
	}
	public void setPatientId(BigInteger patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientPhoneNo() {
		return patientPhoneNo;
	}
	public void setPatientPhoneNo(String patientPhoneNo) {
		this.patientPhoneNo = patientPhoneNo;
	}
	@Override
	public String toString() {
		return "id: "+patientId+" name: "+patientName+" address: "+patientAddress+" email: "+patientEmail+" phoneNo: "+patientPhoneNo;
	}
}
