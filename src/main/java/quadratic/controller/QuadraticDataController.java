package quadratic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import quadratic.controller.controllerservice.CalculateQuadraticEquation;
import quadratic.controller.controllerservice.DiscriminantException;
import quadratic.controller.controllerservice.Validation;
import quadratic.controller.controllerservice.ValidationResult;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;
import quadratic.model.representanion.QuadraticDataRationalFractionRepresentation;
import quadratic.model.representanion.RationalFraction;
import quadratic.service.implementation.QuadraticDatabaseService;

import java.util.List;

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

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String getValuesAndSaveIntoDatabase(
            Model model,
            @RequestParam String valueA,
            @RequestParam String valueB,
            @RequestParam String valueC
    ){

        System.out.println("=============================================");

        ValidationResult validationResult = validation.validateValues(valueA, valueB, valueC);
        if (validationResult != ValidationResult.OK){

        }

        double doubleValueA = Double.valueOf(valueA);
        double doubleValueB = Double.valueOf(valueB);
        double doubleValueC = Double.valueOf(valueC);

        List<QuadraticDataMerged> l = quadraticDatabaseService.getAllQuadraticData();

        PK quadraticDataEntityId = new PK(doubleValueA, doubleValueB, doubleValueC);
//        QuadraticDataMerged qdm = new QuadraticDataMerged();
//        qdm.setValueA(-4.0d);
//        qdm.setValueA(4.0d);
//        qdm.setValueA(3.0d);
//        qdm.setDiscriminant(43d);
//        qdm.setRoot2(4d);
//        qdm.setRoot1(3d);

        QuadraticDataMerged qdm = quadraticDatabaseService.getQuadraticDataById(quadraticDataEntityId);

        if (qdm == null){
            try {
                qdm = calculateQuadraticEquation.calculateEquation(doubleValueA, doubleValueB, doubleValueC);
                quadraticDatabaseService.addQuadraticData(qdm);
            } catch (DiscriminantException e) {
                e.printStackTrace();
            }
        }
        if (qdm.getDiscriminant() < 0){

        }

        calculateAndSetQuadraticDataRationalRepresentationByQuadraticData(qdm);

        ModelAndView modelAndView = new ModelAndView("showResult");

        modelAndView.addObject("test", "cla bla");
        modelAndView.addObject("rationalValueA", quadraticDataRationalFractionRepresentation.getRationalValueA());
        modelAndView.addObject("rationalValueB", quadraticDataRationalFractionRepresentation.getRationalValueB());
        modelAndView.addObject("rationalValueC", quadraticDataRationalFractionRepresentation.getRationalValueC());

        modelAndView.addObject("rationalDiscriminant", quadraticDataRationalFractionRepresentation.getRationalDiscriminant());
        modelAndView.addObject("rationalRoot1", quadraticDataRationalFractionRepresentation.getRationalRoot1());
        modelAndView.addObject("rationalRoot2", quadraticDataRationalFractionRepresentation.getRationalRoot2());








        model.addAttribute("test2", quadraticDataRationalFractionRepresentation.getRationalRoot1());

//        Variant 1:
//        1) create instance of class for calculating
//        2) handle the exception
//        3) turn instance to service layer for save to database
//        4) out result

//        Variant 2:
//        create class for calculating
//        lookInDataBase(a, b, c) ??
//        ifNoCalculating() -> calculate

        return "showResult";
    }

    private void calculateAndSetQuadraticDataRationalRepresentationByQuadraticData(QuadraticDataMerged qdm) {
        quadraticDataRationalFractionRepresentation.setQuadraticDataEntity(qdm);
    }

}
