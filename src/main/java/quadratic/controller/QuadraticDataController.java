package quadratic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import quadratic.controller.controllerservice.calculating.CalculateQuadraticEquation;
import quadratic.controller.controllerservice.exceptions.DiscriminantException;
import quadratic.controller.controllerservice.validation.Validation;
import quadratic.controller.controllerservice.validation.ValidationResult;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;
import quadratic.controller.representanion.QuadraticDataRationalFractionRepresentation;
import quadratic.service.implementation.QuadraticDatabaseService;

@Controller()
public class QuadraticDataController {

    @Autowired
    private QuadraticDatabaseService quadraticDatabaseService;

    @Autowired
    private QuadraticDataRationalFractionRepresentation quadraticDataRationalFractionRepresentation;

    @Autowired
    private Validation validation;

    @Autowired
    private CalculateQuadraticEquation calculateQuadraticEquation;

    @RequestMapping("/")
    public ModelAndView mainPage(){
        return new ModelAndView("mainPage");
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    @ResponseBody
    public String getValuesAndSaveIntoDatabase(
            @RequestParam String valueA,
            @RequestParam String valueB,
            @RequestParam String valueC
    ){

        ValidationResult validationResult = validation.validateValues(valueA, valueB, valueC);
        if (validationResult != ValidationResult.OK){
            return validationResult.toString();
        }

        double doubleValueA = Double.valueOf(valueA);
        double doubleValueB = Double.valueOf(valueB);
        double doubleValueC = Double.valueOf(valueC);

        PK quadraticDataEntityId = new PK(doubleValueA, doubleValueB, doubleValueC);

        //Table entity. Return null if cortege not exist
        QuadraticDataMerged qdm = quadraticDatabaseService.getQuadraticDataById(quadraticDataEntityId);

        if (qdm == null){
            try {
                qdm = calculateQuadraticEquation.calculateEquation(doubleValueA, doubleValueB, doubleValueC); //calculate quadratic equation
                quadraticDatabaseService.addQuadraticData(qdm);//save cortege
            } catch (DiscriminantException e) {
                e.printStackTrace();
            }
        }
        if (qdm.getDiscriminant() < 0){
            return ValidationResult.NEGATIVE_DISCRIMINANT.toString();
        }

        //converting simple fraction to rational fraction
        calculateAndSetQuadraticDataRationalRepresentationByQuadraticData(qdm);
        String answer = generateAnswer();
        return answer;
    }

    private String generateAnswer() {

        StringBuilder sb = new StringBuilder();
        sb.append("Discriminant = ").append(quadraticDataRationalFractionRepresentation.getRationalDiscriminant().getDoubleValue())
                .append(" or in rational representation: ").append(quadraticDataRationalFractionRepresentation.getRationalDiscriminant())
                .append("\n")
                .append("Root1: ").append(quadraticDataRationalFractionRepresentation.getRationalRoot1().getDoubleValue())
                .append(" or in rational representation: ").append(quadraticDataRationalFractionRepresentation.getRationalRoot1())
                .append("\n")
                .append("Root2: ").append(quadraticDataRationalFractionRepresentation.getRationalRoot2().getDoubleValue())
                .append(" or in rational representation: ").append(quadraticDataRationalFractionRepresentation.getRationalRoot2());

        return sb.toString();
    }

    private void calculateAndSetQuadraticDataRationalRepresentationByQuadraticData(QuadraticDataMerged qdm) {
        quadraticDataRationalFractionRepresentation.setQuadraticDataEntity(qdm);
    }

}
