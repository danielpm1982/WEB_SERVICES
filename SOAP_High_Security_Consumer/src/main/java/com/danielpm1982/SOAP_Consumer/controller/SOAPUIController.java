package com.danielpm1982.SOAP_Consumer.controller;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danielpm1982.SOAP_Consumer.model.AvailableCustomersManager;
import com.danielpm1982.SOAP_Consumer.model.AvailableProductsManager;
import com.danielpm1982.SOAP_Consumer.model.ProductRequest;
import com.danielpm1982.SOAP_Consumer.helper.CustomerOrdersHelper;
import com.danielpm1982.SOAP_Consumer.helper.CustomersConfigureHelper;
import com.danielpm1982.SOAP_Consumer.helper.ProductsConfigureHelper;
import com.danielpm1982.customerorders.Order;
import com.danielpm1982.customerorders.Product;

@Controller
@RequestMapping("/controller")
public class SOAPUIController {
	@RequestMapping("/soapOps")
	public String showSOAPOperations() {
		return "soapOps";
	}
	@RequestMapping("/showOrdersViewForm")
	public String showOrdersViewForm(Model model) {
		//instantiates the productRequest modelAttribute for new input values from the view form 
		model.addAttribute("productRequest", new ProductRequest());
		return "ordersViewForm";
	}
	@RequestMapping("/showOrdersViewFormResult")
	public String showOrdersViewFormResult(@ModelAttribute("productRequest") ProductRequest productRequest, Model model) {
		//CustomerOrdersHelper gets all Orders for that customerId, stored at the Provider, for showing at the view
		List<Order> customerOrderList = CustomerOrdersHelper.getOrders(Integer.valueOf(productRequest.getCustomerId()));
		model.addAttribute("customerOrderList", customerOrderList);
		model.addAttribute("customerId", productRequest.getCustomerId());
		return "customerOrders";
	}
	@RequestMapping("/showProductForm")
	public String showProductForm(Model model) {
		//instantiates the productRequest modelAttribute for new input values from the view form
		model.addAttribute("productRequest", new ProductRequest());
		//ProductsConfigureHelper gets all Products available from the Provider and sets them at a static Products list at the AvailableProductsManager, then retrieving to the view selection
		ProductsConfigureHelper.configureProducts();
		model.addAttribute("availableProductsList", AvailableProductsManager.getAvailableProductsList());
		//CustomersConfigureHelper gets all Customers available from the Provider and sets them at a static Customers list at the AvailableCustomerManager, then retrieving to the view selection
		CustomersConfigureHelper.configureCustomers();
		model.addAttribute("availableCustomersList", AvailableCustomersManager.getAvailableCustomersList());
		return "productForm";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/showProductFormResult")
	public String showProductFormResult(@ModelAttribute("productRequest") ProductRequest productRequest, HttpServletRequest request, Model model) {
		//gets the last (from the session) and current (from the modelAttribute) customId for comparison
		String lastCustomerId = (String)request.getSession().getAttribute("customerId");
		String currentCustomerId = productRequest.getCustomerId();
		List<Product> allProductsRequested;
		if(lastCustomerId!=null) {
			if(lastCustomerId.compareTo(currentCustomerId)==0) {
				//if the customerId is the same of the one at the last operation, retrieve the common allProductsRequested list from the session for adding new Product
				allProductsRequested = (List<Product>)request.getSession().getAttribute("allProductsRequested");
			} else {
				//if the last customerId exists but is different, reset the allProductsRequested list at the session
				allProductsRequested = null;
			}
		} else {
			//if the last customerId doesn't even exist, reset any eventual existent allProductsRequested list at the session
			allProductsRequested = null;
		}
		if(allProductsRequested==null) {
			//instantiate the null list for adding new Products
			allProductsRequested = new ArrayList<>();
		}
		//AvailableProductsManager fetches its local availableProductsList (already populated from the Provider) for the productId to retrieve the requesting Product
		Product product = AvailableProductsManager.getProductForId(productRequest.getProductId());
		//the quantity of the Product (by default, equals 0) is set to the quantity the customer desires... Product id and description are preserved as at the Provider
		product.setQuantity(new BigInteger(productRequest.getQuantity()));
		//the requesting Product is added to the allProductsRequested list of that customerId, at the session 
		allProductsRequested.add(product);
		//both allProductsRequested and current customerId are added as attributes to the session, overriding any previous existing ones... and saved at that customerId session scope 
		request.getSession().setAttribute("allProductsRequested", allProductsRequested);
		request.getSession().setAttribute("customerId", currentCustomerId);
		//current requesting Product is sent, as the lastProductRequested, to the view - request scoped (Model), then discarded (no need to save that to the session)  
		model.addAttribute("lastProductRequested", product);
		return "productFormResult";
	}
	@RequestMapping("/showProductFormResultUpdated")
	public String showProductFormResultUpdated(HttpServletRequest request, Model model) {
		//when the "Clear all requested Products" button is clicked at the view, clears (sets to null) the allProductsRequested list for that customerId session
		request.getSession().setAttribute("allProductsRequested", null);
		//and also clears the request-scope lastProductRequested for not showing any previous requested Product at the page 
		model.addAttribute("lastProductRequested", null);
		return "productFormResult";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/showOrderCreationResult")
	public String showOrderCreationResult(HttpServletRequest request, Model model) {
		//when the view "Confirm Order" button is clicked, gets the current customerId from the session, as well as the current allProductsRequested list for that customer 
		String customerId = (String) request.getSession().getAttribute("customerId");
		List<Product> allProductsRequested = (List<Product>)request.getSession().getAttribute("allProductsRequested");
		//if the Products list exists and has at least one requested Product, use the CustomerOrdersHelper to create and send an Order to the Provider  
		if(allProductsRequested!=null&&!allProductsRequested.isEmpty()) {
			Order order = CustomerOrdersHelper.createOrder(Integer.valueOf(customerId), allProductsRequested.toArray(new Product[0]));
			//saves the last Order sent at a request scope for showing at the view
			model.addAttribute("lastOrderCreated", order);
			//resets (sets null) the allProductsRequested list for that customerId at the session (if the Products selected were already sent at the last Order, they should be deleted from the session for not mistakenly send again on the next eventual Order
			request.getSession().setAttribute("allProductsRequested", null);
		}
		return "orderCreationResult";
	}
}
