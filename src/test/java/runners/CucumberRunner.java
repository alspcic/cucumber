package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Sample1.feature",
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
//        tags = {"~@not_working", "~@bug"},
//        tags = {"@part1"},
//        tags = {"~@not_working", "@part1", "~@bug"}, // => NOT @not_working AND @part1 AND NOT @bug
//        tags = {"@part3", "@regression"}, //=> @part3 AND @regression
//        tags = {"@part3, @regression"}, //=> @part3 OR @regression
        glue = {"stepDefinitions"}
)
public class CucumberRunner {

}
