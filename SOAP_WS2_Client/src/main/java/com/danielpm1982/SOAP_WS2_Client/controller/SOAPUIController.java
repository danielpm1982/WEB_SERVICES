package com.danielpm1982.SOAP_WS2_Client.controller;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.danielpm1982.SOAP_WS2_Client.helper.AppointmentManagerHelper;
import com.danielpm1982.SOAP_WS2_Client.helper.PersonManagerHelper;
import com.danielpm1982.soap_ws2.ws.Appointment;
import com.danielpm1982.soap_ws2.ws.Patient;
import com.danielpm1982.soap_ws2.ws.Professional;

@Controller
@RequestMapping("/controller")
public class SOAPUIController {
	@RequestMapping("/soapOps")
	public String showSOAPOperations() {
		return "soapOps";
	}
	@RequestMapping("/getPatientAll")
	public String getPatientAll(Model model) {
		List<Patient> patientList = PersonManagerHelper.getAllPatients();
		model.addAttribute("patientList", patientList);
		return "patientResult";
	}
	@RequestMapping("/getPatient")
	public String getPatient(Model model, @RequestParam("patientId") long patientId) {
		Patient patient = PersonManagerHelper.getPatientById(patientId);
		model.addAttribute("patientList", Arrays.asList(patient));
		return "patientResult";
	}
	@RequestMapping("/getProfessionalAll")
	public String getProfessionalAll(Model model) {
		List<Professional> professionalList = PersonManagerHelper.getAllProfessionals();
		model.addAttribute("professionalList", professionalList);
		return "professionalResult";
	}
	@RequestMapping("/getProfessional")
	public String getProfessional(Model model, @RequestParam("professionalId") long professionalId) {
		Professional professional = PersonManagerHelper.getProfessionalById(professionalId);
		model.addAttribute("professionalList", Arrays.asList(professional));
		return "professionalResult";
	}
	@RequestMapping("/getAppointmentAll")
	public String getAppointmentAll(Model model) {
		List<Appointment> appointmentList = AppointmentManagerHelper.getAllAppointments();
		Map<Long, String> appointmentLocalizedDateTimeStringMap = new HashMap<>();
		appointmentList.forEach(x->appointmentLocalizedDateTimeStringMap.put(x.getAppointmentId().longValue(), AppointmentManagerHelper.getLocalizedDateTimeString(x.getAppointmentLocalDateTimeString())));
		List<Patient> patientList = PersonManagerHelper.getAllPatients();
		Map<Long, Patient> patientMap = new HashMap<>();
		patientList.forEach(x->patientMap.put(x.getPatientId().longValue(), x));
		List<Professional> professionalList = PersonManagerHelper.getAllProfessionals();
		Map<Long, Professional> professionalMap = new HashMap<>();
		professionalList.forEach(x->professionalMap.put(x.getProfessionalId().longValue(), x));
		model.addAttribute("appointmentList", appointmentList);
		model.addAttribute("patientMap", patientMap);
		model.addAttribute("professionalMap", professionalMap);
		model.addAttribute("appointmentLocalizedDateTimeStringMap", appointmentLocalizedDateTimeStringMap);
		return "appointmentResult";
	}
	@RequestMapping("/getAppointment")
	public String getAppointment(Model model, @RequestParam("appointmentId") long appointmentId) {
		Appointment appointment = AppointmentManagerHelper.getAppointmentById(appointmentId);
		Map<Long, String> appointmentLocalizedDateTimeStringMap = new HashMap<>();
		Arrays.asList(appointment).forEach(x->appointmentLocalizedDateTimeStringMap.put(x.getAppointmentId().longValue(), AppointmentManagerHelper.getLocalizedDateTimeString(x.getAppointmentLocalDateTimeString())));
		List<Patient> patientList = PersonManagerHelper.getAllPatients();
		Map<Long, Patient> patientMap = new HashMap<>();
		patientList.forEach(x->patientMap.put(x.getPatientId().longValue(), x));
		List<Professional> professionalList = PersonManagerHelper.getAllProfessionals();
		Map<Long, Professional> professionalMap = new HashMap<>();
		professionalList.forEach(x->professionalMap.put(x.getProfessionalId().longValue(), x));
		model.addAttribute("appointmentList", Arrays.asList(appointment));
		model.addAttribute("patientMap", patientMap);
		model.addAttribute("professionalMap", professionalMap);
		model.addAttribute("appointmentLocalizedDateTimeStringMap", appointmentLocalizedDateTimeStringMap);
		return "appointmentResult";
	}
	@RequestMapping("/createAppointmentSamples")
	public String createAppointmentSamples(Model model) {
		AppointmentManagerHelper.createAppointmentSample1();
		AppointmentManagerHelper.createAppointmentSample2();
		AppointmentManagerHelper.createAppointmentSample3();
		return "redirect:getAppointmentAll";
	}
}
