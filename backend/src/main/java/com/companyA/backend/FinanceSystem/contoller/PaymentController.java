package com.companyA.backend.FinanceSystem.contoller;


import com.companyA.backend.FinanceSystem.model.Payment;
import com.companyA.backend.FinanceSystem.service.IDNotFoundException;
import com.companyA.backend.FinanceSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;



    @PostMapping("/salary")
    public ResponseEntity<Map<String, String>> EmployeeSalaryConfirmation(@RequestBody Payment payment) {
        paymentService.salaryPaymentConfirmation(payment);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee Salary is Successfully Deposited");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/sales")
    public ResponseEntity<Map<String, String>> SalesIncome(@RequestBody Payment payment) {
        paymentService.salesIncome(payment);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Payment is received");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }





}
