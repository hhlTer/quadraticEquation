package quadratic.controller.uicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import quadratic.controller.template.QuadraticEquationResponseTemplate;
import quadratic.utils.calculating.CalculateQuadraticEquation;
import quadratic.utils.exceptions.DiscriminantException;
import quadratic.utils.validation.InputDataValidation;
import quadratic.utils.validation.ValidationResult;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;
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

    @RequestMapping(value = "/calculate", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody QuadraticEquationResponseTemplate getValuesAndSaveIntoDatabase(
            @RequestParam String valueA,
            @RequestParam String valueB,
            @RequestParam String valueC,
            @RequestParam(required = false, defaultValue = "") String isRational
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
        if (qe.getDiscriminant() < 0){
            return responseFormat(ValidationResult.NEGATIVE_DISCRIMINANT);
        }

        QuadraticEquationResponseTemplate qTemplate = new QuadraticEquationResponseTemplate();
        qTemplate.setValidationResult(ValidationResult.OK);
        qTemplate.setEquationData(qe);
        qTemplate.setRational(isRational.equals("on"));

        return qTemplate;
    }

    private QuadraticEquationResponseTemplate responseFormat(ValidationResult initValidationResult) {
        QuadraticEquationResponseTemplate result = new QuadraticEquationResponseTemplate();
        result.setValidationResult(initValidationResult);
        result.setDefaultMessage(initValidationResult.toString());
        return result;
    }

}
