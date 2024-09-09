package Utils;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONutils {

	ObjectMapper mapper = new ObjectMapper();
	
	JsonNode jsonObj;
	
	public String creatJSONObject(Map<String,String> data) throws JsonProcessingException {
		jsonObj = mapper.valueToTree(data);
		String Jb = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObj);
		return Jb;
	}
	
}
