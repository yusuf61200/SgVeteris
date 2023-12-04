Feature: Trendyol Test

  Scenario: Trendyol Basket Cleaning Scenario

    Given Go to Trendyol website
    And Check that the main page is opened
    And Attempts are made to log in to the site with incorrect information.
    And The word "laptop" is entered in the search box.
    And According to the result, a random product is selected from the products
    And The selected product is added to the cart
    And Compared to the price of the product before adding it to the cart
    And Increase the number of product in the basket to two and check its accuracy
    When All items in the cart are deleted
    Then Check that the basket is clean