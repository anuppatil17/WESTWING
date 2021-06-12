package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExecutionListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class TestNG_SearchGroup extends Utils implements IExecutionListener
{
    public static String status = "passed";


    @BeforeTest
    public void before(){
        System.out.println("Before Test");
    }
    @Test
    public void WESTSearch() throws Exception {
        String search_string =" LambdaTest";
        String exp_title = "Most Powerful Cross Browser Testing Tool Online | LambdaTest";
        String environment="local";
        if (environment.equalsIgnoreCase("local"))
        {
            setupThread("chrome");
        }
        System.out.println("Started session");

        WebDriver webdriver = getDriver();
        webdriver.navigate().to("https://www.westwingnow.de");


        webdriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(webdriver, 10);

        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();

        Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"_Landing.png");


        System.out.println("Started session");

        try {
            /* Enter the search term in the Google Search Box */

            WebElement Cookie_Accept=wait.until(ExpectedConditions.elementToBeClickable(webdriver.findElement(By.xpath("//*[. = 'Cookies akzeptieren']"))));
            if (Cookie_Accept.isDisplayed()){
                System.out.println("Cookies is displayed");
                Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"popup.png");



                Cookie_Accept.click();
                Thread.sleep(3000);
                Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"_Accept.png");
                status = "passed";
            }else
            {
                System.out.println("popup is not coming up");
            }




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        try {
            /* Enter the search term in the Google Search Box */


            if (webdriver.findElement(By.xpath("//*[@class='Navigation__StyledNavLinkLongText-sc-2arr4g-5 laehGL' and .='Möbel']")).isDisplayed()){
                System.out.println("model is displayed");


                WebElement search_box = webdriver.findElement(By.xpath("//*[@class='Navigation__StyledNavLinkLongText-sc-2arr4g-5 laehGL' and .='Möbel']"));
                WebElement element = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Navigation__StyledNavLinkLongText-sc-2arr4g-5 laehGL' and .='Möbel']")));


                element.click();
                Thread.sleep(3000);
                Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"_model.png");
                status = "passed";
            }else
            {
                System.out.println("model is not displayed");
            }

            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            /* Enter the search term in the Google Search Box */
            if (webdriver.findElement(By.xpath("//*[@data-testid='login-button']")).isDisplayed()){
                System.out.println("Registered popup is displayed");
                Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"_Registered_Screen.png");


                WebElement login_button = webdriver.findElement(By.xpath("//*[@data-testid='login-button']"));


                login_button.click();
                Thread.sleep(3000);



                Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"_Login_Screen.png");
                status = "passed";


            }else
            {
                System.out.println("Registered popup is not displayed");
            }

            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            /* Enter the search term in the Google Search Box */
            if (webdriver.findElement(By.xpath("//*[text()='Bereits registriert?']")).isDisplayed()){
                System.out.println("Bereits registriert is displayed");


                WebElement email = webdriver.findElement(By.xpath("//*[@name='email']"));

                WebElement password = webdriver.findElement(By.xpath("//*[@name='password']"));

                WebElement submit = webdriver.findElement(By.xpath("//*[@data-testid='login_reg_submit_btn']"));


                email.sendKeys("anup.patil17@gmail.com");
                password.sendKeys("Anup@2838");
                submit.submit();

                Thread.sleep(3000);



                Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"login_success_Screen.png");
                status = "passed";


            }else
            {
                System.out.println("Bereits pop up is not displayed");
            }

            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        try {
            String wishList="//*[@class='border']";
            JavascriptExecutor js = (JavascriptExecutor)webdriver;

            if (webdriver.findElement(By.xpath(wishList)).isDisplayed()){

                List<WebElement> wishListitems=webdriver.findElements(By.xpath(wishList));

                System.out.println("Wishlist First Item is displayed"+wishListitems.size());

                for(int i=0;i<wishListitems.size();i++){

                    if(wishListitems.get(i).isDisplayed()){
                        System.out.println("Wishlist First Item is displayed 0");
                        WebElement w=  wishListitems.get(i);

                        wait.until(ExpectedConditions.elementToBeClickable(w));

                        Actions actions = new Actions(webdriver);

                        actions.click(w).perform();

                        Thread.sleep(3000);

                        System.out.println("Wishlist First Item is displayed");


                        Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"wishList_item_added_Screen.png");
                        status = "passed";
                        break;
                    }else {
                        System.out.println("Not found index 0");

                        break;
                    }




                }





            }else
            {
                System.out.println("wishList_item  is not displayed");
            }

            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {

            if (webdriver.findElement(By.xpath("//*[@data-testid='wishlist-counter']")).isDisplayed()){
                System.out.println("Wishlist item is added");


                WebElement wishlist_Counter = webdriver.findElement(By.xpath("//*[@data-testid='wishlist-counter']"));


               wishlist_Counter.click();

                Thread.sleep(3000);



                Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"Wishlist_Screen.png");
                status = "passed";


            }else
            {
                System.out.println("Bereits pop up is not displayed");
            }

            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            String wishListProduct="//*[@class='blockListProduct__delete qaBlockListProduct__delete']";

            if (webdriver.findElement(By.xpath(wishListProduct)).isDisplayed()){

                List<WebElement> wishListitems=webdriver.findElements(By.xpath(wishListProduct));

                System.out.println("Wishlist First Item is displayed"+wishListitems.size());

                for(int i=0;i<wishListitems.size();i++){

                    if(wishListitems.get(i).isDisplayed()){
                        System.out.println("Wishlist First Item is displayed 0");
                        WebElement w=  wishListitems.get(i);

                        wait.until(ExpectedConditions.elementToBeClickable(w));

                        Actions actions = new Actions(webdriver);

                        actions.click(w).perform();

                        Thread.sleep(3000);

                        System.out.println("wishListProduct First Item is deleted");


                        Utils.takeSnapShot(webdriver,"src/ScreenShots/"+time+"wishList_item_deleted_Screen.png");
                        status = "passed";

                    }else {
                        System.out.println("Not found index 0");

                    }




                }





            }else
            {
                System.out.println("wishList_item  is not displayed");
            }

            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    @AfterTest
    public void after(){

        if (getDriver() != null)
        {
            tearDownDriver();
        }
        System.out.println("after Test");
    }

}
