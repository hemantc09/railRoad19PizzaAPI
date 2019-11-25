# API-Testing-REST-Assured-Framework - RailRoad19
# Steps to Import the project in eclipse and execute test suite 

**Technology Used:**
1. RestAssured Java API
2. TestNG Framework 
3. Report and logger for generating reports and logs.

**Github repository:**  enter repo URL here

**Steps to import project**
- Download repo from enter https://github.com/hemantc09/railRoad19PizzaAPI
- Unzip [railRoad19PizzaAPI-master] folder it
- Go to Eclipse > File > Import project
- Select the Folder “railRoad19PizzaAPI-master”
- Click on Open
- Click Finish

Note: Once you Imported the project in eclipse Make sure the project directory is there. 

See Example below: This is the folder structure .

[![railroad19](https://i.postimg.cc/Hnpk5QBK/Screen-Shot-2019-11-24-at-4-46-15-PM.png "railroad19")](https://i.postimg.cc/Hnpk5QBK/Screen-Shot-2019-11-24-at-4-46-15-PM.pnghttp:// "railroad19")

**Note:**
Once you have same folder structure imported wait for a while until maven download all the dependencies. 

**Now you all set to run the project.**

### It has following this implemented. 
1. OrdersTest
2. PizzasTest
3. ToppingsTest

Each Test Class has multiple test cases created . Also I have added comments in each class.


**1. Steps to Run the Test suite using Maven**

------------


- Right click on pom.xml file in the project directory level
- Select Run As > 6.Maven Test

*Note: Now your test suit is running. It will log all the success or errors on the eclipse console*

**Steps to see the results using report.html**

Go to Report Directory
Right click foxReport.html > Open With WebBrowser
This will open the report in WebBrowser and it will show the entire test suite report

**2. Steps to Run the Test suite using TestNG**

------------



- Right click on tsetng.xml file in the project directory level
Select Run As >  TestNG Suite

*Note: Now your test suit is running. It will log all the success or errors on the eclipse console*


**Steps to see the results using report.html**

- Go to test-output Directory
- Right click index.html > Open With WebBrowser
- This will open the index.html in WebBrowser and it will show the entire test suite report

**Note:**
- Entire test suite is verified and work as expected with no errors. 
- you might see authentication key error or email id errors. make sure to update those
- Email me for any help: hemantc09@gmail.com

## Test Case below:

#### Test Cases : Automated Test Cases : Automated 

##### Orders module : 

1. GET call : All orders  - 200 OK
- Base path :  /orders
- Validate Status code 
- Validate Status line
- GET call :  single order  - 200 OK
- Base path: /order/1
- Validate response contains id
- Validate response contains item

2. POST  call : single order - 2 toppings -  Success 201
Base path: /orders
Validate response contains id
Validate status code
Validate status line

##### Toppings  module:

1. GET call - Toppings - 200 OK - List all Toppings
- Base path : /toppings
- Validate Status code
- Validate status line

2. DELETE /toppings/1 - 200 OK - Success 
- Base path : /toppings
- Validate Status code
- Validate status line

##### Pizzas  module :

1. GET call - Toppings - 200 OK - List all Toppings
- Base path : /toppings
- Validate Status code
- Validate status line
- Validate all pizza id 
- Validate all pizza names


#### Test Cases : Not AutomatedTest Cases : Not Automated

1. POST  call : single order - 2 toppings -  Negative Test case
- Base path: /orders
- Payload - extra toppings more than 2
- Validate response contains error code 
- Validate response contains error message “toppings should be 2 as per pizza type”

2. POST  call : single order - no toppings
- Base path: /orders
- Payload - {}
- Validate response contains error code 
- Validate error message “Add toppings”

3. POST  call : single order - Incorrect pizza name 
- Base path: /orders
- Payload - pass incorrect pizza type name [schema string validation]
- Validate response contains error code 
- Validate error message  “pizza type name is incorrect”


Regards,
Hemant 

Have a great day


