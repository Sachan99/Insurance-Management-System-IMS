package infs.Insurancemang.Insurancemang.service;

import infs.Insurancemang.Insurancemang.DTO.*;
import infs.Insurancemang.Insurancemang.model.Policy;
import infs.Insurancemang.Insurancemang.model.Customer;
import infs.Insurancemang.Insurancemang.model.Payment;
import infs.Insurancemang.Insurancemang.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private PaymentRepository paymentRepository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public SearchService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<CustomerPaymentPolicyDTO> findAllPaymentsWithCustomerAndPolicy() {
        LookupOperation lookupCustomer = LookupOperation.newLookup()
                .from("customer")
                .localField("customerId")
                .foreignField("_id")
                .as("customerDetails");

        LookupOperation lookupPolicy = LookupOperation.newLookup()
                .from("policy")
                .localField("policyId")
                .foreignField("_id")
                .as("policyDetails");

        UnwindOperation unwindCustomer = Aggregation.unwind("customerDetails");
        UnwindOperation unwindPolicy = Aggregation.unwind("policyDetails");

        Aggregation aggregation = Aggregation.newAggregation(
                lookupCustomer,
                lookupPolicy,
                unwindCustomer,
                unwindPolicy,
                Aggregation.project()
                        .and("customerDetails._id").as("customerId")
                        .and("customerDetails.firstName").as("customerFirstName")
                        .and("customerDetails.lastName").as("customerLastName")
                        .and("customerDetails.email").as("customerEmail")
                        .and("customerDetails.dateOfBirth").as("customerDateOfBirth")
                        .and("customerDetails.phoneNumber").as("customerPhoneNumber")
                        .and("policyDetails._id").as("policyId")
                        .and("policyDetails.policyNumber").as("policyNumber")
                        .and("policyDetails.policyType").as("policyType")
                        .and("policyDetails.startDate").as("policyStartDate")
                        .and("policyDetails.endDate").as("policyEndDate")
                        .and("policyDetails.isActive").as("policyActive")
                        .and("amountPaid").as("amountPaid")
                        .and("paymentDate").as("paymentDate")
                        .and("isLatePayment").as("latePayment")
                        .and("_id").as("paymentId")
        );

        return mongoTemplate.aggregate(aggregation, "payment", CustomerPaymentPolicyDTO.class).getMappedResults();
    }



    //2nd Query:
//    public List<LatePaymentDTO> findLatePaymentsWithDetails(String policyType, String latePayment) {
//        MatchOperation matchOperation = Aggregation.match(new Criteria());
//
//        if (policyType != null) {
//            matchOperation = Aggregation.match(Criteria.where("policyType").is(policyType));
//        }
//
//        if (latePayment != null) {
//            matchOperation = Aggregation.match(Criteria.where("isLatePayment").is(latePayment));
//        }
//
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.lookup("customer", "customerId", "_id", "customerDetails"),
//                Aggregation.lookup("policy", "policyId", "_id", "policyDetails"),
//                Aggregation.unwind("customerDetails"),
//                Aggregation.unwind("policyDetails"),
//                matchOperation,
//                Aggregation.project()
//                        .and("customerDetails._id").as("customerId")
//                        .and("customerDetails.firstName").as("customerFirstName")
//                        .and("customerDetails.lastName").as("customerLastName")
//                        .and("customerDetails.email").as("customerEmail")
//                        .and("customerDetails.dateOfBirth").as("customerDateOfBirth")
//                        .and("customerDetails.phoneNumber").as("customerPhoneNumber")
//                        .and("policyDetails._id").as("policyId")
//                        .and("policyDetails.policyNumber").as("policyNumber")
//                        .and("policyDetails.policyType").as("policyType")
//                        .and("policyDetails.startDate").as("policyStartDate")
//                        .and("policyDetails.endDate").as("policyEndDate")
//                        .and("policyDetails.isActive").as("policyActive")
//                        .and("amountPaid").as("amountPaid")
//                        .and("paymentDate").as("paymentDate")
//                        .and("latePayment").as("latePayment")
//                        .and("_id").as("paymentId")
//        );
//
//        AggregationResults<LatePaymentDTO> results = mongoTemplate.aggregate(aggregation, "payment", LatePaymentDTO.class);
//        return results.getMappedResults();
//
//    }

    //3rd Query:
    public List<HighValueClaimsDTO> findHighValueClaims(double claimAmountThreshold) {
    MatchOperation matchOperation = Aggregation.match(Criteria.where("claimAmount").gte(claimAmountThreshold));

    LookupOperation lookupPolicy = LookupOperation.newLookup()
            .from("policy")
            .localField("policyId")
            .foreignField("_id")
            .as("policyDetails");

    LookupOperation lookupCustomer = LookupOperation.newLookup()
            .from("customer")
            .localField("customerId")
            .foreignField("_id")
            .as("customerDetails");

    UnwindOperation unwindPolicy = Aggregation.unwind("policyDetails");
    UnwindOperation unwindCustomer = Aggregation.unwind("customerDetails");

    ProjectionOperation project = Aggregation.project()
            .and("_id").as("claimId")
            .and("claimAmount").as("claimAmount")
            .and("claimStatus").as("claimStatus")
            .and("customerDetails._id").as("customerId")
            .and("customerDetails.firstName").as("customerFirstName")
            .and("customerDetails.lastName").as("customerLastName")
            .and("customerDetails.email").as("customerEmail")
            .and("customerDetails.dateOfBirth").as("customerDateOfBirth")
            .and("customerDetails.phoneNumber").as("customerPhoneNumber")
            .and("policyDetails._id").as("policyId")
            .and("policyDetails.policyNumber").as("policyNumber")
            .and("policyDetails.policyAmount").as("policyAmount")

            .and("policyDetails.policyType").as("policyType")
            .and("policyDetails.startDate").as("policyStartDate")
            .and("policyDetails.endDate").as("policyEndDate")
            .and("policyDetails.isActive").as("policyActive");

    Aggregation aggregation = Aggregation.newAggregation(
            matchOperation,
            lookupPolicy,
            unwindPolicy,
            lookupCustomer,
            unwindCustomer,
            project
    );

    AggregationResults<HighValueClaimsDTO> results = mongoTemplate.aggregate(aggregation, "claims", HighValueClaimsDTO.class);

        return results.getMappedResults();
}

