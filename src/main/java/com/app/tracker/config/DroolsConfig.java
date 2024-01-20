package com.app.tracker.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Arrays;

@Configuration
public class DroolsConfig {
    private static final String drlFile_01 = "rules/01_PATIENT_RULES.drl";
    private static final String drlFile_02 = "rules/02_COMPANY_RULES.drl";

    private static final String drlFilesPathPrefix = "rules/";

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
        //kieFileSystem.write(ResourceFactory.newFileResource(drlFile_01));
        // kieFileSystem.write(ResourceFactory.newFileResource(drlFile_02));

        // Directory of the rule files located.
        File dir = new File("src/main/resources/rules");
        // Just filter the file that has name rules with .drl extension.
        File[] ruleFiles = dir.listFiles( file -> file.getName().contains(".drl"));
        Arrays.stream(ruleFiles)
              .forEach( file -> kieFileSystem.write(ResourceFactory.newFileResource(file)));

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();

        KieContainer kieContainer =  kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }
}