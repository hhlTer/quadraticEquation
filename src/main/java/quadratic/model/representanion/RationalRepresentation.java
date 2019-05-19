package quadratic.model.representanion;

import quadratic.model.domain.QuadraticEquationData;
import quadratic.utils.calculating.RationalConverter;

/**
 * POJO class that stores quadratic equation result in rational
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
}
