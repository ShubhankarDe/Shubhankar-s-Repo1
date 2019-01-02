package com.automation.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/Feature1.feature"},
				 plugin = { 
						    "html:target/cucumber-html-report",
						    "json:target/cucumber.json"
						        },
				 glue ={"com/automation/test"},strict = true,
				   dryRun= true,monochrome = true, snippets= SnippetType.CAMELCASE)
		
		  
		
public class RunnerTest {
		

		
	 

}
