package com.danielpm1982.SOAP_WS2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SOAP_WS2 {
	public static void main(String[] args) {
		SpringApplication.run(SOAP_WS2.class, args);
	}
}

/*
This project is similar to the top-down wsdl-first project at https://github.com/danielpm1982/WEB_SERVICES/tree/master/SOAP_WS1 .
One of its differences is the development process adopted, as it is now a bottom-up project evolved from a certain old legacy system without webServices before.
The Consumer side is pretty similar, including the development process, but the Provider side is different because no CXF plugin is needed, as the old
classes, that turn out to be the stubs in this project, are annotated manually by the programmer, with JAXB (DTO, entity classes) and JAX-WS (the controller 
classes - Person and Appointment Managers, in this case, or eventually a DAO, that exerts operations over the entity classes). The Endpoint is then published 
and the wsdl file is generated only dynamically... and then used as the wsdl for creating the Consumer side, as usual.
In the particular case of this project, although not needed, two Endpoints for two different webServices have been published, which use two different 
PortTypes (controller classes annotated with JAX-WS), and generates two different wsdl files from JAXB and JAX-WS, one for each service. The two wsdl are used 
then to generate all stubs for both webServices at the Consumer side, using the cxf plugin and api, and two different proxies are created, one for each 
webService and portType.
These are subsequently used at the helper classes that provide all services available to the web Controller class at the Consumer side, or to the main Console
testing class as well.
The functional requirement logics of this bottom-up SOAP project is basically a webService for getting Patients and Professionals info, and another for
creating and registering appointments between them, for a certain dateTime and place. Simulating a DB, at the PersonManager class there exist Patient and 
Professional lists, which are sampled created at the Constructor, and the Appointments are created at the Consumer side and set at the AppointmentManager 
class method from the respective proxy there.
For the rest, all is much like what had been done before at the SOAP_WS1 project.
For running and testing this SOAP_WS2 project, first run the main class at the Provider side (SOAP_WS2), and
then one of the main classes at the Consumer side (SOAP_WS2_Client). Attention to the different http ports
and context-paths.
*/
