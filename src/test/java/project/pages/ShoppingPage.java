package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.utilities.Driver;


public class ShoppingPage {
    public ShoppingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
         }

        @FindBy(id = "user-name")
        public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement login;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpack;

    @FindBy(xpath = "//span[.='1']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']")
    public WebElement CorrectItemBackpack;

    @FindBy(id = "checkout")
    public WebElement checkout;

    @FindBy(xpath = "//span[.='Your Cart']")
    public WebElement cartPage;

    @FindBy(xpath = "(//input[@autocorrect='off'])[1]")
    public WebElement firstName;

    @FindBy(xpath = "(//input[@autocorrect='off'])[2]")
    public WebElement lastName;

    @FindBy(xpath = "(//input[@autocorrect='off'])[3]")
    public WebElement zipcode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement FinishedButton;

    @FindBy(xpath = "//span[.='Checkout: Overview']")
    public WebElement reviewOrder;

    @FindBy(xpath = "//h2[.='THANK YOU FOR YOUR ORDER']")
    public WebElement orderCompleted;
}


