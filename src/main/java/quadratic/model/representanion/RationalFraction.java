package quadratic.model.representanion;

public class RationalFraction {

    private int whole;
    private int numerator;
    private int denominator;

    public int getWhole() {
        return whole;
    }

    public void setWhole(int whole) {
        this.whole = whole;
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double getDoubleValue() {
        return whole+(double)numerator/denominator;
    }
}
