package quadratic.utils.calculating;

import org.springframework.stereotype.Component;
import quadratic.utils.exceptions.DiscriminantException;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;

@Component
public class CalculateQuadraticEquation {

    public QuadraticEquationData calculateEquation(double valueA, double valueB, double valueC) throws DiscriminantException {
        double discriminant = calculateDiscriminant(valueA, valueB, valueC);
        if (discriminant < 0){
            throw new DiscriminantException();
        }

        double r1 = 0, r2 = 0;

        if (discriminant == 0){
            r1 = r2 = -valueB / (2 * valueA);
        }

        if (discriminant > 0) {
            r1 = (-valueB - Math.pow(discriminant, 0.5)) / (2 * valueA);
            r2 = (-valueB + Math.pow(discriminant, 0.5)) / (2 * valueA);
        }

        r1 = normalizeRoot(r1);
        r2 = normalizeRoot(r2);

        PK pk = new PK(valueA, valueB, valueC);
        QuadraticEquationData qed = new QuadraticEquationData();
        qed.setId(pk);
        qed.setValueA(valueA);
        qed.setValueB(valueB);
        qed.setValueC(valueC);
        qed.setDiscriminant(discriminant);
        qed.setRoot1(r1);
        qed.setRoot2(r2);

        return qed;
    }

    private double normalizeRoot(double r) {
        return r == -0.0 ? 0.0 : r;
    }

    private double calculateDiscriminant(double valueA, double valueB, double valueC) {
        double discriminant = valueB * valueB - 4 * valueA * valueC;
        return discriminant;
    }
}
