package infs.Insurancemang.Insurancemang.service;

import infs.Insurancemang.Insurancemang.DTO.ClaimStatusCount;
import infs.Insurancemang.Insurancemang.model.Claim;
import infs.Insurancemang.Insurancemang.repo.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregationOptions;

@Service
public class ClaimService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private ClaimRepository claimRepository;

    @Autowired
    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Optional<Claim> getClaimById(String id) {
        return claimRepository.findById(id);
    }

    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public void deleteClaim(String id) {
        claimRepository.deleteById(id);
    }

    public List<ClaimStatusCount> getClaimStatusCounts() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("claimStatus").count().as("count"),
                Aggregation.project("count").and("claimStatus").previousOperation()
        );

        AggregationResults<ClaimStatusCount> results = mongoTemplate.aggregate(
                aggregation, "claims", ClaimStatusCount.class
        );


        return results.getMappedResults();
    }



}
