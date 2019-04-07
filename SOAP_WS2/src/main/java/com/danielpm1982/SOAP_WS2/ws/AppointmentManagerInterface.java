package com.danielpm1982.SOAP_WS2.ws;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import com.danielpm1982.SOAP_WS2.dto.Appointment;

@WebService(name="AppointmentManager")
public interface AppointmentManagerInterface {
	@WebMethod
	public @WebResult(name="GetAppointmentResult")Appointment getAppointmentById(@WebParam(name="AppointmentId")long appointmentId);
	@WebMethod
	public @WebResult(name="GetAppointmentAllResult")List<Appointment> getAppointmentAll();
	@WebMethod
	public @WebResult(name="CreateAppointmentResult")Appointment createAppointment(@WebParam(name="Appointment")Appointment appointment);
}
