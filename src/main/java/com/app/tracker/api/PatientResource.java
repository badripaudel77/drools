package com.app.tracker.api;

import com.app.tracker.services.PatientService;
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
public class PatientResource {
    @Autowired
    PatientService patientService;

    @GetMapping
    public ResponseEntity<?> fireAllRules() {
        System.out.println("<<< Firing rules >>>");

        patientService.firePatientServiceRules();

        return ResponseEntity.ok(
                Map.of("actionMessage", "Patients related drools rules were fired.")
        );
    }
}