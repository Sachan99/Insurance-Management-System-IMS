package infs.Insurancemang.Insurancemang.repo;

import infs.Insurancemang.Insurancemang.DTO.LatePaymentDTO;
import infs.Insurancemang.Insurancemang.DTO.MonthlyPayment;
import infs.Insurancemang.Insurancemang.model.Payment;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    List<Payment> findByCustomerId(String customerId);
    List<Payment> findByPolicyId(String policyId);

    @Aggregation({
            "{ $lookup: { from: 'customer', localField: 'customerId', foreignField: '_id', as: 'customerDetails' } }",
            "{ $lookup: { from: 'policy', localField: 'policyId', foreignField: '_id', as: 'policyDetails' } }",
            "{ $unwind: '$customerDetails' }",
            "{ $unwind: '$policyDetails' }",
            "{ $project: { customerId: '$customerDetails._id', customerFirstName: '$customerDetails.firstName', customerLastName: '$customerDetails.lastName', customerEmail: '$customerDetails.email', customerDateOfBirth: '$customerDetails.dateOfBirth', customerPhoneNumber: '$customerDetails.phoneNumber', policyId: '$policyDetails._id', policyNumber: '$policyDetails.policyNumber', policyType: '$policyDetails.policyType', policyStartDate: '$policyDetails.startDate', policyEndDate: '$policyDetails.endDate', policyActive: '$policyDetails.isActive', amountPaid: 1, paymentDate: 1, latePayment: '$isLatePayment', paymentId: '$_id' } }",
            "{ $match: { latePayment: ?1, policyType: ?0 } }"
    })
    List<LatePaymentDTO> findLatePaymentsWithDetails(String policyType, String latePayment);

}
