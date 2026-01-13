package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    public static boolean clickReturnBoolean(WebElement elementToClick, WebDriver driver) throws InterruptedException
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
    public static boolean enterText(WebElement inputBox, String keysToSend)
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

    public static void scrollTillElementAndClick(WebDriver driver, WebElement ele){
        try{
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();;
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void radioButton(ChromeDriver driver,String radioButtonText){
        try {
            WebElement element= driver.findElement(By.xpath("//div[@class='SG0AAe']//span[contains(text(),'"+radioButtonText+"')]"));
            element.click();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void dropDownClickByLoop(List<WebElement> elements, String titleText) {
        try {
            for (WebElement element : elements) {
                System.out.println(element.getText());
                
                if(element.getText().equals(titleText)){
                    element.click();
                    break;
                }    
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void checkBox(ChromeDriver driver, String checkBox){
        try {
            WebElement element =driver.findElement(By.xpath("//div[@class='Y6Myld']//span[contains(text(),'"+checkBox+"')]"));
            element.click();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static String gateDateSevenDaysAgo(int days){
        LocalDate currentdate = LocalDate.now();
        LocalDate minusSevenDays = currentdate.minusDays(days);
        DateTimeFormatter dTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDate = minusSevenDays.format(dTimeFormatter);
        return formatedDate;
    } 

    public static String getEpochTime(){
         long currenttime = System.currentTimeMillis();
         String epoch=String.valueOf(currenttime);
         return epoch;

    }

    
    

    }

