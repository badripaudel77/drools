package com.app.tracker.services;

import com.app.tracker.models.CustomerUser;
import com.app.tracker.models.Disease;
import com.app.tracker.models.TestClaim;
import com.app.tracker.utils.CustomerUserUtil;
import com.app.tracker.utils.DiseasesUtil;
import com.app.tracker.utils.TestClaimUtil;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Service for Customer user related operations
 * No transaction involved in this project.
 */
@Service
public class CustomerUserService {

    private KieContainer kieContainer;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomerUserService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Transactional
    public void fireCustomerUserRules() {
        logger.debug("<<< Firing rules for customer user >>>");
        KieSession kieSession = kieContainer.newKieSession();

        /**
         * In a stateless KIE session configuration, the execute() call acts as a combination method that instantiates the KieSession object,
         * adds all the user data and executes user commands, calls fireAllRules(), and then calls dispose(). Therefore, with a stateless KIE session,
         * you do not need to call fireAllRules() or call dispose() after session invocation as you do with a stateful KIE session.
         * REF : https://docs.drools.org/7.74.1.Final/drools-docs/html_single/index.html#project-deployment-options-ref_decision-management-architecture
         */
        // StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession();

        List<CustomerUser> customerUserList = CustomerUserUtil.getAllCustomerUsers();
        customerUserList.forEach( kieSession::insert);

        List<TestClaim> testClaims = TestClaimUtil.getAllTestClaim();
        testClaims.forEach(kieSession::insert);

        List<Disease> testDiseases = DiseasesUtil.getAllDiseases();
        testDiseases.forEach(kieSession::insert);

        /**
         * When we want to fire all the rules ending with String second, we can achieve this way.
         */
        // int firedCount = kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("second"));
        int firedCount = kieSession.fireAllRules();

        try {
            List<String> usernames = Arrays.asList("barricade77", "john", "smith123");
            kieSession.getGlobals().set("usernames", usernames);
        }
        catch (Exception e) {
            logger.error("Error while setting global >>> " + e.getMessage());
        }
        logger.info(firedCount + " {} objects fired.");
        kieSession.dispose();
    }
}
