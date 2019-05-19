package quadratic.utils.validation;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

@Component
public class InputDataValidation {

    private final String pattern = "([-][0-9]+\\.[0-9]+)|[-][0-9]+|[0-9]+|([0-9]+\\.[0-9]+)";

    public ValidationResult validateValues(String valueA, String valueB, String valueC){
        double a;
        if (isEmptyAnyFields(valueA, valueB, valueC)){
            return ValidationResult.EMPTY_FIELDS;
        }

        if (!isAccordanceToPattern(valueA, valueB, valueC)){
            return ValidationResult.NOT_VALID_VALUE;
        }

        try {
            DecimalFormat df = new DecimalFormat();
            a = df.parse(valueA).doubleValue();
            df.parse(valueB).doubleValue();
            df.parse(valueC).doubleValue();
        } catch (ParseException e){
            return ValidationResult.NOT_VALID_VALUE;
        }

        if (a==0){
            return ValidationResult.A_VALUE_IS_ZERO;
        }

        return ValidationResult.OK;
    }

    private boolean isAccordanceToPattern(String ... values) {
        Pattern p = Pattern.compile(pattern);
        for (String s:
             values) {
            if (!p.matcher(s).matches()){
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyAnyFields(String valueA, String valueB, String valueC){
        return (valueA.length() < 1 || valueB.length() < 1 || valueC.length() < 1);
    }

}
