package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import Utils.ReadConfig;
import Utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class ApiTest {
	private String API_BASE_URL = ReadConfig.getProperty("apiBaseURL");
	private String API_USERNAME = ReadConfig.getProperty("apiUserName");
	private String API_PASS = ReadConfig.getProperty("apiPass");
	private RestAssuredUtils restAssured = new RestAssuredUtils(API_BASE_URL);
	private Response response;
	
	
	@Given("I send a POST request to {string}")
	public void i_send_a_post_request_to(String path) throws JsonProcessingException {
		// create
		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("email", API_USERNAME);
		reqMap.put("password", API_PASS);
		// execute
		response = restAssured.POST(path,reqMap);
	}

	@Given("I send a GET request to {string} with token")
	public void i_send_a_get_request_to_with_token(String path) throws JsonProcessingException {
		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("email", API_USERNAME);
		reqMap.put("password", API_PASS);
		// preExecute
		Response login = restAssured.POST("/users/login",reqMap);
		String token  = login.jsonPath().getString("token");
		//execute
		response = restAssured.GET(path, token);
	}
	
	
	@Then("the response code should be {int}")
	public void the_response_code_should_be(int statusCode) {
		int status = response.getStatusCode();
		assertEquals(status, statusCode);
	}

	@And("response should contain the key {string}")
	public void response_should_contain_the_key(String key) {
		assertTrue(response.jsonPath().get(key) != null);
	}

}
