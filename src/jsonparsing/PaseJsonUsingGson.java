package jsonparsing;
import com.google.gson.Gson;

import jsonparsing.model.UserInfo;

public class PaseJsonUsingGson {
	
	public UserInfo parseToPojo(String jsonString) {

		Gson gson = new Gson();
		UserInfo userInfo = gson.fromJson(jsonString, UserInfo.class);

		return userInfo;

	}
	
	public String parseToJson(UserInfo userInfoObject) {

		Gson gson = new Gson();
		String jsonString = gson.toJson(userInfoObject);
		
		return jsonString;

	}
}