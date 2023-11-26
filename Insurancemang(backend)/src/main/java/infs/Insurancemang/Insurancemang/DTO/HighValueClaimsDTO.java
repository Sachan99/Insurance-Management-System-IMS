package infs.Insurancemang.Insurancemang.DTO;

import java.util.Date;

public class HighValueClaimsDTO {

    private String claimId;
    private double claimAmount;
    private String claimStatus;

    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private Date customerDateOfBirth;
    private String customerPhoneNumber;
    private String policyId;
    private String policyNumber;
    private String policyAmount;
    private String policyType;
    private Date policyStartDate;
    private Date policyEndDate;
    private Boolean policyActive;

    public HighValueClaimsDTO(String claimId, double claimAmount, String claimStatus, String customerId, String customerFirstName, String customerLastName, String customerEmail, Date customerDateOfBirth, String customerPhoneNumber, String policyId, String policyNumber, String policyAmount, String policyType, Date policyStartDate, Date policyEndDate, Boolean policyActive) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimStatus = claimStatus;
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerPhoneNumber = customerPhoneNumber;
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.policyAmount = policyAmount;
        this.policyType = policyType;
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyEndDate;
        this.policyActive = policyActive;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
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

    public String getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(String policyAmount) {
        this.policyAmount = policyAmount;
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

    @Override
    public String toString() {
        return "HighValueClaimsDTO{" +
                "claimId='" + claimId + '\'' +
                ", claimAmount=" + claimAmount +
                ", claimStatus='" + claimStatus + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerDateOfBirth=" + customerDateOfBirth +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", policyId='" + policyId + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", policyAmount='" + policyAmount + '\'' +
                ", policyType='" + policyType + '\'' +
                ", policyStartDate=" + policyStartDate +
                ", policyEndDate=" + policyEndDate +
                ", policyActive=" + policyActive +
                '}';
    }
}