Feature: Test the shopping application page

@Order
Scenario Outline: Test the purchase order of product
Given Select the browsers as <Browser>
When Enter the urls as <Url>
But Click to signin link
And Enter the usernames as <Username>
But Enter the passwords as <Password>
Then Click to login button
And Click the T-shirt link in Title menu and select the Tshirt as <Tshirtname> to order
When Select the quantity as <Quantity>, Size as <size> and color as <color>
Then Click add to cart as selected the product
But Click to proceed to summary
And Click to proceed to address
When Validate the delivery option and check the terms of service in shipping
But Whether would you like do payment via bank or check as <Bankcheck> and order the product
Then Verify the product order in store order list

Examples:
|Browser|Url|Username|Password|Tshirtname|Quantity|size|color|Bankcheck|
|Chrome|http://automationpractice.com|someone@example.com|Password123|Faded Short Sleeve T-shirts|2|M|Blue|check|


@personalinfo
Scenario Outline: Test the account personal information updation

Given Select the browsers for personal as <Browser>
When Enter the urls for personal as <Url>
But Click to signin link for personal
And Enter the usernames for personal as <Username>
But Enter the passwords for personal as <Password>
Then Click to login button for personal
When Click to account personal info link
And Give the first name as <firstname> and save

Examples:
|Browser|Url|Username|Password|firstname|
|Chrome|http://automationpractice.com|someone@example.com|Password123|Veera|
