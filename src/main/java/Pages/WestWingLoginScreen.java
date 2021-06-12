package Pages;

import Helper.Constant;
import Helper.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class WestWingLoginScreen {


    private By haveAccount = By.xpath("//*[contains(text(),'Hier einloggen')]");

    private By alreadyRegisterLabel = By.xpath(".//*[text()='Bereits registriert?']");

    private By emailTxtField = By.xpath(".//*[@name='email']");

    private By pwdTextField = By.xpath(".//*[@name='password']");

    private By loginSubmitBtn = By.xpath(".//*[@data-testid='login_reg_submit_btn']");


    @Then("^I should see the login/registration overlay$")
    public void authenticate_popup() throws Throwable {

        try {
            /* Enter the search term in the Google Search Box */
            if (Utils.isDisplayed(haveAccount)) {
                System.out.println("Registered popup is displayed");
                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_Registered_Screen.png");


            } else {
                System.out.println("Registered popup is not displayed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @When("^I switch to login form of the overlay$")
    public void switch_to_login_popup() throws Throwable {

        try {

            Utils.waitForClick(haveAccount);
            /* Check If link is clickable or not */
            if (Utils.isDisplayed(haveAccount)) {
                System.out.println("Already Registered...");


                Utils.isClicked(haveAccount);

                Thread.sleep(3000);


                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_Login_Screen.png");


            } else {
                System.out.println("Registered popup is not displayed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("^I log in with UserName (.*) and Password (.*)$")
    public void login_with_credentials(String UserName, String Password) throws Throwable {

        try {

            Utils.waitForClick(alreadyRegisterLabel);

            if (Utils.isDisplayed(alreadyRegisterLabel)) {

                System.out.println("Bereits registriert is displayed");


                Utils.InputFields(emailTxtField,UserName);

                Utils.InputFields(pwdTextField,Password);

                Utils.isClicked(loginSubmitBtn);

                Thread.sleep(3000);


                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "login_success_Screen.png");


            } else {
                System.out.println("Bereits pop up is not displayed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
