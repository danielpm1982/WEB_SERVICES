package com.danielpm1982.SOAP_Provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SOAP_Provider {
	public static void main(String[] args) {
		SpringApplication.run(SOAP_Provider.class, args);
	}
}

/*
This is a sample implementation of a top-down (WSDL-first) SOAP Web Service project, including the WS-Security Standard 
implementation from Apache WSS4J - configured to the current project - and the use of Apache CXF Framework for automatic 
management of JAX-B and JAX-WS Java APIs, in creating and managing the security of the SOAP messages, as for implementing
the PortType and publishing the Provider endpoint associated to it.

Regarding Security, all 4 issues have been tackled, that is: authorization (usernameToken), confidentiality (end-to-end 
encryption), integrity (hash signatures) and non-repudiation (timestamp).

One Provider Server and one Consumer Server have been implemented, although more than one Consumer Server could have been 
created for reaching the same Provider. 

In respect of the business requirements/logics and the Web Service flow:

1 - at the Consumer side, the final users (browser) can request the creation or retrieving of existing Orders of Products, 
stored at the Provider server, and not at the Consumer server - where the final clients requests are directed to.

2 - other than that, the Provider also turns available to the Consumer server the list of Customers and Products, created 
and maintained exclusively at the Provider server... so that the Consumer server can receive those lists and use them to 
show to the users (at the Product request page, for instance) when these are to create the Orders of Products to be sent, 
through the secured SOAP messages, to the Provider server.

3 - the main entities are:
3.1. Product: String id, String description, BigInteger quantity;
3.2. Order (of Products): BigInteger id, List<Product> product;
3.3. Customer: long customerId, String customerName;

4 - available Provider Products, which can be ordered by the Consumer server clients, are retrieved from the Provider with
their id and description. The final user simply inputs the quantity he desires, which the Consumer server sets to each
Product before generating the Order.

5 - available Provider Customers, which can be selected by the Consumer server clients, are retrieved from the Provider with
their customerId and customerName. The final user simply chooses which customer he desires, which the Consumer server sets 
to each Order before sending the message to the Provider.

6 - the Order is completed assembled at the Consumer server, with its id being the zonedDateTime instant in milliseconds and
the List of Products being created from the Products the Consumer server clients have added to each Order.

7 - at the CreateOrdersRequest object, the customerId and single Order are sent to the Provider, through a SOAP secured message.

8 - at the GetOrdersRequest object, a registered customerId is sent to the Provider, which responds with a GetOrdersResponse
object, containing the list of all Orders for that customerId at the Provider server storage. All messages secured, both ways.

9 - the Web User Interface at the Provider side (deployed at localhost port 8080) just shows the /api CXF path, showing the 
implemented web service WSDL and respective operations. This WSDL, that binds to the concrete implementation of the PortType class, 
is copied to the Consumer server, so that the Proxy Stubs can be generated at the Consumer side and it can get access to the 
implemented PortType operations at the Provider side, for sending and receiving the messages with all objects and data included.

Concerning the process of creation of the pairs of encryption/signature keys, as well as of the keyStore,
at each server (Provider and Consumer), please refer to the keytoolProcess.zip file at the resources/keyStore 
package of this project, where the command line sequence, used for this project, is described.

For more details take a look at the comments of the other classes of this project, specially at the config, helper and ws packages.

This Application has been created by Daniel Pinheiro, from danielpm1982.com , 
email: danielpm1982.com@domainsbyproxy.com . 
It can be used solely for studying purposes.
*/
