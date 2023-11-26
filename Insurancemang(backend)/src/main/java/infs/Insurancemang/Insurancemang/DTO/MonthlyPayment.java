package infs.Insurancemang.Insurancemang.DTO;

import org.springframework.data.annotation.Id;

public class MonthlyPayment {
    private String id; // This will be set to the monthYear value from the aggregation
    private Double totalPayment;

    // Getters and setters...
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
