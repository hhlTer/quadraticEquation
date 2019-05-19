package quadratic.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quadratic.model.repository.QuadraticDAORepository;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;

@Service
public class QuadraticDataService implements QuadraticDatabaseService {

    @Autowired
    private QuadraticDAORepository quadraticDAORepository;


    @Transactional
    public void save(QuadraticEquationData quadraticData) {
        quadraticDAORepository.addQuadraticData(quadraticData);
    }

    @Transactional
    public QuadraticEquationData getQuadraticDataById(PK id) {
        return quadraticDAORepository.getQuadraticDataById(id);
    }
}
