package infs.Insurancemang.Insurancemang.service;

import infs.Insurancemang.Insurancemang.DTO.ClaimByAgentDTO;
import infs.Insurancemang.Insurancemang.DTO.ClaimsByAgentDTO;
import infs.Insurancemang.Insurancemang.model.Agent;
import infs.Insurancemang.Insurancemang.repo.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Optional<Agent> getAgentById(String id) {
        return agentRepository.findById(id);
    }

    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public void deleteAgent(String id) {
        agentRepository.deleteById(id);
    }


//    4th Query
    public List<ClaimByAgentDTO> findAgentsWithActivePoliciesAndMaleCustomers(String gender, boolean isActive) {
        LookupOperation lookupPolicy = LookupOperation.newLookup()
                .from("policy")
                .localField("policyIds")
                .foreignField("_id")
                .as("policies");

        UnwindOperation unwindPolicy = Aggregation.unwind("policies");
        MatchOperation matchActivePolicy = Aggregation.match(Criteria.where("policies.isActive").is(isActive));

        LookupOperation lookupCustomer = LookupOperation.newLookup()
                .from("customer")
                .localField("policies.customerId")
                .foreignField("_id")
                .as("customers");

        UnwindOperation unwindCustomer = Aggregation.unwind("customers");
        MatchOperation matchMaleCustomer = Aggregation.match(Criteria.where("customers.gender").is(gender));

        ProjectionOperation project = Aggregation.project()
                .and("_id").as("agentId")
                .and("firstName").as("agentFirstName")
                .and("lastName").as("agentLastName")
                .and("email").as("agentEmail")
                .and("policies._id").as("policyId")
                .and("policies.policyNumber").as("policyNumber")
                .and("policies.policyType").as("policyType")
                .and("policies.startDate").as("policyStartDate")
                .and("policies.endDate").as("policyEndDate")
                .and("policies.isActive").as("policyActive")
                .and("customers._id").as("customerId")
                .and("customers.firstName").as("customerFirstName")
                .and("customers.lastName").as("customerLastName")
                .and("customers.email").as("customerEmail")
                .and("customers.age").as("customerAge")
                        .and("customers.gender").as("customerGender");
        Aggregation aggregation = Aggregation.newAggregation(
                lookupPolicy,
                unwindPolicy,
                matchActivePolicy,
                lookupCustomer,
                unwindCustomer,
                matchMaleCustomer,
                project
        );

        AggregationResults<ClaimByAgentDTO> results = mongoTemplate.aggregate(aggregation, "agents", ClaimByAgentDTO.class);
        return results.getMappedResults();
    }

}
