package Pages;

import Helper.Constant;
import Helper.Utils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WestWingModelScreen {


    private By listOfWishlistIcon = By.xpath(".//*[@class='border']");


    @Then("^I should see product listing page with a list of products$")
    public void check_if_product_displayed() throws Throwable {
        try {


            JavascriptExecutor js = (JavascriptExecutor) Constant.webdriver;

            if (Utils.isDisplayed(listOfWishlistIcon)) {

                List<WebElement> wishListItems = Constant.webdriver.findElements((listOfWishlistIcon));

                System.out.println("Wishlist Item Count->" + wishListItems.size());
                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_product_list.png");


            } else {
                System.out.println("wishList_items are not displayed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @When("^I click on wishlist icon of the first found product$")
    public void click_first_product() throws Throwable {
        try {

            JavascriptExecutor js = (JavascriptExecutor) Constant.webdriver;

            if (Utils.isDisplayed(listOfWishlistIcon)) {

                List<WebElement> wishListitems = Constant.webdriver.findElements(listOfWishlistIcon);

                System.out.println("First Product is displayed" + wishListitems.size());

                for (int i = 0; i < wishListitems.size(); i++) {

                    if (wishListitems.get(i).isDisplayed()) {
                        System.out.println("First Product is displayed-" + i);
                        WebElement w = wishListitems.get(i);

                        Constant.wait.until(ExpectedConditions.elementToBeClickable(w));

                        Actions actions = new Actions(Constant.webdriver);

                        actions.click(w).perform();

                        Thread.sleep(3000);

                        System.out.println("Wishlist First Item is selected");


                        Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "_wishList_item_Selected.png");
                        break;
                    } else {
                        System.out.println("Not found index 0");

                        break;
                    }

                }


            } else {
                System.out.println("First Product is not displayed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
