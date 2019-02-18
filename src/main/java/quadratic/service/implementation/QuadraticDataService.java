package quadratic.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quadratic.model.dao.QuadraticDAORepository;
import quadratic.model.domain.QuadraticData;
import quadratic.service.interfaces.QuadraticDataInterfaceService;

import java.util.List;

@Service
public class QuadraticDataService implements QuadraticDataInterfaceService {

    @Autowired
    private QuadraticDAORepository quadraticDAORepository;


    @Transactional
    public void addQuadraticData(QuadraticData quadraticData) {
        quadraticDAORepository.addQuadraticData(quadraticData);
    }

    @Transactional
    public List<QuadraticData> getAllQuadraticData() {
        return quadraticDAORepository.getAllQuadraticData();
    }

    @Transactional
    public void removeQuadraticDataById(long id) {
        quadraticDAORepository.removeQuadraticDataById(id);
    }

    public QuadraticData getQuadraticDataById(long id) {
        return quadraticDAORepository.getQuadraticDataById(id);
    }
}
