Feature: To validate the cbanges made in Feature1

  Scenario Outline: 
    Given Facebook Home Page loads successfully
    Then Enter LoginId "<loginId>"
    Then Enter Password "<Password>"
    Then validate the following details
      | Fields | Value  |
      | Day    |     30 |
      | Month  | Dec    |
      | Year   |   1992 |
      | Gender | Female |
    Then Close the Browser

    Examples: 
      | loginId        | Password |
      | ajas@gmail.com | dsasdsa  |
      | vjd@gmail.com  | vdsfdsd  |
