package quadratic.model.dao;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;

import java.util.List;

@Repository
public class QuadraticImplementationRepository implements QuadraticDAORepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addQuadraticData(QuadraticDataMerged quadraticData) {
        sessionFactory.getCurrentSession().save(quadraticData);
    }

    @Override
    public List<QuadraticDataMerged> getAllQuadraticData() {
        List quadraticDataMergeds = sessionFactory.getCurrentSession().createQuery("from QuadraticDataMerged")
                .list();
        return quadraticDataMergeds;
    }

    @Override
    public void removeQuadraticDataById(PK id) {

        QuadraticDataMerged quadraticData = getQuadraticDataById(id);
        if (quadraticData != null){
            sessionFactory.getCurrentSession().delete(quadraticData);
        }
    }

    @Override
    public QuadraticDataMerged getQuadraticDataById(PK id) {
        QuadraticDataMerged q = null;

        try {
            q = (QuadraticDataMerged) sessionFactory.getCurrentSession().load(QuadraticDataMerged.class, id);
        } catch (ObjectNotFoundException e ){
            return null;
        }
        return q;
    }

}
