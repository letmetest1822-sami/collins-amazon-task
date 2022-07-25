Feature: Add item and delete from cart
  @wip
  Scenario: Cart test
    Given the user is on the Home Page
    And the user enter the text "Shoes for men" in the search bar
    And Choose the last auto-complete option from the dropdown menu suggestions
    And Add the first shoe to the Cart with a quantity of 3
    And Open/Go to the cart and assert the total price and quantity of shoes are correct
    # Using only one action in a single step will be better
    When Delete the items from the cart
    Then Assert that the cart is now empty