package quadratic.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quadratic.model.dao.QuadraticDAORepository;
import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;

import java.util.List;

@Service
public class QuadraticDataService implements QuadraticDatabaseService {

    @Autowired
    private QuadraticDAORepository quadraticDAORepository;


    @Transactional
    public void addQuadraticData(QuadraticDataMerged quadraticData) {
        quadraticDAORepository.addQuadraticData(quadraticData);
    }

    @Transactional
    public List<QuadraticDataMerged> getAllQuadraticData() {
        return quadraticDAORepository.getAllQuadraticData();
    }

    @Transactional
    public void removeQuadraticDataById(PK id) {
        System.out.println();
        quadraticDAORepository.removeQuadraticDataById(id);
    }

    @Transactional
    public QuadraticDataMerged getQuadraticDataById(PK id) {
        return quadraticDAORepository.getQuadraticDataById(id);
    }
}
