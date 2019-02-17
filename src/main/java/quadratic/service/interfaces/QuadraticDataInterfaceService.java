package quadratic.service.interfaces;


import quadratic.model.domain.QuadraticData;

import java.util.List;

public interface QuadraticDataInterfaceService {
    void addQuadraticData(QuadraticData quadraticData);
    List<QuadraticData> getAllQuadraticData();
    void removeQuadraticDataById(long id);
    QuadraticData getQuadraticDataById(long id);
}
