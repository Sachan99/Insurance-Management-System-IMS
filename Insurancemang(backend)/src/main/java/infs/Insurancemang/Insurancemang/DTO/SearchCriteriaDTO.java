package infs.Insurancemang.Insurancemang.DTO;

import java.util.Date;

public class SearchCriteriaDTO {

    private String policyType;
    private double minimumPaymentAmount;
    private Date startDate;
    private Date endDate;

    public SearchCriteriaDTO() {
    }

    public SearchCriteriaDTO(String policyType, double minimumPaymentAmount, Date startDate, Date endDate) {
        this.policyType = policyType;
        this.minimumPaymentAmount = minimumPaymentAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public double getMinimumPaymentAmount() {
        return minimumPaymentAmount;
    }

    public void setMinimumPaymentAmount(double minimumPaymentAmount) {
        this.minimumPaymentAmount = minimumPaymentAmount;
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

    @Override
    public String toString() {
        return "SearchCriteriaDTO{" +
                "policyType='" + policyType + '\'' +
                ", minimumPaymentAmount=" + minimumPaymentAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
