package quadratic.model.representanion;

/**
 * POJO class, that stores rational numbers
 */
public class RationalFraction {

    private boolean isPositive = true;
    private int whole;
    private int numerator;
    private int denominator;

    public int getWhole() {
        return whole;
    }

    public void setWhole(int whole) {
        this.whole = normalizeValue(whole);
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = normalizeValue(numerator);
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = normalizeValue(denominator);
    }

    public void setPositive(boolean initPositive) {
        isPositive = initPositive;
    }

    public boolean isPositive() {
        return isPositive;
    }

    private int normalizeValue(int v){
        if (v < 0){
            isPositive = false;
            v *= -1;
        }
        return v;
    }

    @Override
    public String toString() {
        return whole + " " + numerator + "/" + denominator;
    }
}
