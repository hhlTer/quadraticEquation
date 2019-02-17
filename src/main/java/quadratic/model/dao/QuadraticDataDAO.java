package quadratic.model.dao;


import quadratic.model.domain.QuadraticData;

import java.util.List;

public interface QuadraticDataDAO {
    void addQuadraticData(QuadraticData quadraticData);
    List<QuadraticData> getAllQuadraticData();
    void removeQuadraticDataById(long id);
    QuadraticData getQuadraticDataById(long id);
}
