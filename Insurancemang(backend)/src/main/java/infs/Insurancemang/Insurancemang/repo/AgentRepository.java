package infs.Insurancemang.Insurancemang.repo;

import infs.Insurancemang.Insurancemang.model.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgentRepository extends MongoRepository<Agent, String> {
}
