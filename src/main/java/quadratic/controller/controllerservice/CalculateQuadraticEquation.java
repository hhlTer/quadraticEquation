package quadratic.controller.controllerservice;

import org.springframework.stereotype.Component;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;

import java.util.TreeMap;

@Component
public class CalculateQuadraticEquation {

    public QuadraticDataMerged calculateEquation(double valueA, double valueB, double valueC) throws DiscriminantException {
        double discriminant = calculateDiscriminant(valueA, valueB, valueC);
        if (discriminant < 0){
            throw new DiscriminantException();
        }

        double r1 = 0, r2 = 0;

        if (discriminant == 0){
            r1 = r2 = -valueB / (2 * valueA);
        }

        if (discriminant > 0) {
            r1 = (-valueB + Math.pow(discriminant, 0.5)) / (2 * valueA);
            r2 = (-valueB - Math.pow(discriminant, 0.5)) / (2 * valueA);
        }

        PK pk = new PK(valueA, valueB, valueC);
        QuadraticDataMerged qdm = new QuadraticDataMerged();
        qdm.setId(pk);
        qdm.setValueA(valueA);
        qdm.setValueB(valueB);
        qdm.setValueC(valueB);
        qdm.setDiscriminant(discriminant);
        qdm.setRoot1(r1);
        qdm.setRoot2(r2);

        return qdm;
    }


    private double calculateDiscriminant(double valueA, double valueB, double valueC) {
        double discriminant = valueB * valueB - 4 * valueA * valueC;
        return discriminant;
    }
}
