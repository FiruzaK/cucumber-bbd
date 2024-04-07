package com.academy.techcenture.stop_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.academy.techcenture.driver.Driver.getDriver;

public class NopCommerceUserRegistrationStepDefination {
    @Then("user should be able to see register button and click it")
    public void user_should_be_able_to_see_register_button_and_click_it() {
        WebElement registerBtn = getDriver().findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button"));
        Assert.assertTrue(registerBtn.isEnabled());
        registerBtn.click();
    }
    @Then("user should be navigate to register page")
    public void user_should_be_navigate_to_register_page() {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("nopCommerce demo store. Register", actualTitle);
        WebElement registerHeader = getDriver().findElement(By.tagName("h1"));
        Assert.assertTrue(registerHeader.isDisplayed());
    }
    @Then("user clicks on gender as {string}")
    public void user_clicks_on_gender_as(String gender) {
        getDriver().findElement(By.id("gender-" + gender)).click();
    }
    @Then("user enter {string} for firstname")
    public void user_enter_for_firstname(String firstname) {
        getDriver().findElement(By.id("FirstName")).sendKeys(firstname);
    }
    @Then("user enter {string} for lastname")
    public void user_enter_for_lastname(String lastName) {
        getDriver().findElement(By.id("LastName")).sendKeys(lastName);
    }
    @Then("user enters {string}, {string}, {string} for dob")
    public void user_enters_for_dob(String day, String month, String  year) {
       Select selectday = new Select(getDriver().findElement(By.name("DateOfBirthDay")));
       Select selectMonth = new Select(getDriver().findElement(By.name("DateOfBirthMonth")));
       Select selectYear = new Select(getDriver().findElement(By.name("DateOfBirthYear")));

       selectday.selectByVisibleText(String.valueOf(day));
       selectMonth.selectByVisibleText(month);
       selectYear.selectByVisibleText(String.valueOf(year));

    }
    @Then("user enters {string}")
    public void user_enters(String email) {
        getDriver().findElement(By.id("Email")).sendKeys(email);

    }
    @Then("user enters {string} for company")
    public void user_enters_for_company(String companyName) {
        getDriver().findElement(By.id("Company")).sendKeys(companyName);

    }
    @Then("user {string} newsletter checkbox")
    public void user_newsletter_checkbox(String checks) {
        WebElement newsletterCheckbox = getDriver().findElement(By.id("Newsletter"));
        if (checks.equals("checks")){
            if (!newsletterCheckbox.isSelected()){
                newsletterCheckbox.click();
            }
        } else if (checks.equals("unchecks")) {
            if (newsletterCheckbox.isSelected()){
                newsletterCheckbox.click();
            }
        }
    }
    @Then("users enters {string} for password input")
    public void users_enters_for_password_input(String password) {
        getDriver().findElement(By.id("Password")).sendKeys(password);

    }
    @Then("user enters {string} for confirm password input")
    public void user_enters_for_confirm_password_input(String confirmPassword) {
        getDriver().findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        WebElement registerButton = getDriver().findElement(By.xpath("//*[@id=\"register-button\"]"));
        Assert.assertTrue(registerButton.isEnabled());
        registerButton.click();
    }
    @Then("user should see {string} success message")
    public void user_should_see_success_message(String successMessage) {
        WebElement confirmationMessage = getDriver().findElement(By.className("result"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
        Assert.assertEquals(successMessage, confirmationMessage.getText());
    }
    @When("user clicks on continue button")
    public void user_clicks_on_continue_button() {
        WebElement continueBtn = getDriver().findElement(By.xpath("//a[text()='Continue']"));
        Assert.assertTrue(continueBtn.isEnabled());
        continueBtn.click();
    }
    @And(("user checks if they can log in with newly created credentials {string} and {string}"))
    public void userChecksIfTheyCanLogInWithNewlyCreatedCredentialsAnd(String username, String password){
        try{
            WebElement logInLink = getDriver().findElement(By.linkText("Log in"));
            logInLink.click();

        }catch (Exception e){
            WebElement logOutLink = getDriver().findElement(By.linkText("Log out"));
            logOutLink.click();
        }
        login(username, password);
    }


    private static void login(String username, String password) {
        WebElement logInLink = getDriver().findElement(By.linkText("Log in"));
        logInLink.click();

        WebElement emailInput = getDriver().findElement(By. id("Email"));
        emailInput.sendKeys(username);
        WebElement passwordInput = getDriver().findElement(By.id("Password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = getDriver().findElement(By.xpath("//button[contains(@class,'login-button')]"));
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();
    }
//    @Then("user should see my account and logout links on top")
//    public void user_should_see_my_account_and_logout_links_on_top() {
//
//    }

}
