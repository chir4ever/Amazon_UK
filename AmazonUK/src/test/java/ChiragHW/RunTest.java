package ChiragHW;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:output"},
      //  tags = {"@SRIRAM"},
        tags = {"@Test"},
       // tags = {"@FirstTestOnly"},
        //features = "src/test/resources/"
        features = "/Users/Bhulku/AmazonUK/src/test/resources/GmailLogin.feature"
)
public class RunTest extends Hooks {
}
