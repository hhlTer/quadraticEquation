package quadratic.service.implementation;


import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;


public interface QuadraticDatabaseService {
    void addQuadraticData(QuadraticDataMerged quadraticData);
    QuadraticDataMerged getQuadraticDataById(PK id);
}
