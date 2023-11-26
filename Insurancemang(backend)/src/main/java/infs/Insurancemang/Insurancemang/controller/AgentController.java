package infs.Insurancemang.Insurancemang.controller;

import infs.Insurancemang.Insurancemang.DTO.ClaimByAgentDTO;
import infs.Insurancemang.Insurancemang.DTO.ClaimsByAgentDTO;
import infs.Insurancemang.Insurancemang.model.Agent;
import infs.Insurancemang.Insurancemang.repo.AgentRepository;
import infs.Insurancemang.Insurancemang.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
@CrossOrigin("*")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    private AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable String id) {
        return agentService.getAgentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable String id, @RequestBody Agent agentDetails) {
        return agentService.getAgentById(id)
                .map(existingAgent -> {
                    existingAgent.setFirstName(agentDetails.getFirstName());
                    existingAgent.setLastName(agentDetails.getLastName());
                    existingAgent.setEmail(agentDetails.getEmail());
                    existingAgent.setPolicyIds(agentDetails.getPolicyIds());
                    existingAgent.setGender(agentDetails.getGender());
                    return ResponseEntity.ok(agentService.saveAgent(existingAgent));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable String id) {
        return agentService.getAgentById(id)
                .map(agent -> {
                    agentService.deleteAgent(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dashboard/totalAgents")
    public Long getTotalAgents() {
        return agentRepository.count();
    }


    @GetMapping("/agents-pol-cus")
    public ResponseEntity<List<ClaimByAgentDTO>> findAgentsByGenderAndActiveStatus(
            @RequestParam("gender") String gender,
            @RequestParam("isActive") boolean isActive) {
        List<ClaimByAgentDTO> agents = agentService.findAgentsWithActivePoliciesAndMaleCustomers(gender, isActive);
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }
}
