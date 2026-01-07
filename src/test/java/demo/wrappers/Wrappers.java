package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;



public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    /*
     * Check if the element is displayed before attempting to click 
     * Scroll in to view before clicking on an element 
     * return false if the element is not displayed / any other exception
     */
    public static boolean click(WebElement elementToClick, WebDriver driver) throws InterruptedException
    {
        if(elementToClick.isDisplayed())
        {
            try{
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToClick);
           
            elementToClick.click();
            return true;}
            catch(Exception e)
            {
                return false;
            }
        }
        return false;
        
    }

    /*
     * clear the existing text on the inputBox 
     * Type in the new keys 
     */
    public static boolean sendKeys(WebElement inputBox, String keysToSend)
    {
        try{
        inputBox.clear();
        inputBox.sendKeys(keysToSend);
        return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    public static void elementToClickWait(WebDriver driver,WebElement element){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public static void elementToVisibleWait(WebDriver driver,WebElement element){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void scrollTillElement(WebDriver driver, WebElement ele){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        
    }

    
    

    }

