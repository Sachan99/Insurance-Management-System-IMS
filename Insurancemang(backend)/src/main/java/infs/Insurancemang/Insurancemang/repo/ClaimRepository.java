package infs.Insurancemang.Insurancemang.repo;


import infs.Insurancemang.Insurancemang.model.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimRepository extends MongoRepository<Claim, String> {
}
