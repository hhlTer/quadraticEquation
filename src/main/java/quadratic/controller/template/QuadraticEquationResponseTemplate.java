package quadratic.controller.template;

import quadratic.model.domain.QuadraticEquationData;
import quadratic.utils.validation.ValidationResult;

public class QuadraticEquationResponseTemplate {

    private QuadraticEquationData equationData;
    private ValidationResult validationResult;
    private String defaultMessage;
    private boolean rational;

    public QuadraticEquationData getEquationData() {
        return equationData;
    }

    public void setEquationData(QuadraticEquationData initEquationData) {
        equationData = initEquationData;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult initValidationResult) {
        validationResult = initValidationResult;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String initDefaultMessage) {
        defaultMessage = initDefaultMessage;
    }

    public boolean isRational() {
        return rational;
    }

    public void setRational(boolean initRational) {
        rational = initRational;
    }
}
