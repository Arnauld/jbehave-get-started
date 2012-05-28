package bdd101.calculator;

import static bdd101.calculator.CalculatorContext.calculator;
import static bdd101.calculator.CalculatorContext.context;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import bdd101.util.StepsDefinition;

@StepsDefinition
public class CalculatorSteps {
    
    @BeforeScenario
    public void inializeScenario() {
        CalculatorContext.initialize();
    }

    @AfterScenario
    public void disposeScenario() {
        CalculatorContext.dispose();
    }
    
    @Given("a variable $variable with value $value")
    public void defineNamedVariableWithValue(String variable, int value) {
        calculator().defineVariable(variable, value);
    }

    @When("I add $value to $variable")
    public void addValueToVariable(@Named("variable") String variable, 
                                   @Named("value")String value) {
        try {
            if(value.matches("\\d+")) {
                calculator().addToVariable(variable, Integer.parseInt(value));
            }
            else {
                calculator().addToVariable(variable, value);
            }
        } catch (Exception e) {
            context().setLastError(e);
        }
    }

    @Then("$variable should equal to $expected")
    public void assertVariableEqualTo(String variable, int expectedValue) {
        assertThat(calculator().getVariableValue(variable), equalTo(expectedValue));
    }
    
    @Then("the calculator should display the message '$errorMessage'")
    public void assertErrorMessageIsDisplayed(String errorMessage) {
        Exception lastError = context().getLastError();
        assertThat("Not in error situtation", lastError, notNullValue());
        assertThat("Wrong error message", lastError.getMessage(), equalTo(errorMessage));
    }
}
