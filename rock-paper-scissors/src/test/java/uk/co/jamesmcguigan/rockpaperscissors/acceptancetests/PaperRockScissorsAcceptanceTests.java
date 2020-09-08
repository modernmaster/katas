package uk.co.jamesmcguigan.rockpaperscissors.acceptancetests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",plugin = {"pretty", "html:target/cucumber","json:target/paper-rock-scissors.json"},glue = {"uk.co.jamesmcguigan" })
public class PaperRockScissorsAcceptanceTests  {

}
