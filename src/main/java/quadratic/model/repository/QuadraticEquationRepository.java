package quadratic.model.repository;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;

@Repository
public class QuadraticEquationRepository implements QuadraticDAORepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addQuadraticData(QuadraticEquationData quadraticData) {
        sessionFactory.getCurrentSession().save(quadraticData);
    }

    @Override
    public QuadraticEquationData getQuadraticDataById(PK id) {
        QuadraticEquationData q;

        try {
            q = (QuadraticEquationData) sessionFactory.getCurrentSession().load(QuadraticEquationData.class, id);
        } catch (ObjectNotFoundException e ){
            return null;
        }
        return q;
    }

}
