package com.academy.techcenture.stop_definitions;

import com.academy.techcenture.config.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.academy.techcenture.driver.Driver.getDriver;

public class NopCommerLoginStepDefinitions {

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
       getDriver().get(ConfigReader.getProperty("url"));
       String actualTitle = getDriver().getTitle();
        Assert.assertEquals("Home page titles do not match", actualTitle, "nopCommerce demo store");
    }
    @When("user clicks on login link")
    public void user_clicks_on_login_link() {
        WebElement loginLink = getDriver().findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        Assert.assertTrue("Login link is not displayes", loginLink.isDisplayed());
        loginLink.click();
    }
    @Then("user should be navigate to login page")
    public void user_should_be_navigate_to_login_page() {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("Login page titles do not match", actualTitle, "nopCommerce demo store. Login");
        WebElement loginHeader = getDriver().findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        Assert.assertTrue("Login Header is not displayed", loginHeader.isDisplayed());
    }
    @When("user uses login credentials {string} and {string} and clicks on login button")
    public void user_uses_login_credentials_and_and_clicks_on_login_button(String username, String password) {
        WebElement emailInput = getDriver().findElement(By. id("Email"));
        emailInput.sendKeys(username);
        WebElement passwordInput = getDriver().findElement(By.id("Password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = getDriver().findElement(By.xpath("//button[contains(@class,'login-button')]"));
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();
    }
    @Then("Then user should see my account and logout links on top")
    public void Then_user_should_see_my_account_and_logout_links_on_top() {
        WebElement myAccountLink = getDriver().findElement(By.linkText("My account"));
        Assert.assertTrue(myAccountLink.isDisplayed());
        WebElement logoutLink = getDriver().findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutLink.isDisplayed());
    }

    @Then("user should see error {string}")
    public void userShouldSeeError(String errorMessage) {
        WebElement error = getDriver().findElement(By.xpath("//div[contains(@class,'validation-summary-errors')]"));
        Assert.assertTrue(error.isDisplayed());
        String actualErrorMessage = error.getText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue(actualErrorMessage.contains(errorMessage));
    }

    @And("user logs out from their account")
    public void userLogsOutFromTheirAccount(){
        WebElement logoutLink = getDriver().findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutLink.isDisplayed());
        logoutLink.click();
    }


}
