package infs.Insurancemang.Insurancemang.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "policy")
public class Policy {

    @Id
    private String id;
    private String customerId; // to link with Customer
    private String agentId;    // to link with Agent
    private String policyNumber;
    private int policyAmount;
    private String policyType; // e.g., auto, life, home
    private Date startDate;
    private Date endDate;
    private boolean isActive;

    public Policy() {
    }

    public Policy(String id, String customerId, String agentId, String policyNumber, int policyAmount, String policyType, Date startDate, Date endDate, boolean isActive) {
        this.id = id;
        this.customerId = customerId;
        this.agentId = agentId;
        this.policyNumber = policyNumber;
        this.policyAmount = policyAmount;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(int policyAmount) {
        this.policyAmount = policyAmount;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", agentId='" + agentId + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", policyAmount=" + policyAmount +
                ", policyType='" + policyType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                '}';
    }
}
