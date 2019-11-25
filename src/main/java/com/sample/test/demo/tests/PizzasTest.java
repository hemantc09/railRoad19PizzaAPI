/*
 * Author: Hemant Choudhari
 */
package com.sample.test.demo.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.sample.test.demo.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class PizzasTest extends BaseTest {

    private static final String baseURI = "https://my-json-server.typicode.com/sa2225/demo";
    public Logger log = LogManager.getLogger(OrdersTest.class.getName());
    
    @BeforeClass( alwaysRun =  true)
    public void setUp() {
    	 RestAssured.baseURI = baseURI;
    	 RestAssured.basePath = "/pizzas";
    	 
    }
   
    /* Test case 1
     * GET call : All toppings 
     * Base path :  /toppings
     * Validate Status code
     * Validate Status line
     * validate all pizza id
     * validate all pizza names
     */
    @Test(groups = {"pizzasSanity"})
    public void testAllPizzasGetCall() {
    	log.info("********* Started TestCase_testAllPizzasGetCall  **********");
    	
    	Response response =  
        		given()
    	    	.when()
        			.get()
        		.then()
        			.statusCode(200)
        			.statusLine("HTTP/1.1 200 OK")
        			.body("[0].id", equalTo(1))
        			.body("[1].id", equalTo(2))
        			.body("[2].id", equalTo(3))
        			.body("[3].id", equalTo(4))
        			.body("[4].id", equalTo(5))
        			.body("[0].pizza", equalTo("Small 6 Slices - no toppings"))
        			.body("[1].pizza", equalTo("Small 6 Slices - 1 topping"))
        			.body("[2].pizza", equalTo("Medium 8 Slices - 2 toppings"))
        			.body("[3].pizza", equalTo("Large 10 Slices - no toppings"))
        			.body("[4].pizza", equalTo("Large 10 Slices - 2 toppings"))
        			.extract().response();
        	//String jsonAsString = response.asString();
    }
}
