@regression
Feature: Add to cart

  @smoke @demo
  Scenario Outline: Add one quantity from Store
    Given I'm on the Gammax Page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name |
      | Blue Shoes   |

