package infs.Insurancemang.Insurancemang.service;

import com.mongodb.BasicDBObject;
import infs.Insurancemang.Insurancemang.DTO.MonthlyPayment;
import infs.Insurancemang.Insurancemang.model.Payment;
import infs.Insurancemang.Insurancemang.repo.PaymentRepository;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


import java.util.List;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private PaymentRepository paymentRepository;


    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(String id) {
        return paymentRepository.findById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(String id) {
        paymentRepository.deleteById(id);
    }

    public List<Payment> getPaymentsByCustomerId(String customerId) {
        return paymentRepository.findByCustomerId(customerId);
    }

    public List<Payment> getPaymentsByPolicyId(String policyId) {
        return paymentRepository.findByPolicyId(policyId);
    }

    public Map<String, Double> getMonthlyPremiums() {
        // Define the aggregation operations
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project()
                        .and("paymentDate").substring(0, 7).as("id") // Extract YYYY-MM part from paymentDate
                        .and("amountPaid").as("amountPaid"),
                Aggregation.group("id")
                        .sum("amountPaid").as("totalPayment")
        );

        // Execute the aggregation
        AggregationResults<MonthlyPayment> results = mongoTemplate.aggregate(aggregation, "payment", MonthlyPayment.class);

        // Convert the results to a Map
        Map<String, Double> monthlyPaymentsMap = new LinkedHashMap<>();
        results.getMappedResults().forEach(result -> monthlyPaymentsMap.put(result.getId(), result.getTotalPayment()));

        return monthlyPaymentsMap;
    }


}
