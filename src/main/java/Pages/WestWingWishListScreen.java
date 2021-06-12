package Pages;

import Helper.Constant;
import Helper.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WestWingWishListScreen {


    private By wishListCounterIcon = By.xpath(".//*[@data-testid='wishlist-counter']");
    private By wishListDeleteIcon = By.xpath(".//*[@class='blockListProduct__delete qaBlockListProduct__delete']");


    @Then("^the product should be added to the wishlist$")
    public void Check_wishlist_added() throws Throwable {
        try {

            Utils.waitForClick(wishListCounterIcon);

            if (Utils.isDisplayed(wishListCounterIcon)) {
                System.out.println("Wishlist item is added");


                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "Wishlist_Item_added_displayed.png");


            } else {
                System.out.println("Item added  not displayed");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    @And("^I go to the wishlist page to check added wishlist items$")
    public void Check_wishlist() throws Throwable {

        try {


            if (Utils.isDisplayed(wishListCounterIcon)) {
                System.out.println("Wishlist item is added");


                Utils.isClicked(wishListCounterIcon);
                Thread.sleep(3000);


                Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "Wishlist_Screen.png");


            } else {
                System.out.println("Bereits pop up is not displayed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @And("^I delete the product from my wishlist$")
    public void delete_wishlist_item() throws Throwable {
        try {




            if (Utils.isDisplayed(wishListDeleteIcon)) {

                List<WebElement> wishListitems = Constant.webdriver.findElements(wishListDeleteIcon);

                System.out.println("Wishlist First Item is displayed" + wishListitems.size());

                for (int i = 0; i < wishListitems.size(); i++) {

                    if (wishListitems.get(i).isDisplayed()) {
                        System.out.println("Wishlist First Item is displayed--" + i);
                        WebElement w = wishListitems.get(i);

                        Constant.wait.until(ExpectedConditions.elementToBeClickable(w));

                        Actions actions = new Actions(Constant.webdriver);

                        actions.click(w).perform();

                        Thread.sleep(3000);

                        System.out.println("wishListProduct First Item is deleted");


                        Utils.takeSnapShot(Constant.webdriver, "src/ScreenShots/" + Constant.time + "wishList_item_deleted_Screen.png");


                    } else {
                        System.out.println("Not found index 0");

                    }


                }


            } else {
                System.out.println("wishList_item  is not displayed");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
