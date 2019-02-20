package quadratic.model.representanion;

import org.springframework.stereotype.Component;
import quadratic.model.domain.QuadraticDataMerged;
import quadratic.service.applicationservice.RationalConverter;


@Component
public class QuadraticDataRationalFractionRepresentation {

    private RationalFraction valueA;
    private RationalFraction valueB;
    private RationalFraction valueC;

    private RationalFraction discriminant;
    private RationalFraction root1;
    private RationalFraction root2;

    private QuadraticDataMerged quadraticData;

//    public QuadraticDataRationalFractionRepresentation(QuadraticData quadraticData){
//    }

    public void setQuadraticDataEntity(QuadraticDataMerged quadraticDataEntity){
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

    public QuadraticDataMerged getQuadraticData() {
        return quadraticData;
    }
}
