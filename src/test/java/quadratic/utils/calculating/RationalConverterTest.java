package quadratic.utils.calculating;

//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import quadratic.model.representanion.RationalRepresentation;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.*;

/**
 * Test converting 1.6  to  1_3/5 and in the back way
 */
//@RunWith(Arquillian.class)
public class RationalConverterTest {
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(RationalConverter.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }

    private RationalRepresentation.RationalFraction expectedRationalFraction;
    private final double TESTED_VALUE = -0.6;

    @Before
    public void doBefore(){
        expectedRationalFraction = new RationalRepresentation.RationalFraction();
        expectedRationalFraction.setWhole(0);
        expectedRationalFraction.setNumerator(-3);
        expectedRationalFraction.setDenominator(5);
    }

    @Test
    public void convertToRational() {
        RationalRepresentation.RationalFraction tested = RationalConverter.convertToRational(TESTED_VALUE);
        assertThat(expectedRationalFraction, samePropertyValuesAs(tested));
    }

    @Test
    public void convertToDouble() {
        double expected = RationalConverter.convertToDouble(expectedRationalFraction);
        assertEquals(expected, TESTED_VALUE, 0.0000001);
    }
}
