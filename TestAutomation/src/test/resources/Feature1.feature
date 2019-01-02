Feature: To make changes to Facebook (site)

	
  Scenario Outline: 
    Given Facebook Home Page loads successfully
    Then Enter LoginId "<loginId>"
    Then Enter Password "<Password>"
    Then Enter the following details
      | Fields | Value  |
      | Day    |     30 |
      | Month  | Dec    |
      | Year   |   1992 |
      | Gender | Female |
    Then Close the Browser

    Examples: 
      | loginId        | Password |
      | vjd@gmail.com  | vdsfdsd  |
