package quadratic.controller.controllerservice;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.ParseException;

@Component
public class Validation {

    public ValidationResult validateValues(String valueA, String valueB, String valueC){
        DecimalFormat df = new DecimalFormat();
        double a, b, c;
        try {
            a = df.parse(valueA).doubleValue();
            b = df.parse(valueB).doubleValue();
            c = df.parse(valueC).doubleValue();
        } catch (ParseException e){
            return ValidationResult.NOT_VALID_VALUE;
        }

        if (a==0){
            return ValidationResult.A_VALUE_IS_ZERO;
        }

        return ValidationResult.OK;
    }

}
