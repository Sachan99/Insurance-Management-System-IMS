package infs.Insurancemang.Insurancemang.DTO;

import java.util.Date;

public class ClaimsByAgentDTO {
    private String claimId;
    private String policyId;
    private Date dateOfClaim;
    private double claimAmount;
    private String status;
    private String policyNumber;
    private String policyType;
    private Date policyStartDate;
    private Date policyEndDate;
    private boolean policyActive;
    private String agentId;
    private String agentFirstName;
    private String agentLastName;
    private String agentEmail;

    public ClaimsByAgentDTO() {
    }

    public ClaimsByAgentDTO(String claimId, String policyId, Date dateOfClaim, double claimAmount, String status, String policyNumber, String policyType, Date policyStartDate, Date policyEndDate, boolean policyActive, String agentId, String agentFirstName, String agentLastName, String agentEmail) {
        this.claimId = claimId;
        this.policyId = policyId;
        this.dateOfClaim = dateOfClaim;
        this.claimAmount = claimAmount;
        this.status = status;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyEndDate;
        this.policyActive = policyActive;
        this.agentId = agentId;
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
        this.agentEmail = agentEmail;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public Date getDateOfClaim() {
        return dateOfClaim;
    }

    public void setDateOfClaim(Date dateOfClaim) {
        this.dateOfClaim = dateOfClaim;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "ClaimsByAgentDTO{" +
                "claimId='" + claimId + '\'' +
                ", policyId='" + policyId + '\'' +
                ", dateOfClaim=" + dateOfClaim +
                ", claimAmount=" + claimAmount +
                ", status='" + status + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", policyType='" + policyType + '\'' +
                ", policyStartDate=" + policyStartDate +
                ", policyEndDate=" + policyEndDate +
                ", policyActive=" + policyActive +
                ", agentId='" + agentId + '\'' +
                ", agentFirstName='" + agentFirstName + '\'' +
                ", agentLastName='" + agentLastName + '\'' +
                ", agentEmail='" + agentEmail + '\'' +
                '}';
    }
}
