package quadratic.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quadratic.model.dao.QuadraticDataDAO;
import quadratic.model.domain.QuadraticData;
import quadratic.service.interfaces.QuadraticDataInterfaceService;

import java.util.List;

@Service
public class QuadraticDataService implements QuadraticDataInterfaceService {

    @Autowired
    private QuadraticDataDAO quadraticDataDAO;


    @Transactional
    public void addQuadraticData(QuadraticData quadraticData) {
        quadraticDataDAO.addQuadraticData(quadraticData);
    }

    @Transactional
    public List<QuadraticData> getAllQuadraticData() {
        return quadraticDataDAO.getAllQuadraticData();
    }

    @Transactional
    public void removeQuadraticDataById(long id) {
        quadraticDataDAO.removeQuadraticDataById(id);
    }

    public QuadraticData getQuadraticDataById(long id) {
        return quadraticDataDAO.getQuadraticDataById(id);
    }
}
