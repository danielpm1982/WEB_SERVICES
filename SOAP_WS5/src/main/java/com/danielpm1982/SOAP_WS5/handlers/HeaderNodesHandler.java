package com.danielpm1982.SOAP_WS5.handlers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HeaderNodesHandler implements SOAPHandler<SOAPMessageContext>{
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		if(!(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){ //if the method is not on the response, but on the request, treat the headers and show their content to the user. In this example, only request xml messages will be treated, although the method is called twice, in both cases (as getHeaders(), also is).
			System.out.println("At request handleMessage method at "+this.getClass().getSimpleName());
			SOAPMessage soapMessage = context.getMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			try {
				SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
				SOAPHeader soapHeader = soapEnvelope.getHeader();
				Iterator<?> childElements = soapHeader.getChildElements();
				List<SOAPElement> childSOAPElementList = new ArrayList<>(); //list for storing and later showing header childElements that are of SOAPElementType only. Node type could also be used as well.
				childElements.forEachRemaining(x->{
					if(x instanceof SOAPElement) {
						SOAPElement soapElement = (SOAPElement)x;
						childSOAPElementList.add(soapElement); //adding to the list only the childElements that are of SOPAElementType (discarding text types).
					}
				});
				if(!childSOAPElementList.isEmpty()) {
					childSOAPElementList.forEach(x->System.out.println("*****"+x.getLocalName()+": "+x.getValue()+"*****"));
				} else {
					System.out.println("No SOAP message envelop header childSOAPElements exist!");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			System.out.println("Leaving request handleMessage method at "+this.getClass().getSimpleName());
		} else { //if  the method is on the response, just show some String messages.
			System.out.println("At response handleMessage method at "+this.getClass().getSimpleName());
			System.out.println("Leaving response handleMessage method at "+this.getClass().getSimpleName());
		}
		return true; //if false is returned, the EndPoint, with the PortType object to be executed, is not called.
	}
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("At handleFault method at "+this.getClass().getSimpleName());
		System.out.println("Leaving handleFault method at "+this.getClass().getSimpleName());
		return false;
	}
	@Override
	public void close(MessageContext context) {
		System.out.println("At close method at "+this.getClass().getSimpleName());
		System.out.println("Leaving close method at "+this.getClass().getSimpleName());
	}
	@Override
	public Set<QName> getHeaders() {
		System.out.println("At getHeaders method at "+this.getClass().getSimpleName());
		System.out.println("Leaving getHeaders method at "+this.getClass().getSimpleName());
		return null;
	}
}

/*
This handler handles the request XML messages before the EndPoint PortType object (business logic) is called.  
It simply gets the SOAPMessageContext SOAPMessage SOAPPart SOAPEnvelop SOAPHeader ChildSOAPElements and show them with their values to the user.
*/
