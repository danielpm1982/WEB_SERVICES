package com.danielpm1982.SOAP_WS5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SOAP_WS5 {
	public static void main(String[] args) {
		SpringApplication.run(SOAP_WS5.class, args);
	}
}

/*
This project exemplifies SOAPHandlers, using a very simple SOAP WebService.
SOAPHandlers are like servlet filters, that will execute their methods on the incoming (before processing)
and on the outcoming of XML messages on the Provider side of the WebService.
On these handler methods, any logics, based on the Header or Body elements of the XML message can be designed,
separated from the main logics of the EndPoint PortType class.
In this example, using a bottom-up approach, the PortType (HelloWorldWSImpl) simply receives the name of a
user and returns a String message with it. The main logics is let with the handler, which reads the SOAPElements
of the header of each incoming SOAP XML Message and prints the elementLocalName and value at the console.
For testing, use a SoapUI project, as no Consumer client server has been implemented for this project.
For the WSDL, use the dynamically generated wsdl, created by CXF when this project is put to run... 
available at http://localhost:8080/SOAP_WS5/api as http://localhost:8080/SOAP_WS5/api/HelloWorldService?wsdl .
For the XML SOAP XML message, at the SoapUI, use, for instance, the XML request below:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.SOAP_WS5.danielpm1982.com/">
   <soapenv:Header>
   	<Domain>danielpm1982.com</Domain>
   	<Creator>danielpm1982</Creator>
   	<Email>danielpm1982.com@domainsbyproxy.com</Email>
   </soapenv:Header>
   <soapenv:Body>
      <ws:hello>
         <!--Optional:-->
         <userName>danielpm1982.com</userName>
      </ws:hello>
   </soapenv:Body>
</soapenv:Envelope>

Then, check out at the console the output of the incoming XML message headers (Domain, Creator and Email)
and their values... which could have been also sent to the PortType class in order to be shown at the XML
response message of that SOAP WebService, or used in any other way.

Fault handling has also been demonstrated here, see the PortType class (HelloWorldWSImpl.class) comments.
*/
