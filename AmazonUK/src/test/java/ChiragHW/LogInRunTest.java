package ChiragHW;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:output"},
        tags = {"@MyTest"},
        features = "src/test/resources/AmazonUKLogIn.Feature")
public class LogInRunTest extends Hooks {
}
