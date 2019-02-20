package quadratic.model.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PK implements Serializable {

    private double valueA;
    private double valueB;
    private double valueC;



    public PK(double valueA, double valueB, double valueC) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.valueC = valueC;
    }

    public PK(){}

    public double getValueA() {
        return valueA;
    }

    public void setValueA(double valueA) {
        this.valueA = valueA;
    }

    public double getValueB() {
        return valueB;
    }

    public void setValueB(double valueB) {
        this.valueB = valueB;
    }

    public double getValueC() {
        return valueC;
    }

    public void setValueC(double valueC) {
        this.valueC = valueC;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof PK)) {
            return false;
        }

        PK pk = (PK) obj;

        // Compare the data members and return accordingly
        return Double.compare(valueA, pk.valueA) == 0
                && Double.compare(valueB, pk.valueB) == 0
                && Double.compare(valueC, pk.valueC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueA, valueB, valueC);
    }
}
