package jsonparsing;

import com.google.gson.Gson;

import jsonparsing.model.UserInfo;

public class ParseJsonUsingGson {

	/**
	 * Convert java object to json string
	 * 
	 * @param userInfoObject
	 * @return
	 */
	public String parseToJson(UserInfo userInfoObject) {

		Gson gson = new Gson();
		String jsonString = gson.toJson(userInfoObject);

		return jsonString;

	}

	/**
	 * Convert string to java object
	 * 
	 * @param jsonString
	 * @return
	 */
	public UserInfo parseToPojo(String jsonString) {

		Gson gson = new Gson();
		UserInfo userInfo = gson.fromJson(jsonString, UserInfo.class);

		return userInfo;

	}

}