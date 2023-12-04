package PageObjectModel;

import Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class AbstractClass {

    private WebDriver driver = Driver.getDriver();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));


    public void clickFunction(WebElement clickElement){
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void clickFunction(By by){

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public void sendKeysFunction(WebElement sendKeysElement,String value){

        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }

    public void Assertion(WebElement actual,String expected){

        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(expected,actual.getText());
        System.out.println("Prices verified.");
    }

    public void Assertion(WebElement actual,WebElement expected){
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(expected.getText(),actual.getText());
        System.out.println("Expected: " + expected.getText());
        System.out.println("Actual: " + actual.getText());
        System.out.println("Prices verified.");
    }

    public void Assertion(String actual,WebElement expected){
        wait.until(ExpectedConditions.visibilityOf(expected));
        Assert.assertEquals(expected.getText(),actual);
        System.out.println("Prices verifed.");
    }





    public void EnterKeys(WebElement EnterElement){

        wait.until(ExpectedConditions.visibilityOf(EnterElement));
        EnterElement.sendKeys(Keys.ENTER);
    }

    public void selectDropDown(WebElement element, String selectText) {

        Select items = new Select(element);
        items.selectByVisibleText(selectText);
    }

    public void scrollToElement(WebElement iframe){

        wait.until(ExpectedConditions.visibilityOf(iframe));
        Actions actions = new Actions(driver);
        actions.scrollToElement(iframe).perform();

    }

    public Boolean isDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void MoveToElement(WebElement toElement){

        wait.until(ExpectedConditions.visibilityOf(toElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(toElement).perform();

    }


    public WebElement SelectOnRandomItemInList(List<WebElement> exampleList){
        Random r = new Random();
        int i = r.nextInt(exampleList.size());
        wait.until(ExpectedConditions.visibilityOf(exampleList.get(i)));
        return exampleList.get(i);
    }

    public void windowHandle(){
        String firstWin=driver.getWindowHandle();
        String firstWinURL=driver.getCurrentUrl();
        System.out.println("First URL: "+ firstWinURL);
        Set<String> windowAllWindows=driver.getWindowHandles();
        for (String window:windowAllWindows) {
            driver.switchTo().window(window);
        }
        String secWin=driver.getCurrentUrl();
        System.out.println("Current URL: "+ secWin);
    }



}
