package quadratic.model.template;

import quadratic.model.domain.QuadraticEquationData;
import quadratic.utils.validation.ValidationResult;

public class QuadraticEquationResponceTemplate {
    ValidationResult validationResult;
    QuadraticEquationData equationData;

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult initValidationResult) {
        validationResult = initValidationResult;
    }

    public QuadraticEquationData getEquationData() {
        return equationData;
    }

    public void setEquationData(QuadraticEquationData initEquationData) {
        equationData = initEquationData;
    }
}
