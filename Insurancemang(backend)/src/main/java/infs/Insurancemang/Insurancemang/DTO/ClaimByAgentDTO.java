package infs.Insurancemang.Insurancemang.DTO;

import java.util.Date;

public class ClaimByAgentDTO {

    private String agentId;
    private String agentFirstName;
    private String agentLastName;
    private String agentEmail;
    private String policyId;
    private String policyNumber;
    private String policyType;
    private Date policyStartDate;
    private Date policyEndDate;
    private boolean policyActive;
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerGender;
    private String customerAge;



    public ClaimByAgentDTO(String agentId, String agentFirstName, String agentLastName, String agentEmail, String policyId, String policyNumber, String policyType, Date policyStartDate, Date policyEndDate, boolean policyActive, String customerId, String customerFirstName, String customerLastName, String customerEmail, String customerGender, String customerAge) {
        this.agentId = agentId;
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
        this.agentEmail = agentEmail;
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyEndDate;
        this.policyActive = policyActive;
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerGender = customerGender;
        this.customerAge = customerAge;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
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

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }
}