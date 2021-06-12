package Helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static String remote_url_chrome = "http://localhost:5903/wd/hub";
    public static String remote_url_firefox = "http://localhost:5902/wd/hub";
    public static String remote_url = "http://localhost:4444/wd/hub";


    public static void setupThread(String browserName) throws MalformedURLException
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.out.println("Inside Chrome");
            ChromeOptions options = new ChromeOptions();
            driver.set(new RemoteWebDriver(new URL(remote_url), options));
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.out.println("Inside Firefox");
            FirefoxOptions options = new FirefoxOptions();
            driver.set(new RemoteWebDriver(new URL(remote_url), options));
        }
    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void tearDownDriver()
    {
        getDriver().quit();
    }

   public static void waitForClick(By element)
    {
        Constant.wait.until(ExpectedConditions.elementToBeClickable(Constant.webdriver.findElement(element)));

    }

    public static Boolean isDisplayed(By element)
    {
       Boolean isDisplayed=Constant.webdriver.findElement(element).isDisplayed();
return isDisplayed;
    }

    public static void isClicked(By element)
    {
        Constant.webdriver.findElement(element).click();

    }

    public static void InputFields(By element,String data)
    {
        Constant.webdriver.findElement(element).sendKeys(data);

    }


    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }
}