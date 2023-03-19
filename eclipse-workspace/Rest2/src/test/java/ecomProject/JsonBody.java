package ecomProject;

public class JsonBody {

	
	
	public static String getJsonBody(String pId)
	{
		return "{\"orders\": [\r\n"
				+ "        {\r\n"
				+ "        \"country\": \"USA\", \r\n"
				+ "        \"productOrderedId\" : \""+pId+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
	}
}
