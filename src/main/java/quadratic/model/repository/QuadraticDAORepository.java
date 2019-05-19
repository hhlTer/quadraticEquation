package quadratic.model.repository;

import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticEquationData;

public interface QuadraticDAORepository {
    void addQuadraticData(QuadraticEquationData quadraticData);
    QuadraticEquationData getQuadraticDataById(PK id);
}
