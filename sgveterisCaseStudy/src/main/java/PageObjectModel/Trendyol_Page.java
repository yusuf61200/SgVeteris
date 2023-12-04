package PageObjectModel;

import Utilities.Driver;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Trendyol_Page extends AbstractClass{

    WebDriver driver;

    public Trendyol_Page(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptcookiesbutton;
    public void clickAcceptCookiesButton(){
        clickFunction(acceptcookiesbutton);
    }

    @FindBy(xpath = "//a[@id=\"logo\"]")
    public WebElement trendyolLogo;
    public void isHomePageOpened(){
        Assert.assertTrue(trendyolLogo.isDisplayed());
    }

    @FindBy(xpath = "//div[@class=\"link account-user\"]")
    public WebElement LoginButton;
    public void clickLoginButton(){
        clickFunction(LoginButton);
    }

    @FindBy(xpath = "//input[@id=\"login-email\"]")
    public WebElement email;
    public void sendEmail(){
        sendKeysFunction(email,"hjk");
    }
    @FindBy(xpath = "//input[@id=\"login-password-input\"]")
    public WebElement password;
    public void sendPassword(){
        sendKeysFunction(password,"123");
    }

    @FindBy(xpath = "//button[@class=\"q-primary q-fluid q-button-medium q-button submit\"]")
    public WebElement incloginButton;
    public void incClickLoginButton(){
        clickFunction(incloginButton);
    }

    @FindBy(xpath = "//input[@class=\"V8wbcUhU\"]")
    public WebElement searchbox;
    public void searchLaptop(){
        clickFunction(searchbox);
        sendKeysFunction(searchbox,"laptop");
    }

    @FindBy(xpath = "//i[@class=\"cyrzo7gC\"]")
    public WebElement searchButton;
    public void clickSearchButton(){
        clickFunction(searchButton);
    }

    @FindBy(xpath = "//div[@class=\"product-down\"]")
    public List<WebElement> randomListProduct;
    public void clickRandomProduct() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = SelectOnRandomItemInList(randomListProduct);
        scrollToElement(element);
        clickFunction(element);
    }



    @FindBy(xpath = "//div[@class=\"product-price-container\"]//div[@class=\"pr-bx-w\"]//div[@class=\"pr-bx-nm with-org-prc\"]")
    public WebElement randomProductPriceElement;
    public String showRandomProductPrice(){
        windowHandle();
        String randomProductPrice = randomProductPriceElement.getText();
        System.out.println("Random Product Price: " + randomProductPrice);
        return randomProductPrice;
    }

    public void priceAccept(String price){
        Assertion(basketItemPrice,price);
    }


    @FindBy(xpath = "//div[@class=\"pb-basket-item-price\"]")
    public WebElement basketItemPrice;
    public void showBasketItemPrice(){
        String basketPrice = basketItemPrice.getText();
        System.out.println("Basket Product Price: " + basketPrice);
    }



    @FindBy(xpath = "//div[@class=\"add-to-basket-button-text\"]")
    public WebElement addtoBasket;
    public void clickAddtoBasket() throws InterruptedException {
        Thread.sleep(1000);
        clickFunction(addtoBasket);
    }


    @FindBy(xpath = "//a[@class=\"link account-basket\"]")
    public WebElement basketButton;
    public void clickBasketButton(){
        clickFunction(basketButton);
    }

    @FindBy(xpath = "//button[text()='Anladım']")
    public WebElement understand;
    public void clickUnderstand(){
        clickFunction(understand);
    }

    @FindBy(xpath = "(//button[@class=\"ty-numeric-counter-button passive\"])[2]")
    public WebElement twoProduct;
    public void clickTwoProduct(){
        clickFunction(twoProduct);
    }

    @FindBy(xpath = "//input[@class=\"counter-content\"]")
    public WebElement numberofProduct;
    public void checkProductnumber(){
        Assertion(numberofProduct,"2");
    }

    @FindBy(xpath = "//i[@class=\"i-trash\"]")
    public WebElement clearElement;
    public void clickClearElement(){
        clickFunction(clearElement);
    }

    @FindBy(xpath = "//p[@class=\"pb-item\"]")
    public WebElement basketcheck;
    public String showBasketDetails(){
        String basketdetail = basketcheck.getText();
        return basketdetail;
    }

    @FindBy(xpath = "//p[text()=' ürünü sepetinden kaldırıldı.']")
    public WebElement expected;

    public void isClearBasket(String expected){
        Assertion(basketcheck,expected);
        System.out.println("The basket has been successfully cleared.");
    }


}
