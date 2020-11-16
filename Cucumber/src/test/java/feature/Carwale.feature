@Carwale
Feature: Carwale

Scenario Outline: TC001 Carwale
Given Go to https://www.carwale.com/
And Click on Used
And Select the City as "<row_Index>" as Chennai
And Select budget min (8L) and max(12L) and Click Search
And Select Cars with Photos under Only Show Cars With
And Select Manufacturer as Hyundai Creta
And Select Fuel Type as Petrol
When Select Best Match as KM: Low to High
Then Validate the Cars are listed with KMs Low to High, Add least KM
When Go to Wishlist and Click on More Details
Then Print all the details under Overview
Then Close the browser

Examples:
|row_Index|
|1|
#|2|
#|3|
