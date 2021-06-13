package Pages;

import Helper.Constant;
import Helper.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WestWingHomeScreenSteps {

    private By cookieAcceptBtn = By.xpath(".//*[. = 'Cookies akzeptieren']");

    private By modelTabFromHomeScreen = By.xpath(".//*[@class='Navigation__StyledNavLinkLongText-sc-2arr4g-5 laehGL' and .='Möbel']"); // not used because need to modify element



    @Given("^I am on the WestwingNow home page \"(.*?)\" with browser \"(.*?)\" in \"(.*?)\"$")
    public void user_launches_WestwingNow(String url, String Browser, String env) throws Throwable {


        System.out.println("Details--" + url + "Browser" + Browser + "Env" + env);

        if (env.equalsIgnoreCase("Docker")) {
            Utils.setupThread(Browser);
        }
        System.out.println("Started session");

        Constant.webdriver =Utils.getDriver(); // Get WebDriver Session


        Constant.wait = new WebDriverWait(Constant.webdriver, 10);

        Constant.webdriver.navigate().to("https://www.westwingnow.de");


        Constant.webdriver.manage().window().maximize();

        Constant.webdriver.get(url);

        Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_Landing.png");

        try {
            /* Enter the search term in the Google Search Box */


           // WebElement until = Constant.wait.until(ExpectedConditions.elementToBeClickable(Constant.webdriver.findElement(cookieAcceptBtn)));

             Utils.waitForClick(cookieAcceptBtn);

            if (Utils.isDisplayed(cookieAcceptBtn)) {
                System.out.println("Cookies is displayed");
                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_popup.png");

                Utils.isClicked(cookieAcceptBtn);

                Thread.sleep(3000);
                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_Accept.png");

                System.out.println("Cookies accepted");

            } else {
                System.out.println("popup is not coming up");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @When("^I search for \"(.*?)\"$")
    public void select_Model_product(String product) throws Throwable {
        try {
            /* Enter the search term in the Google Search Box */




            if (Constant.webdriver.findElement(By.xpath("//*[@class='Navigation__StyledNavLinkLongText-sc-2arr4g-5 laehGL' and .='" + product + "']")).isDisplayed()) {
                System.out.println("model is displayed");


                WebElement Action=Constant.wait.until(ExpectedConditions.elementToBeClickable(Constant.webdriver.findElement(By.xpath("//*[@class='Navigation__StyledNavLinkLongText-sc-2arr4g-5 laehGL' and .='" + product + "']"))));

                Actions actions = new Actions(Constant.webdriver);

                actions.click(Action).perform();

                System.out.println("action clicked is displayed");  // Handling Login popup

                WebElement element = Constant.wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Navigation__StyledNavLinkLongText-sc-2arr4g-5 laehGL' and .='" + product + "']")));


                element.click();
                Thread.sleep(3000);
                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_model.png");
            } else {
                System.out.println("model is not displayed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
