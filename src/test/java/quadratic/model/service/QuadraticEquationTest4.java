package quadratic.model.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;
import quadratic.model.repository.QuadraticEquationRepository;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class QuadraticEquationTest4 {

    @InjectMocks
    private QuadraticEquationService quadraticEquationService;

    @Mock
    private QuadraticEquationRepository quadraticEquationRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadTest(){
        PK localPK = new PK();
        localPK.setValueC(1);
        localPK.setValueB(1);
        localPK.setValueA(1);

        QuadraticEquationData expected = new QuadraticEquationData();
        expected.setId(localPK);
        expected.setRoot1(10);
        expected.setRoot2(11);
        expected.setDiscriminant(100);

        when(quadraticEquationRepository.getQuadraticDataById(localPK)).thenReturn(expected);

        QuadraticEquationData test = quadraticEquationService.getQuadraticDataById(localPK);
        assertThat(test, samePropertyValuesAs(expected));

    }

}
