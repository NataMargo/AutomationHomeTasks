package cucumber_practice;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
        (features = "src/test/features",
                glue = {"Steps"})
                    /*
                   tags = "@cucumberLinkedin",
                    dryRun = false,
                    strict = false,
                     snippets = CucumberOptions.SnippetType.CAMELCASE)
                   */

public class Runner {
}




