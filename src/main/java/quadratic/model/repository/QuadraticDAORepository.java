package quadratic.model.repository;

import quadratic.model.domain.PK;
import quadratic.model.domain.QuadraticDataMerged;

import java.util.List;

public interface QuadraticDAORepository {
    void addQuadraticData(QuadraticDataMerged quadraticData);
    QuadraticDataMerged getQuadraticDataById(PK id);
}
