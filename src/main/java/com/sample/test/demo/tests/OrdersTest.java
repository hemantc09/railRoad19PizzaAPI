/*
 * Author: Hemant Choudhari
 */

package com.sample.test.demo.tests;

import static io.restassured.RestAssured.given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.test.demo.utils.BaseTest;
import com.sample.test.demo.utils.Order;
import com.sample.test.demo.utils.Pizza;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;


public class OrdersTest extends BaseTest {

    private static final String baseURI = "https://my-json-server.typicode.com/sa2225/demo";
    public Logger log = LogManager.getLogger(OrdersTest.class.getName());
    
    @BeforeClass( alwaysRun =  true)
    public void setUp() {
    	 RestAssured.baseURI = baseURI;
    	 RestAssured.basePath = "/orders";
    	 
    }
   
    /* Test case 1 
     * GET call : All orders -  Test 
     * Base path :  /orders
     * Validate Status code
     * Validate Status line
     */
    @Test(groups = {"ordersSanity"})
    public void testOrdersGetCall() {
    	log.info("********* Started TestCase_testAllOrders  **********");
    	given()
    		.get()
    	.then()
    		.assertThat()
    		.statusCode(200)
    		.statusLine("HTTP/1.1 200 OK");
    }
    
  
    /*
     * Test case 2
     * GET call :  single order 
     * Base path: /order/1
     * Validate response contains id
     * Validate response contains item
     */
    @Test(groups = {"ordersSanity"})
    public void testSingleOrderCall() {
    	log.info("********* Started TestCase_testSingleOrder  **********");
    	Order  orderObj  = 
    			given()
    				.get("/1")
    			.then()
    				.assertThat()
    				.statusCode(200)
    				.statusLine("HTTP/1.1 200 OK")
    				.extract()
    				.as(Order.class);
    	//assert id is 1 of response 
		Assert.assertEquals(orderObj.getId(), "1");
		//De-serialization from Order class 
		String result = orderObj.toString();
		//verify returned result contain item 
		Assert.assertEquals(result.contains("item"), true);
    }
    
   /*
    * POST  call : single order - 2 Toppings - Test case 3
    * Base path: /orders
    * Validate response contains id
    * Validate response contains exact payload passed
    * Validate status code
    * Validate status line
    */
    @Test(groups= {"ordersSanity"})
    public void testPostOrdersCall() {
    	log.info("********* Started TestCase_testPostOrdersCall  **********");
    	Pizza pizzaObj = new Pizza();
    	//set payload using serialization
    	List<String> toppingsList =  new ArrayList<String>();
    	toppingsList.add("Mushrooms");
    	toppingsList.add("Extra cheese");
    	pizzaObj.setPizza("Small 8 Slices - 2 toppings");
    	pizzaObj.setToppings(toppingsList);
    	
    	Response response =  
    		given()
	    		.contentType(ContentType.JSON)
	    		.body(pizzaObj)
	    	.when()
    			.post()
    		.then()
    			.statusCode(201)
    			.statusLine("HTTP/1.1 201 Created")
    			.extract().response();
    	String jsonAsString = response.asString();
    	//validate id is created in response
    	Assert.assertEquals(jsonAsString.contains("id"),true);
    }
}
