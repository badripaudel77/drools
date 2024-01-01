package com.app.tracker.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
    private static final String drlFile_01 = "rules/CUSTOMER_USER_RULES.drl";
    private static final String drlFile_02 = "rules/DEMO_TEST.drl";
    private static final String drlFile_03 = "rules/utils/Utils.drl";
    private static final String drlFile_04 = "rules/DISEASES_RULE.drl";
    private static final String excelFile_05 = "rules/files/diseases.xls";
    private static final  KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        /*
         * Adding multiple rules to the working memory so that we can execute all of them. Rules must be registered.
         */
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile_01));
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile_02));
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile_03));
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile_04));
        kieFileSystem.write(ResourceFactory.newClassPathResource(excelFile_05));

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();

        KieContainer kieContainer =  kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }
}