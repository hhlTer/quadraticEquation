package quadratic.controller.controllerservice;



public enum  ValidationResult{
    A_VALUE_IS_ZERO("Value 'A' cannot be a zero or empty"),
    NOT_VALID_VALUE("You enter the not valid value. \nValues must be include only numbers, and can be separated by dot.\n For example: 2; 43.2; -0.35"),
    UNKNOWN_ERROR("Unknown error. Please reenter input variables.\nValues must be include only numbers, and can be separated by dot.\n For example: 2; 43.2; -0.35"),
    NEGATIVE_DISCRIMINANT("Equation cannot be a executing. Discriminant calculating is smallest than zero"),
    OK("Ok");

    private String description;

    ValidationResult(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}