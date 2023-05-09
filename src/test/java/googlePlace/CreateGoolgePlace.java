package googlePlace;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.GoogleplacePayload;

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
	
String status=js.getString("status"); // Actual Result
System.out.println(status);

assertEquals("OK", status);


//Update address
String newAddress="Noida Sector 62";

String updateData=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").
body("{\r\n"
		+ "\"place_id\":\""+placeId+"\",\r\n"
		+ "\"address\":\""+newAddress+"\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n"
		+ "}").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).extract().response().asString();

    
  System.out.println(updateData);



//GetPlace Details

String getResponse= given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId).when().get("maps/api/place/get/json").then().
  assertThat().log().all().statusCode(200).extract().response().asString();
 System.out.println(getResponse);
 

 JsonPath js1= new JsonPath(getResponse);
  String address=js1.getString("address");
  System.out.println(address);
  
  assertEquals(newAddress, address);
  
  
 String deleteData= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\r\n"
  		+ "\r\n"
  		+ "    \"place_id\":"+placeId+"\r\n"
  		+ "}\r\n"
  		+ "").when().delete("maps/api/place/delete/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
  
 
  System.out.println(deleteData);
  
 
  
 

	}
	}


