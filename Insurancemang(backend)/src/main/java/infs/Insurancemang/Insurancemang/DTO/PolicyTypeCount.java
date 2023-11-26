package infs.Insurancemang.Insurancemang.DTO;

public class PolicyTypeCount {
    private String policyType;
    private long count;

    public PolicyTypeCount(String policyType, long count) {
        this.policyType = policyType;
        this.count = count;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
