package ru.adapter.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.adapter.model.RestRequest;

/**
 * Util class for validation.
 */
@Component
public class RequestValidator implements Validator {

    private static final String VALUE_INT = "Value must be integer";
    private static final String VALUE_NULL = "Value required";

    @Override
    public boolean supports(Class<?> clazz) {
        return RestRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RestRequest restRequest = (RestRequest) target;

        fieldValidate("first", restRequest.getFirst(), errors);
        fieldValidate("second", restRequest.getSecond(), errors);

    }

    private void fieldValidate(String fieldName, String fieldValue, Errors errors){
        if ((fieldValue == null) || fieldValue.equals("")) {
            errors.rejectValue(fieldName, VALUE_NULL);
        } else if (!isInteger(fieldValue)) {
            errors.rejectValue(fieldName, VALUE_INT);
        }
    }

    private boolean isInteger(String str)
    {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
}
