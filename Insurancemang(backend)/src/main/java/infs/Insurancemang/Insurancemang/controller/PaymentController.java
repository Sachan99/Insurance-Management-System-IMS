package infs.Insurancemang.Insurancemang.controller;

import infs.Insurancemang.Insurancemang.DTO.MonthlyPayment;
import infs.Insurancemang.Insurancemang.model.Payment;
import infs.Insurancemang.Insurancemang.repo.PaymentRepository;
import infs.Insurancemang.Insurancemang.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable String id, @RequestBody Payment paymentDetails) {
        return paymentService.getPaymentById(id)
                .map(existingPayment -> {
                    existingPayment.setPolicyId(paymentDetails.getPolicyId());
                    existingPayment.setCustomerId(paymentDetails.getCustomerId());
                    existingPayment.setPaymentDate(paymentDetails.getPaymentDate());
                    existingPayment.setAmountPaid(paymentDetails.getAmountPaid());
                    existingPayment.setIsLatePayment(paymentDetails.getIsLatePayment());
                    return ResponseEntity.ok(paymentService.savePayment(existingPayment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable String id) {
        return paymentService.getPaymentById(id)
                .map(payment -> {
                    paymentService.deletePayment(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/monthly")
    public Map<String, Double> getDataMonthly() {
        return paymentService.getMonthlyPremiums();
    }



}
