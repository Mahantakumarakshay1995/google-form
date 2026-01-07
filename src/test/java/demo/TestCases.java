package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases  {
    ChromeDriver driver;
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(2000);
        WebElement namebutton =driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        namebutton.click();
        namebutton.sendKeys("Crio Learner");
        Thread.sleep(2000);

        long epoch = System.currentTimeMillis();
        String sentence= "I want to be the best QA Engineer!";
        String finaltext= sentence+ " " +String.valueOf(epoch);
       // WebElement whyauto = driver.findElement(By.xpath("//div[contains(@class,'RpC4Ne oJeWuf')]"));
       System.out.println(finaltext);
        WebElement whyauto = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
       
        Wrappers.scrollTillElement(driver,whyauto);
         Wrappers.elementToClickWait(driver, whyauto);

        whyauto.sendKeys(finaltext);
        Thread.sleep(2000);

       WebElement yearradio=driver.findElement(By.xpath("(//div[@class='vd3tt'])[2]"));
       Wrappers.scrollTillElement(driver,yearradio);
       yearradio.click();

       WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'Java')]"));
       Wrappers.scrollTillElement(driver,ele1);
        Wrappers.elementToClickWait(driver, ele1);
        ele1.click();
       WebElement ele2 = driver.findElement(By.xpath("//span[contains(text(),'Selenium')]"));
       Wrappers.scrollTillElement(driver,ele2);
        Wrappers.elementToClickWait(driver, ele2);
        ele2.click();

       WebElement ele3 = driver.findElement(By.xpath("//span[contains(text(),'TestNG')]"));
       Wrappers.scrollTillElement(driver,ele3);
        Wrappers.elementToClickWait(driver, ele3);
        ele3.click();
       Thread.sleep(2000);
       //select choose button and select doctor

       WebElement salutaion = driver.findElement(By.xpath("//span[normalize-space()='Choose']"));
        Wrappers.scrollTillElement(driver,salutaion);
        Wrappers.elementToClickWait(driver, salutaion);
       salutaion.click();

       Thread.sleep(3000);

       WebElement mrelement = driver.findElement(By.xpath("//div[@role='option']//span[@class='vRMGwf oJeWuf'][normalize-space()='Dr']"));
        Wrappers.scrollTillElement(driver, mrelement);
       Wrappers.elementToClickWait(driver, mrelement);
       Wrappers.elementToVisibleWait(driver, mrelement);
       System.out.println(mrelement.getText());
       mrelement.click();
       Thread.sleep(2000);


        String date=LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       WebElement dateBox=driver.findElement(By.xpath("//input[@type='date']"));
       dateBox.sendKeys(date);
       System.out.println(date);

       WebElement houreleemnt = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
       houreleemnt.sendKeys("07");
       WebElement minuteleemnt = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
       minuteleemnt.sendKeys("30");

       //driver.findElement(By.xpath("//span[contains(text(),'PM')]")).click();
       Thread.sleep(1000);
        
        driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
        Thread.sleep(2000);

        WebElement responseactual = driver.findElement(By.xpath("//div[contains(text(),'Thanks for your response, Automation Wizard!')]"));
        String responsetextexpected="Thanks for your response, Automation Wizard!";
        Assert.assertEquals(responseactual.getText(),responsetextexpected);
        

    }
        
    

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}
