package Steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ("src/test/resources/features/Login.feature"), glue = {
		"Steps" }, monochrome = true, plugin = { "pretty", "html:target/HTML/htmlreport", "json:target/JSON/jsonreport",
				"junit:target/XML/xmlreport" }, tags = "@FirstTestSenario"
				)

public class runner {

}
