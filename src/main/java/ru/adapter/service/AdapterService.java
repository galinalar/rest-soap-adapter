package ru.adapter.service;

import jaxb2.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.adapter.exception.SoapResultException;
import ru.adapter.exception.ZeroException;

/**
 * Service for adapter.
 */
@Service
public class AdapterService {

    private static final Logger LOGGER = LogManager.getLogger(AdapterService.class);

    private static final String EMPTY_RESPONSE = "Empty response";
    private static final String ZERO = "Division by zero";

    private SoapRequest soapRequest;

    public AdapterService(SoapRequest soapRequest){
        this.soapRequest = soapRequest;
    }

    /**
     * Add two numbers.
     *
     * @param first first number
     * @param second second number
     * @return int result
     */
    @Cacheable("add")
    public int add(int first, int second) {
        LOGGER.info("getting add result: " + first+ "+"+ second);
        Add add = new Add();
        add.setIntA(first);
        add.setIntB(second);

        AddResponse response = soapRequest.add(add);

        if (response!=null) return response.getAddResult();
        else throw new SoapResultException(EMPTY_RESPONSE);
    }

    /**
     * Divide the first number by the second.
     *
     * @param first first number
     * @param second second number
     * @return int result
     */
    @Cacheable("divide")
    public int divide(int first, int second) {
        LOGGER.info("getting divide result: " + first+ "/"+ second);
        if (second==0) throw new ZeroException(ZERO);
        else {
            Divide divide = new Divide();
            divide.setIntA(first);
            divide.setIntB(second);

            DivideResponse response = soapRequest.divide(divide);

            if (response != null) return response.getDivideResult();
            else throw new SoapResultException(EMPTY_RESPONSE);
        }
    }

    /**
     * Multiply two numbers.
     *
     * @param first first number
     * @param second second number
     * @return int result
     */
    @Cacheable("multiply")
    public int multiply(int first, int second) {
        LOGGER.info("getting multiply result: " + first+ "*"+ second);
        Multiply multiply = new Multiply();
        multiply.setIntA(first);
        multiply.setIntB(second);

        MultiplyResponse response = soapRequest.multiply(multiply);

        if (response!=null) return response.getMultiplyResult();
        else throw new SoapResultException(EMPTY_RESPONSE);
    }

    /**
     * Subtract the second number from the first.
     *
     * @param first first number
     * @param second second number
     * @return int result
     */
    @Cacheable("subtract")
    public int subtract(int first, int second) {
        LOGGER.info("getting subtract result: " + first+ "-"+ second);
        Subtract subtract = new Subtract();
        subtract.setIntA(first);
        subtract.setIntB(second);

        SubtractResponse response = soapRequest.subtract(subtract);

        if (response!=null) return response.getSubtractResult();
        else throw new SoapResultException(EMPTY_RESPONSE);
    }

}
