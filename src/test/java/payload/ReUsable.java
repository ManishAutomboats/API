package payload;

import io.restassured.path.json.JsonPath;

public class ReUsable {
	
	public static JsonPath rawToJson(String response) {
		
		JsonPath js= new JsonPath(response);
		return js;
		//test
	}

}
