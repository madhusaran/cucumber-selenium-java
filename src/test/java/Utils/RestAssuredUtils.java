package Utils;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredUtils {
	private JSONutils js = new JSONutils();
	
	public RestAssuredUtils(String BaseUrl) {
		RestAssured.baseURI = BaseUrl;
	}

	public Response POST(String path, Map<String,String> reqObj) throws JsonProcessingException {
		String jsonString = js.creatJSONObject(reqObj);
		LoggerUtil.getLogger().info(jsonString);
		return RestAssured.given().contentType(ContentType.JSON).body(jsonString).post(path);
	}
	
	public Response GET(String path, String token) throws JsonProcessingException {
		return RestAssured.given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).when().get(path);
	}

}
