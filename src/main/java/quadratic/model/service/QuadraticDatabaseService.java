package quadratic.model.service;


import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;


public interface QuadraticDatabaseService {
    void save(QuadraticEquationData quadraticData);
    QuadraticEquationData getQuadraticDataById(PK id);
}
