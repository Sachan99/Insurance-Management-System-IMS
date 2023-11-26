package infs.Insurancemang.Insurancemang.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "payment")
public class Payment {

    @Id
    private String id;
    private String policyId; // to link with Policy
    private String customerId; // to link with Customer
    private String paymentDate;
    private double amountPaid;
    private String isLatePayment;

    public Payment() {
    }

    public Payment(String id, String policyId, String customerId, String paymentDate, double amountPaid, String isLatePayment) {
        this.id = id;
        this.policyId = policyId;
        this.customerId = customerId;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
        this.isLatePayment = isLatePayment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getIsLatePayment() {
        return isLatePayment;
    }

    public void setIsLatePayment(String isLatePayment) {
        this.isLatePayment = isLatePayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", policyId='" + policyId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", amountPaid=" + amountPaid +
                ", isLatePayment='" + isLatePayment + '\'' +
                '}';
    }
}
