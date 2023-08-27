package redis_project.repository;

import redis_project.entity.PolicyHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisbursementRepository extends JpaRepository<PolicyHolderEntity, Integer> {
}
