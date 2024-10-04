package com.project.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resource/feature/login" ,
    glue ={"com.project.stepdefinitions","com.project.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome=true
)



public class TestRunner extends AbstractTestNGCucumberTests {
    
}
