package ru.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.adapter.service.SoapRequest;

/**
 * Configuration for SOAP.
 */

@Configuration
public class SOAPConfiguration {

    private static final String WSDL = "jaxb2";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(WSDL);
        return marshaller;
    }

    @Bean
    public SoapRequest soapRequest(Jaxb2Marshaller marshaller) {
        SoapRequest client = new SoapRequest();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
