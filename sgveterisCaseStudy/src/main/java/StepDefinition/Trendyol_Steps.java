package StepDefinition;

import PageObjectModel.Trendyol_Page;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Trendyol_Steps {

    private WebDriver driver;

    Trendyol_Page Trendyol_Page=new Trendyol_Page();

    @Given("Go to Trendyol website")
    public void go_to_trendyol_website() {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Given("Check that the main page is opened")
    public void check_that_the_main_page_is_opened() {
        Trendyol_Page.clickAcceptCookiesButton();
        Trendyol_Page.isHomePageOpened();
    }
    @Given("Attempts are made to log in to the site with incorrect information.")
    public void attempts_are_made_to_log_in_to_the_site_with_incorrect_information() {
        Trendyol_Page.clickLoginButton();
        Trendyol_Page.sendEmail();
        Trendyol_Page.sendPassword();
        Trendyol_Page.incClickLoginButton();
    }
    @Given("The word {string} is entered in the search box.")
    public void the_word_is_entered_in_the_search_box(String string) {
        Trendyol_Page.searchLaptop();
        Trendyol_Page.clickSearchButton();
    }
    @Given("According to the result, a random product is selected from the products")
    public void according_to_the_result_a_random_product_is_selected_from_the_products() throws InterruptedException {
        Trendyol_Page.clickRandomProduct();
    }
    @Given("The selected product is added to the cart")
    public void the_selected_product_is_added_to_the_cart() throws InterruptedException {
        String Rprice = Trendyol_Page.showRandomProductPrice();
        Trendyol_Page.clickAddtoBasket();
        Trendyol_Page.clickBasketButton();
        Trendyol_Page.clickUnderstand();
        Trendyol_Page.showBasketItemPrice();
        Trendyol_Page.priceAccept(Rprice);
    }
    @Given("Compared to the price of the product before adding it to the cart")
    public void compared_to_the_price_of_the_product_before_adding_it_to_the_cart() {

    }
    @Given("Increase the number of product in the basket to two and check its accuracy")
    public void increase_the_number_of_product_in_the_basket_to_two_and_check_its_accuracy() {
        //Trendyol_Page.clickTwoProduct();
        //Trendyol_Page.checkProductnumber();
    }
    @When("All items in the cart are deleted")
    public void all_items_in_the_cart_are_deleted() {
        Trendyol_Page.clickClearElement();
    }
    @Then("Check that the basket is clean")
    public void check_that_the_basket_is_clean() {
        String basketDetail = Trendyol_Page.showBasketDetails() + " ürünü sepetinden kaldırıldı.";
        System.out.println("basket: "+ basketDetail);
        String expected = Trendyol_Page.expected.getText();
        System.out.println("clear basket: " + expected);
        Trendyol_Page.isClearBasket(expected);
    }

}
