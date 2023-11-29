package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="StepDefinitions", monochrome=true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
