Feature: Search and place the order for products

Scenario: Search experience for product search in both home and offers page

Given User is on GreenCart Landing page
When user searched with shortname "Tom" and extracted actual name of the product
Then user searched for "Tom" shortname in offers page
And validate product name in offfers page matches with landing page



 