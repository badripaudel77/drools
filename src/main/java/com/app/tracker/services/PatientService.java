package com.app.tracker.services;

import com.app.tracker.models.Patient;
import com.app.tracker.utils.EventListenerUtil;
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

        // Add global so it can be accessed from other places. Here PatientService i.e this is set as a global so that it can be used  to invoke
        // methods in this service.
        kieSession.setGlobal("patientService", this);

        // Attach event listeners to kieSession and check the triggered events

        // 1. Attaching DefaultAgendaEventListener
        EventListenerUtil.attachDefaultAgendaEventListener(kieSession);

        // 2. Attaching RuleRuntimeEventListener
        EventListenerUtil.attachRuleRunTimeListener(kieSession);

        // 2. Attaching ProcessEventListener
        EventListenerUtil.attachProcessEventListener(kieSession);

        int firedCount = kieSession.fireAllRules();
        logger.info(firedCount + " {} objects fired.");

        kieSession.dispose();
    }

    public void logTheMessage() {
        this.logger.info("Logging from the service to inspect the code.");
    }
}
