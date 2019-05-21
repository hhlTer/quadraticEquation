package quadratic.model.representanion;

import quadratic.model.domain.QuadraticEquationData;
import quadratic.utils.calculating.RationalConverter;

/**
 * POJO class that stores quadratic equation result in rational format, use RationalFraction store class
 */
public class RationalRepresentation {

    private RationalFraction valueA;
    private RationalFraction valueB;
    private RationalFraction valueC;

    private RationalFraction discriminant;
    private RationalFraction root1;
    private RationalFraction root2;

    private QuadraticEquationData quadraticData;

    public void setQuadraticDataEntity(QuadraticEquationData quadraticDataEntity){
        this.quadraticData = quadraticDataEntity;
        this.valueA = RationalConverter.convertToRational(quadraticData.getValueA());
        this.valueB = RationalConverter.convertToRational(quadraticData.getValueB());
        this.valueC = RationalConverter.convertToRational(quadraticData.getValueC());
        this.discriminant = RationalConverter.convertToRational(quadraticData.getDiscriminant());
        this.root1 = RationalConverter.convertToRational(quadraticData.getRoot1());
        this.root2 = RationalConverter.convertToRational(quadraticData.getRoot2());
    }

    public RationalFraction getRationalValueA() {
        return valueA;
    }

    public RationalFraction getRationalValueB() {
        return valueB;
    }

    public RationalFraction getRationalValueC() {
        return valueC;
    }

    public RationalFraction getRationalDiscriminant() {
        return discriminant;
    }

    public RationalFraction getRationalRoot1() {
        return root1;
    }

    public RationalFraction getRationalRoot2() {
        return root2;
    }

    public QuadraticEquationData getQuadraticData() {
        return quadraticData;
    }

    /**
     * POJO class, that stores rational numbers
     */
    public static class RationalFraction {

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
}
