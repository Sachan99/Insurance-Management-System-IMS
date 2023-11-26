package infs.Insurancemang.Insurancemang.DTO;

import java.util.Date;

public class CustomerPaymentPolicyDTO {


    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private Date customerDateOfBirth;
    private String customerPhoneNumber;

    // Policy details
    private String policyId;
    private String policyNumber;
    private String policyType;
    private Date policyStartDate;
    private Date policyEndDate;
    private boolean policyActive;

    // Payment details
    private String paymentId;
    private String paymentDate;
    private double amountPaid;
    private boolean latePayment;

    public CustomerPaymentPolicyDTO() {
    }

    public CustomerPaymentPolicyDTO(String customerId, String customerFirstName, String customerLastName, String customerEmail, Date customerDateOfBirth, String customerPhoneNumber, String policyId, String policyNumber, String policyType, Date policyStartDate, Date policyEndDate, boolean policyActive, String paymentId, String paymentDate, double amountPaid, boolean latePayment) {
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
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
        this.latePayment = latePayment;
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

    public boolean isPolicyActive() {
        return policyActive;
    }

    public void setPolicyActive(boolean policyActive) {
        this.policyActive = policyActive;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public boolean isLatePayment() {
        return latePayment;
    }

    public void setLatePayment(boolean latePayment) {
        this.latePayment = latePayment;
    }
}
