package infs.Insurancemang.Insurancemang.controller;

import infs.Insurancemang.Insurancemang.DTO.PolicyTypeCount;
import infs.Insurancemang.Insurancemang.model.Policy;
import infs.Insurancemang.Insurancemang.repo.PolicyRepository;
import infs.Insurancemang.Insurancemang.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin("*")
public class PolicyController {

    private PolicyService policyService;

    @Autowired
    private PolicyRepository policyRepository;




    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable String id) {
        return policyService.getPolicyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<Policy> getPoliciesByCustomerId(@PathVariable String customerId) {
        return policyService.getPoliciesByCustomerId(customerId);
    }

    @GetMapping("/agent/{agentId}")
    public List<Policy> getPoliciesByAgentId(@PathVariable String agentId) {
        return policyService.getPoliciesByAgentId(agentId);
    }

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable String id, @RequestBody Policy policyDetails) {
        return policyService.getPolicyById(id)
                .map(existingPolicy -> {
                    existingPolicy.setCustomerId(policyDetails.getCustomerId());
                    existingPolicy.setAgentId(policyDetails.getAgentId());
                    existingPolicy.setPolicyNumber(policyDetails.getPolicyNumber());
                    existingPolicy.setPolicyAmount(policyDetails.getPolicyAmount());
                    existingPolicy.setPolicyType(policyDetails.getPolicyType());
                    existingPolicy.setStartDate(policyDetails.getStartDate());
                    existingPolicy.setEndDate(policyDetails.getEndDate());
                    existingPolicy.setActive(policyDetails.isActive());
                    Policy updatedPolicy = policyService.savePolicy(existingPolicy);
                    return ResponseEntity.ok(updatedPolicy);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePolicy(@PathVariable String id) {
        return policyService.getPolicyById(id)
                .map(policy -> {
                    policyService.deletePolicy(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/dashboard/totalPolicy")
    public Long getTotalPolicies() {
        return policyRepository.count();
    }


    // New endpoint to get policy type counts
    @GetMapping("/distinct-types")
    public List<PolicyTypeCount> getPolicyTypeCounts() {
        return policyService.getPolicyTypeCounts();
    }






}
