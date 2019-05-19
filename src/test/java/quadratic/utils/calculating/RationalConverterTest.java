package quadratic.utils.calculating;

//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import quadratic.model.representanion.RationalFraction;

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

    private RationalFraction rationalFraction;
    private final double TESTED_VALUE = -0.6;

    @Before
    public void doBefore(){
        rationalFraction = new RationalFraction();
        rationalFraction.setWhole(0);
        rationalFraction.setNumerator(-3);
        rationalFraction.setDenominator(5);
    }

    @Test
    public void convertToRational() {
        RationalFraction tested = RationalConverter.convertToRational(TESTED_VALUE);
        assertThat(rationalFraction, samePropertyValuesAs(tested));
    }

    @Test
    public void convertToDouble() {
        double expected = RationalConverter.convertToDouble(rationalFraction);
        assertEquals(expected, TESTED_VALUE, 0.0000001);
    }
}
