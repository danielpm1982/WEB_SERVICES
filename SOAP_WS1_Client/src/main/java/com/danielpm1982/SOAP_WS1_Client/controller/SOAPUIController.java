package com.danielpm1982.SOAP_WS1_Client.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.danielpm1982.SOAP_WS1_Client.helper.CustomerOrdersWSClientHelper;
import com.danielpm1982.customerorders.Order;

@Controller
@RequestMapping("/controller")
public class SOAPUIController {
	@RequestMapping("/soapOps")
	public String showSOAPOperations() {
		return "soapOps";
	}
	@RequestMapping("/getCustomerOrders")
	public String getCustomerOrders(Model model, @RequestParam("customerId") int customerId) {
		List<Order> customerOrderList = CustomerOrdersWSClientHelper.getOrders(customerId);
		model.addAttribute("customerId", customerId);
		model.addAttribute("customerOrderList", customerOrderList);
		return "customerOrders";
	}
	@RequestMapping("/createSampleOrder1ForCustomer1")
	public String createSampleOrder1ForCustomer1(Model model) {
		Order addedOrder = CustomerOrdersWSClientHelper.createOrdersSample1();
		model.addAttribute("addedOrder", addedOrder);
		return "orderCreationResult";
	}
	@RequestMapping("/createSampleOrder2ForCustomer1")
	public String createSampleOrder2ForCustomer1(Model model) {
		Order addedOrder = CustomerOrdersWSClientHelper.createOrdersSample2();
		model.addAttribute("addedOrder", addedOrder);
		return "orderCreationResult";
	}
	@RequestMapping("/createSampleOrder3ForCustomer1")
	public String createSampleOrder3ForCustomer1(Model model) {
		Order addedOrder = CustomerOrdersWSClientHelper.createOrdersSample3();
		model.addAttribute("addedOrder", addedOrder);
		return "orderCreationResult";
	}
}
