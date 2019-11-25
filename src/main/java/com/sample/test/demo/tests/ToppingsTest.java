/*
 * Author: Hemant Choudhari
 */
package com.sample.test.demo.tests;

import static io.restassured.RestAssured.given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.sample.test.demo.utils.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ToppingsTest extends BaseTest {

    private static final String baseURI = "https://my-json-server.typicode.com/sa2225/demo";
    public Logger log = LogManager.getLogger(OrdersTest.class.getName());
    
    @BeforeClass( alwaysRun =  true)
    public void setUp() {
    	 RestAssured.baseURI = baseURI;
    	 RestAssured.basePath = "/toppings";
    	 
    }
   
    
    /* Test case 1
     * GET call : All toppings 
     * Base path :  /toppings
     * Validate Status code
     * Validate Status line
     */
    @Test(groups = {"toppingsSanity"})
    public void testAllToppingsGetCall() {
    	log.info("********* Started TestCase_testAllToppingsGetCall  **********");
    	given()
    		.get()
    	.then()
    		.assertThat()
    		.statusCode(200)
    		.statusLine("HTTP/1.1 200 OK");
    }
    
    /* Test case 2
     * DELETE call : delete toppings 
     * Base path :  /toppings/1
     * Validate Status code
     * Validate Status line
     */
    @Test(groups = {"toppingsSanity"}, enabled =  true)
    public void testDeleteToppingCall() {
    	log.info("********* Started TestCase_testDeleteToppingCall  **********");
    	given()
    		.delete("/1")
    	.then()
    		.assertThat()
    		.statusCode(200)
    		.statusLine("HTTP/1.1 200 OK");
    }
}
