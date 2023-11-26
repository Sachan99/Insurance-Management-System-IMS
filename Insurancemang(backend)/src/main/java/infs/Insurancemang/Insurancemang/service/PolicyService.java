package infs.Insurancemang.Insurancemang.service;

import infs.Insurancemang.Insurancemang.DTO.PolicyTypeCount;
import infs.Insurancemang.Insurancemang.model.Policy;
import infs.Insurancemang.Insurancemang.repo.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyService {


    private PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Optional<Policy> getPolicyById(String id) {
        return policyRepository.findById(id);
    }

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public void deletePolicy(String id) {
        policyRepository.deleteById(id);
    }

    public List<Policy> getPoliciesByCustomerId(String customerId) {
        return policyRepository.findByCustomerId(customerId);
    }

    public List<Policy> getPoliciesByAgentId(String agentId) {
        return policyRepository.findByAgentId(agentId);
    }

    // New method to get policy type counts
    public List<PolicyTypeCount> getPolicyTypeCounts() {
        return policyRepository.findPolicyTypeCounts();
    }


}
