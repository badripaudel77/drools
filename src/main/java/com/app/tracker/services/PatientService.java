package com.app.tracker.services;

import com.app.tracker.models.Patient;
import com.app.tracker.utils.PatientUtil;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for Patient related operations
 * No transaction involved in this project.
 */
@Service
public class PatientService {

    private KieContainer kieContainer;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public PatientService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Transactional
    public void firePatientServiceRules() {
        logger.debug("<<< Firing rules for patients >>>");

        /**
         * The KieSession stores and executes on the runtime data. It is created from the KieBase.
         */
        KieSession kieSession = kieContainer.newKieSession();

        List<Patient> patientList = PatientUtil.getAllPatient();
        patientList.forEach( kieSession::insert);

        int firedCount = kieSession.fireAllRules();
        logger.info(firedCount + " {} objects fired.");

        kieSession.dispose();
    }
}
