package quadratic.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;
import quadratic.model.repository.QuadraticEquationRepository;

@Service
public class QuadraticEquationService implements QuadraticDatabaseService {

    @Autowired
    private QuadraticEquationRepository quadraticEquationRepository;


    @Transactional
    public void save(QuadraticEquationData quadraticData) {
        quadraticEquationRepository.addQuadraticData(quadraticData);
    }

    @Transactional
    public QuadraticEquationData getQuadraticDataById(PK id) {
        return quadraticEquationRepository.getQuadraticDataById(id);
    }
}
