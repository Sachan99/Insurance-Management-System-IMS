package infs.Insurancemang.Insurancemang.repo;

import infs.Insurancemang.Insurancemang.DTO.PolicyTypeCount;
import infs.Insurancemang.Insurancemang.model.Policy;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PolicyRepository extends MongoRepository<Policy, String> {

    // Custom query methods if needed, e.g., find policies by customer or agent
    List<Policy> findByCustomerId(String customerId);
    List<Policy> findByAgentId(String agentId);

    @Aggregation("{ $group: { _id: '$policyType', count: { $sum: 1 } } }")
    List<PolicyTypeCount> findPolicyTypeCounts();
}
