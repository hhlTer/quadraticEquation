package quadratic.model.dao;

import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;

import java.util.List;

public interface QuadraticDAORepository {
    void addQuadraticData(QuadraticDataMerged quadraticData);
    List<QuadraticDataMerged> getAllQuadraticData();
    void removeQuadraticDataById(PK id);
    QuadraticDataMerged getQuadraticDataById(PK id);
}
