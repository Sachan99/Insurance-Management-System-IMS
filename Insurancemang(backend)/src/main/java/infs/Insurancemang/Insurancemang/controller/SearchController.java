package infs.Insurancemang.Insurancemang.controller;

import infs.Insurancemang.Insurancemang.DTO.*;
import infs.Insurancemang.Insurancemang.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@CrossOrigin("*")
public class SearchController {


    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    //Find All Payments Along with Customer and Policy Details.
    @GetMapping("/payments")
    public ResponseEntity<List<CustomerPaymentPolicyDTO>> findAllPaymentsWithCustomerAndPolicy() {
        List<CustomerPaymentPolicyDTO> results = searchService.findAllPaymentsWithCustomerAndPolicy();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/late-payments")
    public ResponseEntity<List<LatePaymentDTO>> getLatePayments(
            @RequestParam String policyType,
            @RequestParam String latePayment) {
        List<LatePaymentDTO> latePayments = searchService.findLatePaymentsWithDetails(policyType, latePayment);
        return ResponseEntity.ok(latePayments);
    }

    @GetMapping("/high-value")
    public ResponseEntity<List<HighValueClaimsDTO>> getHighValueClaims(
            @RequestParam(defaultValue = "2000") double claimAmountThreshold) {

        List<HighValueClaimsDTO> highValueClaims = searchService.findHighValueClaims(claimAmountThreshold);
        return ResponseEntity.ok(highValueClaims);
    }


    @GetMapping("/by-agent")
    public ResponseEntity<List<ClaimsByAgentDTO>> getClaimsByAgent(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        List<ClaimsByAgentDTO> claims = searchService.findClaimsByAgent(firstName, lastName);
        return ResponseEntity.ok(claims);
    }








}
