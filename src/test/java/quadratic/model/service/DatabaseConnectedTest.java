package quadratic.model.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Before;
import org.junit.Test;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;

import java.rmi.server.ObjID;

public class DatabaseConnectedTest {

    private SessionFactory sessionFactory;
    private Session session = null;

    @Before
    public void setup(){
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.addAnnotatedClass(QuadraticEquationData.class);
        configuration.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQL5InnoDBDialect");
        configuration.setProperty("hibernate.connection.driver_class",
                "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url",
                "jdbc:mysql://localhost/quadraticstore?createDatabaseIfNotExist=true&amp;amp;useUnicode=true&amp;amp;characterEncoding=utf-8&amp;amp;autoReconnect=true");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void loadTest(){
        QuadraticEquationData qed = new QuadraticEquationData();
        session.save(qed);
        session.load(QuadraticEquationData.class, new PK());
    }
}
