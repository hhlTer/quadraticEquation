package quadratic.utils.calculating;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import quadratic.model.domain.QuadraticEquationData;
import quadratic.utils.exceptions.DiscriminantException;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculateQuadraticEquationTest {

    private double A, B, C, discriminant, root1, root2;
    private CalculateQuadraticEquation quadraticEquation;

    @Before
    public void doBefore(){
        quadraticEquation = new CalculateQuadraticEquation();
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {2, 5, -3, 49, -3, 0.5},
                {1, 0, 0, 0, 0, 0},
                {1, 1.5, 0.5, 0.25, -1, -0.5},
                {-2000, 5000, -0.0, 25000000, 2.5, 0}
        });
    }

    public CalculateQuadraticEquationTest(final double A,
                                          final double B,
                                          final double C,
                                          final double discriminant,
                                          final double root1,
                                          final double root2) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.discriminant = discriminant;
        this.root1 = root1;
        this.root2 = root2;
    }

    @Test
    public void calculateEquationTest() throws DiscriminantException {
        QuadraticEquationData qed = new QuadraticEquationData();
        qed.setValueA(A);
        qed.setValueB(B);
        qed.setValueC(C);
        qed.setDiscriminant(discriminant);
        qed.setRoot1(root1);
        qed.setRoot2(root2);

        QuadraticEquationData qdmResult = quadraticEquation.calculateEquation(A, B, C);

        assertThat(qed, samePropertyValuesAs(qdmResult));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwDiscriminantExceptionTest() throws DiscriminantException {
        expectedException.expect(DiscriminantException.class);
        quadraticEquation.calculateEquation(1, 1, 1);
    }
}

