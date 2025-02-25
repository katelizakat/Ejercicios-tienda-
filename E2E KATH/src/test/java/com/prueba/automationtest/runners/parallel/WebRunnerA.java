package com.prueba.automationtest.runners.parallel;

import com.prueba.automationtest.runners.WebRunnerTest;
import com.prueba.automationtest.util.AfterSuite;
import com.prueba.automationtest.util.BeforeSuite;
import com.prueba.automationtest.util.ControlParallel;
import com.prueba.automationtest.util.CustomCucumberWithSerenityRunner;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.awaitility.Awaitility.await;

@Slf4j
@RunWith(CustomCucumberWithSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.prueba.automationtest.hooks", "com.prueba.automationtest.glue"},
        plugin = "json:build/cucumberreportstest/cucumberParallel1.json",
        tags = "@R1 and not @karate and not @API and not @ManualTest and not @Mobiletest and not @smokeTest"
)

public class WebRunnerA {

    private WebRunnerA() {
    }

    private static final String RUNNER = "Runner1";

    @BeforeSuite
    public static void init() throws IOException {
        WebRunnerTest.init();
        ControlParallel.setOrRemoveExecution("add");
        log.info("Inicia " + RUNNER);
    }


    @AfterSuite
    public static void after() throws IOException {
        await().atMost(60, MINUTES).until(ControlParallel.featuresOverwritten(RUNNER));
        WebRunnerTest.after();
        ControlParallel.setOrRemoveExecution("delete");
        String reportsOutputPath = "build/cucumberreportstest/";
        String jsonResumePath = "./build/cucumber-reports/json";
        String nameJsonReport = "cucumber.json";
        GenerateUnifiedReport.generateReport(reportsOutputPath, jsonResumePath, nameJsonReport);
        log.info("Termina " + RUNNER);
    }

}