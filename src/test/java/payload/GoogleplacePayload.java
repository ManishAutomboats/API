package payload;

public class GoogleplacePayload {
	
	
	public static String createPlaceDeatils() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
		
	}
	
	public static String updateAddressDetails() {
		return "\"{\\r\\n\"\r\n"
				+ "		+ \"\\\"place_id\\\":\\\"\"+placeId+\"\\\",\\r\\n\"\r\n"
				+ "		+ \"\\\"address\\\":\\\"\"+newAddress+\"\\\",\\r\\n\"\r\n"
				+ "		+ \"\\\"key\\\":\\\"qaclick123\\\"\\r\\n\"\r\n"
				+ "		+ \"}\"";
		
		
	}

}
