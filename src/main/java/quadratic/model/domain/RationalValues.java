package quadratic.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Entity store accordance double values to rational values.
 * Stored only after point digits value
 */
public class RationalValues {

    @Id
    private int value;

    @Column(name = "numerator")
    private int numerator;

    @Column(name = "denominator")
    private int denominator;

    public int getValue() {
        return value;
    }

    public void setValue(int initValue) {
        value = initValue;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int initNumerator) {
        numerator = initNumerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int initDenominator) {
        denominator = initDenominator;
    }
}
