@tag
Feature: Validate the functionality of Health Suppliments feature

  @tag1
  Scenario: Verify the functionality of Health Suppliment feature
    Given Open url for naptol 
    And Open the Health section by clicking in health and click on the Health Suppliments
    When Perform click actions on checkboxes avaliable for narrow result
    And Click on the product displayed perform some actions on that page
    And Add product to the cart and proceed to checkout
    Then close the browser
