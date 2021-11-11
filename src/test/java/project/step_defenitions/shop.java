package project.step_defenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import project.pages.ShoppingPage;
import project.utilities.ConfigurationReader;
import project.utilities.Driver;

import java.util.List;

public class shop {

    ShoppingPage shoppingPage = new ShoppingPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("sauseDemo");
        Driver.getDriver().get(url);

    }

    @When("user enters the username {string} and password {string}")
    public void user_enters_the_username_and_password(String username, String password) {
        shoppingPage.username.sendKeys(username);
        shoppingPage.password.sendKeys(password);

    }

    @When("user click on the login button")
    public void user_click_on_the_login_button() {
        shoppingPage.login.click();
    }

    @Then("user should see the {string} page")
    public void userShouldSeeThePage(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedPageTitle = expectedTitle;

        Assert.assertTrue(actualTitle.contains(expectedPageTitle));
    }

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        System.out.println("User on the home page");
    }

    @When("user click on add to cart button near chosen item")
    public void userClickOnAddToCartButtonNearChosenItem() {
        shoppingPage.backpack.click();
    }

    @And("user click on the view card button")
    public void userClickOnTheViewCardButton() {
        shoppingPage.viewCartButton.click();
    }

    @Then("user should be able to see correct item in the cart")
    public void userShouldBeAbleToSeeCorrectItemInTheCart() {
        String actualItem = shoppingPage.CorrectItemBackpack.getText();
        String expectedItem = "Sauce Labs Backpack";

        Assert.assertTrue(actualItem.contains(expectedItem));

    }

    @Given("user on the cart page")
    public void user_on_the_cart_page() {
        String actualCartPageTitle = shoppingPage.cartPage.getText();
        String expectedCartPageTitle = "YOUR CART";

        Assert.assertTrue(actualCartPageTitle.contains(expectedCartPageTitle));

    }

    @When("user click on checkout button")
    public void userClickOnCheckoutButton() {
        shoppingPage.checkout.click();

        }
        @When("user fill in {string}, {string}  and {string} fields")
        public void user_fill_in_and_fields(String firstName, String lastName, String zipCode) throws InterruptedException {
           shoppingPage.firstName.sendKeys(firstName);
           Thread.sleep(3);
           shoppingPage.lastName.sendKeys(lastName);
            Thread.sleep(3);
           shoppingPage.zipcode.sendKeys(zipCode);
        }



    @And("user click on continue button")
    public void userClickOnContinueButton() {
        shoppingPage.continueButton.click();
    }

    @And("user should be able to review order and click finish button")
    public void userShouldBeAbleToReviewOrderAndClickFinishButton() {
        String actualReviewPageTitle = shoppingPage.reviewOrder.getText();
        String expectedReviewPageTitle = "CHECKOUT: OVERVIEW";

        Assert.assertTrue(actualReviewPageTitle.contains(expectedReviewPageTitle));
        shoppingPage.FinishedButton.click();


    }
        @Then("user should be able to complete the order")
        public void user_should_be_able_to_complete_the_order() {
        String actualComplete = shoppingPage.orderCompleted.getText();
        String expectedComplete = "THANK YOU FOR YOUR ORDER";

    }
}


