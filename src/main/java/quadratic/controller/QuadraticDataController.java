package quadratic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import quadratic.model.template.QuadraticEquationResponceTemplate;
import quadratic.utils.calculating.CalculateQuadraticEquation;
import quadratic.utils.exceptions.DiscriminantException;
import quadratic.utils.validation.InputDataValidation;
import quadratic.utils.validation.ValidationResult;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;
import quadratic.model.representanion.RationalRepresentation;
import quadratic.model.service.QuadraticDatabaseService;

@Controller
public class QuadraticDataController {

    @Autowired
    private QuadraticDatabaseService quadraticDatabaseService;

    @Autowired
    private InputDataValidation inputDataValidation;

    @Autowired
    private CalculateQuadraticEquation calculateQuadraticEquation;

    @RequestMapping("/")
    public ModelAndView mainPage(){
        return new ModelAndView("mainPage");
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    @ResponseBody
    public QuadraticEquationResponceTemplate getValuesAndSaveIntoDatabase(
            @RequestParam String valueA,
            @RequestParam String valueB,
            @RequestParam String valueC
    ){

        ValidationResult validationResult = inputDataValidation.validateValues(valueA, valueB, valueC);
        if (validationResult != ValidationResult.OK){
            return responseFormat(validationResult);
        }

        double doubleValueA = Double.valueOf(valueA);
        double doubleValueB = Double.valueOf(valueB);
        double doubleValueC = Double.valueOf(valueC);

        PK quadraticDataEntityId = new PK(doubleValueA, doubleValueB, doubleValueC);

        //Table entity. Return null if cortege not exist
        QuadraticEquationData qe = quadraticDatabaseService.getQuadraticDataById(quadraticDataEntityId);

        if (qe == null){
            try {
                qe = calculateQuadraticEquation.calculateEquation(doubleValueA, doubleValueB, doubleValueC); //calculate quadratic equation
                quadraticDatabaseService.save(qe);//save cortege
            } catch (DiscriminantException e) {
                return responseFormat(ValidationResult.NEGATIVE_DISCRIMINANT);
            }
        }
//        if (qe.getDiscriminant() < 0){
//            return ValidationResult.NEGATIVE_DISCRIMINANT.toString();
//        }

        QuadraticEquationResponceTemplate qTemplate = new QuadraticEquationResponceTemplate();
        qTemplate.setValidationResult(ValidationResult.OK);
        qTemplate.setEquationData(qe);
        return qTemplate;
    }

    private QuadraticEquationResponceTemplate responseFormat(ValidationResult initValidationResult) {
        QuadraticEquationResponceTemplate result = new QuadraticEquationResponceTemplate();
        result.setValidationResult(initValidationResult);
        return result;
    }

    private String generateAnswer(QuadraticEquationData qe) {

        RationalRepresentation rationalRepresentation = convertQuadraticEntityToRational(qe);

        StringBuilder sb = new StringBuilder();
        sb.append("Discriminant = ").append(qe.getDiscriminant())
                .append(" or in rational representation: ").append(rationalRepresentation.getRationalDiscriminant())
                .append("\n")
                .append("Root1: ").append(qe.getRoot1())
                .append(" or in rational representation: ").append(rationalRepresentation.getRationalRoot1())
                .append("\n")
                .append("Root2: ").append(qe.getRoot2())
                .append(" or in rational representation: ").append(rationalRepresentation.getRationalRoot2());

        return sb.toString();
    }

    private RationalRepresentation convertQuadraticEntityToRational(QuadraticEquationData qe) {
        RationalRepresentation rationalRepresentation = new RationalRepresentation();
        rationalRepresentation.setQuadraticDataEntity(qe);
        return rationalRepresentation;
    }

}
