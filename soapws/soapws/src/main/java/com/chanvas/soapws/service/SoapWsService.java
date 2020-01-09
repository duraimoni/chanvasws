package com.chanvas.soapws.service;

 

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.chanvas.soapws.model.InputString;
import com.chanvas.soapws.model.ObjectFactory;
import com.chanvas.soapws.model.OutputString;

 

@Endpoint
public class SoapWsService {

	private static final String NAMESPACE_URI = "http://chanvas.com";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InputString")
	@ResponsePayload
	public OutputString hello(@RequestPayload InputString request) {

		String outputString = "Hello " + request.getTest() + "!";
		ObjectFactory factory = new ObjectFactory();
		OutputString response = factory.createOutputString();
		response.setResult(outputString);

		return response;
	}
}
