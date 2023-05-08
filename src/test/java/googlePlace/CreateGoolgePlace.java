package googlePlace;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.GoogleplacePayload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

import groovy.util.logging.Log;

public class CreateGoolgePlace {

	
	@Test
	public void ValidateCreateNewPlace() {
		
		// given--all input 
		//when--submit request
		//Then--validate response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body(GoogleplacePayload.createPlaceDeatils()).when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).body("scope", equalTo("APP")).
		header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
	
	
	 JsonPath js= new JsonPath(response); // for Parsing json
	  
	String placeId= js.getString("place_id");
	System.out.println(placeId);
	
String status=js.getString("status");
System.out.println(status);

assertEquals("OK", status);


//Update address

//String updateData=given().log().all().queryParam("place_id",placeId).queryParam("key","qaclick123").header("Content-Type","application/json").
//body("{\r\n"
//		+ "\"place_id\":"+placeId+",\r\n"
//		+ "\"address\":\"Test\",\r\n"
//		+ "\"key\":\"qaclick123\"\r\n"
//		+ "}").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
//
//    
//  System.out.println(updateData);



//GetPlace Details

String getResponse= given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId).when().get("maps/api/place/get/json").then().
  assertThat().statusCode(200).extract().response().asString();
 System.out.println(getResponse);
 

 JsonPath js1= new JsonPath(getResponse);
  String address=js1.getString("address");
  System.out.println(address);
  
  assertEquals("29, side layout, cohen 09", address);
  
  
 String deleteData= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\r\n"
  		+ "\r\n"
  		+ "    \"place_id\":"+placeId+"\r\n"
  		+ "}\r\n"
  		+ "").when().delete("maps/api/place/delete/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
  
 
  System.out.println(deleteData);
  
    
//    JsonPath js2= new JsonPath(deleteData);
//   String deleteStatus= js2.getString("status");
//   
//   assertEquals("OK", deleteStatus);
 
  
 

	}
	}