//4th query
public List<ClaimsByAgentDTO> findClaimsByAgent(String firstName, String lastName) {
    LookupOperation lookupPolicy = LookupOperation.newLookup()
            .from("policy")
            .localField("policyId")
            .foreignField("_id")
            .as("policy");

    LookupOperation lookupAgent = LookupOperation.newLookup()
            .from("agents")
            .localField("policy.agentId")
            .foreignField("_id")
            .as("agent");

    UnwindOperation unwindPolicy = Aggregation.unwind("policy");
    UnwindOperation unwindAgent = Aggregation.unwind("agent");

    MatchOperation matchAgent = Aggregation.match(Criteria.where("firstName").is(firstName)
            .and("lastName").is(lastName));

    ProjectionOperation project = Aggregation.project()
            .and("_id").as("claimId")
            .and("policyId").as("policyId")
            .and("dateOfClaim").as("dateOfClaim")
            .and("claimAmount").as("claimAmount")
            .and("status").as("status")
            .and("policy.policyNumber").as("policyNumber")
            .and("policy.policyType").as("policyType")
            .and("policy.startDate").as("policyStartDate")
            .and("policy.endDate").as("policyEndDate")
            .and("policy.isActive").as("policyActive")
            .and("agent._id").as("agentId")
            .and("agent.firstName").as("agentFirstName")
            .and("agent.lastName").as("agentLastName")
            .and("agent.email").as("agentEmail");

    Aggregation aggregation = Aggregation.newAggregation(
            lookupPolicy,
            unwindPolicy,
            lookupAgent,
            unwindAgent,
            matchAgent,
            project
    );

    AggregationResults<ClaimsByAgentDTO> results = mongoTemplate.aggregate(aggregation, "claims", ClaimsByAgentDTO.class);

    return results.getMappedResults();
}




//late payment newww:
//public List<LatePaymentDTO> findLatePaymentsWithDetails(String policyType, Boolean latePayment) {
//    Criteria matchCriteria = new Criteria();
//
//    if (policyType != null) {
//        matchCriteria = matchCriteria.and("policyType").is(policyType);
//    }
//
//    if (latePayment != null) {
//        matchCriteria = matchCriteria.and("latePayment").is(latePayment);
//    }
//
//    MatchOperation matchOperation = Aggregation.match(matchCriteria);
//
//    Aggregation aggregation = Aggregation.newAggregation(
//            lookupCustomer,
//            lookupPolicy,
//            unwindCustomer,
//            unwindPolicy,
//            matchOperation,
//            project
//    );
//
//    AggregationResults<LatePaymentDTO> results = mongoTemplate.aggregate(aggregation, "payment", LatePaymentDTO.class);
//    return results.getMappedResults();
//}


    public List<LatePaymentDTO> findLatePaymentsWithDetails(String policyType, String latePayment) {
        return paymentRepository.findLatePaymentsWithDetails(policyType, latePayment);
    }


}
