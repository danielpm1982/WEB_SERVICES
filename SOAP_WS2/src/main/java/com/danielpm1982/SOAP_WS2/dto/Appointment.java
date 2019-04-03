package com.danielpm1982.SOAP_WS2.dto;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Appointment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Appointment {
	@XmlElement(name="appointmentId", required=true)
	private BigInteger appointmentId;
	@XmlElement(name="patientId", required=true)
	private BigInteger patientId;
	@XmlElement(name="professionalId", required=true)
	private BigInteger professionalId;
	@XmlElement(name="appointmentLocalDateTimeString", required=true)
	private String appointmentLocalDateTimeString;
	@XmlElement(name="appointmentAddress", required=true)
	private String appointmentAddress;
	@XmlElement(name="appointmentDetails", required=false)
	private String appointmentDetails;
	public Appointment() {
	}
	public Appointment(BigInteger appointmentId, BigInteger patientId, BigInteger professionalId, String appointmentLocalDateTimeString, String appointmentAddress, String appointmentDetails) {
		this.appointmentId=appointmentId;
		this.patientId=patientId;
		this.professionalId=professionalId;
		this.appointmentLocalDateTimeString = appointmentLocalDateTimeString;
		this.appointmentAddress = appointmentAddress;
		this.appointmentDetails = appointmentDetails;
	}
	public BigInteger getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
	}
	public BigInteger getPatientId() {
		return patientId;
	}
	public void setPatientId(BigInteger patientId) {
		this.patientId = patientId;
	}
	public BigInteger getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(BigInteger professionalId) {
		this.professionalId = professionalId;
	}
	public String getAppointmentLocalDateTimeString() {
		return appointmentLocalDateTimeString;
	}
	public void setAppointmentLocalDateTimeString(String appointmentLocalDateTimeString) {
		this.appointmentLocalDateTimeString = appointmentLocalDateTimeString;
	}
	public String getAppointmentAddress() {
		return appointmentAddress;
	}
	public void setAppointmentAddress(String appointmentAddress) {
		this.appointmentAddress = appointmentAddress;
	}
	public String getAppointmentDetails() {
		return appointmentDetails;
	}
	public void setAppointmentDetails(String appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}
	@Override
	public String toString() {
		return "id: "+appointmentId+" patientId: "+patientId+" professionalId: "+professionalId+" localDateTime: "+LocalDateTime.parse(appointmentLocalDateTimeString).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.FULL))+" address: "+appointmentAddress+" details: "+appointmentDetails;
	}
}
