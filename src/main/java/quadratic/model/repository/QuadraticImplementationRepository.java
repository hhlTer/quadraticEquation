package quadratic.model.repository;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;

@Repository
public class QuadraticImplementationRepository implements QuadraticDAORepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addQuadraticData(QuadraticDataMerged quadraticData) {
        sessionFactory.getCurrentSession().save(quadraticData);
    }

    @Override
    public QuadraticDataMerged getQuadraticDataById(PK id) {
        QuadraticDataMerged q;

        try {
            q = (QuadraticDataMerged) sessionFactory.getCurrentSession().load(QuadraticDataMerged.class, id);
        } catch (ObjectNotFoundException e ){
            return null;
        }
        return q;
    }

}
