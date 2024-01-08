package com.app.tracker.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
    private static final String drlFile_01 = "rules/PATIENT_RULES.drl";

    /**
     * Using the KieServices, we can access a number of factories, services, and utility
     * methods used along with Rule Engine instances. We will use KieServices to create a
     * new instance of KieContainer, which defines the scope of the rules that will be used
     * to create new instances of the Rule Engine
     */
    private static final  KieServices kieServices = KieServices.Factory.get();

    /**
     * The KieBase is a repository of all the application's knowledge definitions.
     * It will contain rules, processes, functions, and type models.
     * The KieBase itself does not contain data; instead, sessions are created from the KieBase into which data can be inserted and from which process instances may be started.
     * The KieBase can be obtained from the KieContainer containing the KieModule where the KieBase has been defined.
     */
    @Bean
    public KieContainer kieContainer() {

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        /*
         * Adding multiple rules to the working memory so that we can execute all of them. Rules must be registered.
         */
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile_01));

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();

        KieContainer kieContainer =  kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }
}