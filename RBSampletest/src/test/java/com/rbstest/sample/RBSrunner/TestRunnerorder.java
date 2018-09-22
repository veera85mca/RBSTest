package com.rbstest.sample.RBSrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(tags={"@Order, @personalinfo"},format={"pretty","html:reports","json:Orderjson\\order.json"},features={"classpath:Feature"},glue={"com.rbstest.sample.RBStest"})
@RunWith(Cucumber.class)

public class TestRunnerorder {

}
