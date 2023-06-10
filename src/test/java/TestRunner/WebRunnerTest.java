package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features"},
        tags = "@test",
        glue = {"WebStepDefination"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/webFeature.html"
        })

@Test
public class WebRunnerTest extends AbstractTestNGCucumberTests {


}
