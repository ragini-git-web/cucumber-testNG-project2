
Feature:  Validate the functionality of PainRelievers feature


  @tag1
  Scenario: To verify the functionality of PainRelievers feature
    Given Open the url in the browser
    And Click on the Health and click on the painrelievers
    And  Click on all the checkboxes present on the page and  enter the pincode
    And check the result and assert the message displayed
    When click on the search bar and search pain relievers and assert the message displayed
    And close the page
    


