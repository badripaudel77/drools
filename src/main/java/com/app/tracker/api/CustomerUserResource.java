package com.app.tracker.api;

import com.app.tracker.services.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * API (resources) related to customer user operations
 */
@RestController
@RequestMapping("")
public class CustomerUserResource {
    @Autowired
    CustomerUserService customerUserService;

    @GetMapping
    public ResponseEntity<?> fireAllRules() {
        System.out.println("<<< Firing rules >>>");

        customerUserService.fireCustomerUserRules();

        return ResponseEntity.ok(
                Map.of("actionMessage", "Customer User related drools rules were fired.")
        );
    }
}