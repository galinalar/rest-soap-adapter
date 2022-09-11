package ru.adapter.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import jaxb2.*;

/**
 * SOAP requests.
 */
public class SoapRequest extends WebServiceGatewaySupport {


    private static final String WSDL_URI = "http://www.dneonline.com/calculator.asmx";
    private static final String ADD_URI = "http://tempuri.org/Add";
    private static final String DIVIDE_URI = "http://tempuri.org/Divide";
    private static final String MULTIPLY_URI = "http://tempuri.org/Multiply";
    private static final String SUBTRACT_URI = "http://tempuri.org/Subtract";


    public AddResponse add(Add request) {
        return (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WSDL_URI,
                        request,
                        new SoapActionCallback(ADD_URI)
                );
    }

    public DivideResponse divide(Divide request) {
        return (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WSDL_URI,
                        request,
                        new SoapActionCallback(DIVIDE_URI)
                );
    }

    public MultiplyResponse multiply(Multiply request) {
        return (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WSDL_URI,
                        request,
                        new SoapActionCallback(MULTIPLY_URI)
                );
    }

    public SubtractResponse subtract(Subtract request) {
        return (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WSDL_URI,
                        request,
                        new SoapActionCallback(SUBTRACT_URI)
                );
    }
}
