package quadratic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import quadratic.service.implementation.QuadraticDataService;
import quadratic.service.interfaces.QuadraticDataInterfaceService;

@Controller()
public class QuadraticDataController {

    @Autowired
    private QuadraticDataInterfaceService quadraticDataInterfaceService;

    @RequestMapping("/")
    public String mainPage(){
        return "mainPage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView getValuesAndSaveIntoDatabase(
            @RequestParam double valueA,
            @RequestParam double valueB,
            @RequestParam double valueC
    ){
//        Variant 1:
//        1) create instance of class for calculating
//        2) handle the exception
//        3) turn instance to service layer for save to database
//        4) out result

//        Variant 2:
//        create class for calculating
//        lookInDataBase(a, b, c) ??
//        ifNoCalculating() -> calculate

        return null;
    }
}
