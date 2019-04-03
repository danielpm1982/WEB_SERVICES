package com.danielpm1982.SOAP_WS2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller")
public class SOAPUIController {
	@RequestMapping("/soapOps")
	public String showSOAPOperations() {
		return "soapOps";
	}
}
