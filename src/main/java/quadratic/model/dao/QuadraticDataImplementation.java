package quadratic.model.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quadratic.model.domain.QuadraticData;

import java.util.List;

@Repository
public class QuadraticDataImplementation implements QuadraticDataDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addQuadraticData(QuadraticData quadraticData) {
        sessionFactory.getCurrentSession().save(quadraticData);
    }

    public List<QuadraticData> getAllQuadraticData() {
        return sessionFactory.getCurrentSession().createQuery("from QuadraticData")
                .list();
    }

    public void removeQuadraticDataById(long id) {

        QuadraticData quadraticData = getQuadraticDataById(id);
        if (quadraticData != null){
            sessionFactory.getCurrentSession().delete(quadraticData);
        }
    }

    public QuadraticData getQuadraticDataById(long id) {
        return (QuadraticData) sessionFactory.getCurrentSession().load(QuadraticData.class, id);
    }
}
