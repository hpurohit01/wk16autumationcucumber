package com.automationpractice.cucumber.steps;

import com.automationpractice.pages.*;
import com.automationpractice.utility.Utility;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

public class Steps {
    @Given("^I hover mouse to \"([^\"]*)\"$")
    public void iHoverMouseTo(String menu) {
       // new HomePage().hoverMouseToMenu(menu);
    }

    @When("^I hover mouse and click on submenu \"([^\"]*)\"$")
    public void iHoverMouseAndClickOnSubmenu(String subMenu) {
        //new HomePage().hoverMouseAndClickOnSubMenu(subMenu);
    }

    @Then("^I verify if heading of page is \"([^\"]*)\"$")
    public void iVerifyIfHeadingOfPageIs(String expectedText) {
        new SummerDressesPage().verifyHeadingText(expectedText);
    }

    @And("^I change the price range on slider of max price to \"([^\"]*)\"$")
    public void iChangeThePriceRangeOnSliderOfMaxPriceTo(String setMaxPrice) {
        new SummerDressesPage().setSliderPriceTo(setMaxPrice);
    }

    @Then("^I verify if search results are priced withing the max price range \"([^\"]*)\"$")
    public void iVerifyIfSearchResultsArePricedWithingTheMaxPriceRange(String setMaxPrice) {
        new SummerDressesPage().verifyIfListedProductsAreWithInSelectedPriceRange(setMaxPrice);
    }

    @Given("^I select menu \"([^\"]*)\"$")
    public void iSelectMenu(String menu) {
        //new HomePage().selectMenu(menu);
    }

    @When("^I click on selected product \"([^\"]*)\"$")
    public void iClickOnSelectedProduct(String product) {
        new DressesPage().selectProduct(product);
    }

    @And("^I click on add to cart button$")
    public void iClickOnAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @And("^I click on proceed to checkout button$")
    public void iClickOnProceedToCheckoutButton() {
        new ProductPage().clickOnProceedToCheckoutButton();
    }

    @And("^I verify product is added to shopping cart$")
    public void iVerifyProductIsAddedToShoppingCart() throws InterruptedException {
        new ShoppingCartPage().verifyNumberOfProducts();
        Thread.sleep(2000);
    }

    @And("^I verify if delete button is available in shopping cart$")
    public void iVerifyIfDeleteButtonIsAvailableInShoppingCart() throws InterruptedException {
        new ShoppingCartPage().verifyDeleteButtonIsAvailable();
        Thread.sleep(2000);
    }

    @And("^I click on delete button$")
    public void iClickOnDeleteButton() throws InterruptedException {
        new ShoppingCartPage().clickOnDeleteButton();
        Thread.sleep(3000);
    }

    @Then("^I verify banner message \"([^\"]*)\"$")
    public void iVerifyBannerMessage(String expectedMessage) {
        new ShoppingCartPage().verifyMessageOfShoppingCartIsEmpty(expectedMessage);
    }

    @When("^I click on information link \"([^\"]*)\"$")
    public void iClickOnInformationLink(String infoLink) {
        new HomePage().selectInformation(infoLink);
    }

    @Then("^I am able to drag map to Palm Beach Location and take screenshot$")
    public void iAmAbleToDragMapToPalmBeachLocationAndTakeScreenshot() throws InterruptedException {
        new OurStoresPage().clickOKFromAlert();
        new OurStoresPage().getXandYpoints();
        new OurStoresPage().dragMapToTarget();
        Thread.sleep(3000);
        Utility.takeScreenShot();
    }

    @Given("^I click on sign in link$")
    public void iClickOnSigningLink() {
       // new HomePage().clickOnSigningLink();
    }

    @When("^I enter email for create account$")
    public void iEnterEmailForCreateAccount() {
        new SignInPage().fillInEmailToCreateAccount();
    }

    @And("^I click on create new account button$")
    public void iClickOnCreateNewAccountButton() {
        new SignInPage().clickOnCreateAccountButton();
    }

    @And("^I enter below details in the form$")
    public void iEnterBelowDetailsInTheForm(DataTable dataTable) {
        // here we use List of Map since we have headings in datatable in feature file
        List<Map<String, String>> form = dataTable.asMaps(String.class, String.class);
        String fName = form.get(0).get("firstName");
        String lName = form.get(0).get("lastName");
        String pass = form.get(0).get("password");
        String add = form.get(0).get("address");
        String cty = form.get(0).get("city");
        String st = form.get(0).get("state");
        String post = form.get(0).get("postal");
        String ctry = form.get(0).get("country");
        String ph = form.get(0).get("phone");

        new CreateAccountPage().enterYourFirstName(fName);
        new CreateAccountPage().enterYourLastName(lName);
        new CreateAccountPage().enterYourPassword(pass);
        new CreateAccountPage().enterYourAddress(add);
        new CreateAccountPage().enterYourCity(cty);
        new CreateAccountPage().selectYourState(st);
        new CreateAccountPage().enterYourPostalCode(post);
        new CreateAccountPage().selectYourCountry(ctry);
        new CreateAccountPage().enterYourPhoneNumber(ph);
    }

    @And("^I click on register button$")
    public void iClickOnRegisterButton() {
        new CreateAccountPage().clickOnRegisterButton();
    }

    @Then("^I verify account name \"([^\"]*)\"$")
    public void iVerifyAccountName(String firstName) {
        new MyAccountPage().verifyAccountNameText(firstName);
    }

    @Then("^I verify the error message displayed which contains \"([^\"]*)\"$")
    public void iVerifyTheErrorMessageDisplayedWhichContains(String expectedText) {
        new CreateAccountPage().verifyErrorMessageDisplayed(expectedText);

    }

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
    }

    @And("^I fill the form using one method$")
    public void iFillTheFormUsingOneMethod() {
    }

    @When("^I login using newly created credentials$")
    public void iLoginUsingNewlyCreatedCredentials() {
    }

    @Then("^I shall verify the address information in my address section$")
    public void iShallVerifyTheAddressInformationInMyAddressSection() {
    }
}