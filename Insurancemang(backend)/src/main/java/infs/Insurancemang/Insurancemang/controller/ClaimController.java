package infs.Insurancemang.Insurancemang.controller;

import infs.Insurancemang.Insurancemang.DTO.ClaimStatusCount;
import infs.Insurancemang.Insurancemang.model.Agent;
import infs.Insurancemang.Insurancemang.model.Claim;
import infs.Insurancemang.Insurancemang.repo.ClaimRepository;
import infs.Insurancemang.Insurancemang.service.AgentService;
import infs.Insurancemang.Insurancemang.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin("*")
public class ClaimController {

    @Autowired
    private ClaimRepository claimRepository;

    private ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping
    public List<Claim> getAllClaim() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable String id) {
        return claimService.getClaimById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Claim createClaim(@RequestBody Claim claim) {
        return claimService.saveClaim(claim);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable String id, @RequestBody Claim claimDetails){
        return claimService.getClaimById(id)
                .map(existingClaim -> {
                    existingClaim.setId(claimDetails.getId());
                    existingClaim.setPolicyId(claimDetails.getPolicyId());
                    existingClaim.setCustomerId(claimDetails.getCustomerId());
                    existingClaim.setDateOfClaim((claimDetails.getDateOfClaim()));
                    existingClaim.setClaimAmount((claimDetails.getClaimAmount()));
                    existingClaim.setClaimStatus(claimDetails.getClaimStatus());
                    return ResponseEntity.ok(claimService.saveClaim(existingClaim));

                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClaim(@PathVariable String id){
        return claimService.getClaimById(id)
                .map(claim -> {
                    claimService.deleteClaim(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dashboard/totalClaims")
    public Long getTotalAgents() {
        return claimRepository.count();
    }


    @GetMapping("/statusCounts")
    public List<ClaimStatusCount> getClaimStatusCounts(){
        return claimService.getClaimStatusCounts();
    }



}
