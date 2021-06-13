@WestWing
Feature: WEST WING automation test

  @WestWing_wishlist
  Scenario: WEST WING automation test
    Given I am on the WestwingNow home page "https://www.westwingnow.de" with browser "chrome" in "Docker"
    When I search for "Möbel"
    Then I should see product listing page with a list of products
    When I click on wishlist icon of the first found product
    Then I should see the login/registration overlay
    When I switch to login form of the overlay
    And I log in with UserName anup.patil17@gmail.com and Password Anup@2838
    Then the product should be added to the wishlist
    And I go to the wishlist page to check added wishlist items
    And I delete the product from my wishlist