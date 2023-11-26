package infs.Insurancemang.Insurancemang.DTO;

import infs.Insurancemang.Insurancemang.model.Customer;
import infs.Insurancemang.Insurancemang.model.Policy;

import java.util.Date;

public class LatePaymentDTO {
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private Date customerDateOfBirth;
    private String customerPhoneNumber;
    private String policyId;
    private String policyNumber;
    private String policyType;
    private Date policyStartDate;
    private Date policyEndDate;
    private Boolean policyActive;
    private Double amountPaid;
    private String paymentDate;
    private String latePayment;
    private String paymentId;

    public LatePaymentDTO() {
    }

    public LatePaymentDTO(String customerId, String customerFirstName, String customerLastName, String customerEmail, Date customerDateOfBirth, String customerPhoneNumber, String policyId, String policyNumber, String policyType, Date policyStartDate, Date policyEndDate, Boolean policyActive, Double amountPaid, String paymentDate, String latePayment, String paymentId) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerPhoneNumber = customerPhoneNumber;
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyEndDate;
        this.policyActive = policyActive;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.latePayment = latePayment;
        this.paymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Date getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(Date policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public Boolean getPolicyActive() {
        return policyActive;
    }

    public void setPolicyActive(Boolean policyActive) {
        this.policyActive = policyActive;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getLatePayment() {
        return latePayment;
    }

    public void setLatePayment(String latePayment) {
        this.latePayment = latePayment;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }


    @Override
    public String toString() {
        return "LatePaymentDTO{" +
                "customerId='" + customerId + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerDateOfBirth=" + customerDateOfBirth +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", policyId='" + policyId + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", policyType='" + policyType + '\'' +
                ", policyStartDate=" + policyStartDate +
                ", policyEndDate=" + policyEndDate +
                ", policyActive=" + policyActive +
                ", amountPaid=" + amountPaid +
                ", paymentDate=" + paymentDate +
                ", latePayment=" + latePayment +
                ", paymentId='" + paymentId + '\'' +
                '}';
    }
}
