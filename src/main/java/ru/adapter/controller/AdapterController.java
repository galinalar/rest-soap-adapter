package ru.adapter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.adapter.exception.ValidationCastException;
import ru.adapter.model.RestRequest;
import ru.adapter.model.SoapResponse;
import ru.adapter.service.AdapterService;

import javax.validation.Valid;

/**
 * Adapter REST controller.
 */

@RestController
@RequestMapping("/api")
@Api(value = "AdapterController")
public class AdapterController {

    private AdapterService adapterService;

    private Validator validator;

    public AdapterController(AdapterService adapterService,
                             @Qualifier("requestValidator") Validator validator){
        this.adapterService = adapterService;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @PostMapping(path = "/add", produces = "application/json")
    @ApiOperation("Add two numbers")
    public SoapResponse addNumbers(@RequestBody @Valid RestRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ValidationCastException(bindingResult.getAllErrors());

        return new SoapResponse(
                adapterService.add(
                        Integer.valueOf(request.getFirst()),
                        Integer.valueOf(request.getSecond())
                )
        );
    }

    @PostMapping(path = "/divide", produces = "application/json")
    @ApiOperation("Divide the first number by the second")
    public SoapResponse divideNumbers(@RequestBody @Valid RestRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ValidationCastException(bindingResult.getAllErrors());

        return new SoapResponse(
                adapterService.divide(
                        Integer.valueOf(request.getFirst()),
                        Integer.valueOf(request.getSecond())
                )
        );
    }

    @PostMapping(path = "/multiply", produces = "application/json")
    @ApiOperation("Multiply two numbers")
    public SoapResponse multiplyNumbers(@RequestBody @Valid RestRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ValidationCastException(bindingResult.getAllErrors());

        return new SoapResponse(
                adapterService.multiply(
                        Integer.valueOf(request.getFirst()),
                        Integer.valueOf(request.getSecond())
                )
        );
    }

    @PostMapping(path = "/subtract", produces = "application/json")
    @ApiOperation("Subtract the second number from the first")
    public SoapResponse subtractNumbers(@RequestBody @Valid RestRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ValidationCastException(bindingResult.getAllErrors());

        return new SoapResponse(
                adapterService.subtract(
                        Integer.valueOf(request.getFirst()),
                        Integer.valueOf(request.getSecond())
                )
        );
    }
}
