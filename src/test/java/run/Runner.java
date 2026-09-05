package run;

import baseTest.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = CucumberOptions.SnippetType.CAMELCASE, features = "src/test/resources/features", glue = "steps", publish = true, stepNotifications = true,tags = "@sauce_demo")
public class Runner extends BaseTest {

}
