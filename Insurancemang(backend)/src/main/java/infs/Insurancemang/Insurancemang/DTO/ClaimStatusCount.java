package infs.Insurancemang.Insurancemang.DTO;

public class ClaimStatusCount {

    private String claimStatus;
    private Long count;

    public ClaimStatusCount() {
    }

    public ClaimStatusCount(String claimStatus, Long count) {
        this.claimStatus = claimStatus;
        this.count = count;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ClaimStatusCount{" +
                "claimStatus='" + claimStatus + '\'' +
                ", count=" + count +
                '}';
    }
}
