package quadratic.service.implementation;


import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;

import java.util.List;

public interface QuadraticDatabaseService {
    void addQuadraticData(QuadraticDataMerged quadraticData);
    List<QuadraticDataMerged> getAllQuadraticData();
    void removeQuadraticDataById(PK id);
    QuadraticDataMerged getQuadraticDataById(PK id);
}
