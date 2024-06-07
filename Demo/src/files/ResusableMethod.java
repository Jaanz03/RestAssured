package files;

import io.restassured.path.json.JsonPath;

public class ResusableMethod {

		public static JsonPath rawtojson(String Response) {
			JsonPath js1 = new JsonPath(Response);
			return js1;
		}
}
