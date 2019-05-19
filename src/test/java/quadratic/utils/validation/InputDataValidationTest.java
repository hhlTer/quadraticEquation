package quadratic.utils.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class InputDataValidationTest {

    private String valueA, valueB, valueC;
    private ValidationResult validationResult;

    public InputDataValidationTest(String initValueA,
                                   String initValueB,
                                   String initValueC,
                                   ValidationResult initValidationResult) {
        valueA = initValueA;
        valueB = initValueB;
        valueC = initValueC;
        validationResult = initValidationResult;
    }

    @Parameterized.Parameters
    public static Collection testCollection(){
        return Arrays.asList(new Object[][]{
                {"0", "0", "0", ValidationResult.A_VALUE_IS_ZERO},
                {"1-3", "0", "0", ValidationResult.NOT_VALID_VALUE},
                {"abs", "0", "0", ValidationResult.NOT_VALID_VALUE},
                {"0", "abc", "0", ValidationResult.NOT_VALID_VALUE},
                {"0", "0", "abc", ValidationResult.NOT_VALID_VALUE},
                {"", "0", "0", ValidationResult.EMPTY_FIELDS},
                {"", "0", "0", ValidationResult.EMPTY_FIELDS},
                {"0", "", "0", ValidationResult.EMPTY_FIELDS},
                {"0", "0", "", ValidationResult.EMPTY_FIELDS},
                {"0", "0", "0.9.3", ValidationResult.NOT_VALID_VALUE},
                {"1", ".1", "0", ValidationResult.NOT_VALID_VALUE},
                {"1", "-0", "-0.6", ValidationResult.OK}
        });
    }

    private InputDataValidation dataValidation;

    @Before
    public void doBefore(){
        dataValidation = new InputDataValidation();
    }

    @Test
    public void testValidation(){

        ValidationResult testResult = dataValidation.validateValues(valueA, valueB, valueC);
        assertEquals(validationResult, testResult);
    }
}
