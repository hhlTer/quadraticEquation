package quadratic.controller.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import quadratic.controller.template.QuadraticEquationResponseTemplate;
import quadratic.model.representanion.RationalRepresentation;

@Controller
public class ReportController {

    private String root1, root2, discriminant;

    @RequestMapping(value = "/reportFormat", method = RequestMethod.POST)
    @ResponseBody
    public String reportFormat(
            @RequestBody QuadraticEquationResponseTemplate responseTemplate
            ){

        determineReportValues(responseTemplate);

        StringBuilder sb = new StringBuilder();
        sb.append("Root1: ").append(root1).append("\n")
                .append("Root2: ").append(root2).append("\n")
                .append("Discriminant: ").append(discriminant);

        return sb.toString();
    }

    private void determineReportValues(QuadraticEquationResponseTemplate responseTemplate) {
        if (responseTemplate.isRational()){
            RationalRepresentation rr = new RationalRepresentation();
            rr.setQuadraticDataEntity(responseTemplate.getEquationData());
            root1 = (rr.getRationalRoot1().isPositive() ? "" : "-") + rr.getRationalRoot1().toString();
            root2 = (rr.getRationalRoot2().isPositive() ? "" : "-") + rr.getRationalRoot2().toString();
            discriminant = (rr.getRationalDiscriminant().isPositive() ? "" : "-") +  rr.getRationalDiscriminant().toString();
        } else {
            root1 = String.valueOf(responseTemplate.getEquationData().getRoot1());
            root2 = String.valueOf(responseTemplate.getEquationData().getRoot2());
            discriminant = String.valueOf(responseTemplate.getEquationData().getDiscriminant());
        }
    }

}
