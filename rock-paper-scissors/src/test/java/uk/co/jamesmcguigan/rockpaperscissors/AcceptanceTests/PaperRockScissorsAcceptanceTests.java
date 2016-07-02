package uk.co.jamesmcguigan.rockpaperscissors.AcceptanceTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".",format = {"pretty", "html:target/cucumber","json:target/paper-rock-scissors.json"},glue = {"uk.co.jamesmcguigan" })
public class PaperRockScissorsAcceptanceTests  {

}
