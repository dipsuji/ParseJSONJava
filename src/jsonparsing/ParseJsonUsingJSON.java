package jsonparsing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import jsonparsing.model.PhoneNumbers;
import jsonparsing.model.UserInfo;

public class ParseJsonUsingJSON {

	/**
	 * Convert java object to json string
	 * 
	 * @param userInfoObject
	 * @return
	 */
	public String parseToJson(UserInfo userInfoObject) {
		JSONObject jo = new JSONObject();
		// adding name
		jo.put("name", userInfoObject.getName());

		Map<String, String> m = new LinkedHashMap<String, String>(4);
		// adding address
		m.put("street", userInfoObject.getAddress().getStreet());
		jo.put("address", m);

		JSONArray ja = new JSONArray();
		// adding mobile numbers
		PhoneNumbers[] phs = userInfoObject.getPhoneNumbers();
		for (PhoneNumbers pn : phs) {
			m = new LinkedHashMap<String, String>(2);
			m.put("mobile", pn.getMobile());
			ja.add(m);
		}
		jo.put("phoneNumbers", ja);

		// getting json string from java json object
		String jsonString = jo.toJSONString();

		return jsonString;

	}

	/**
	 * Convert string to java object
	 * 
	 * @param jsonString
	 * @return
	 */
	public UserInfo parseToPojo(String jsonString) {
		JSONParser parser = new JSONParser();
		UserInfo user = new UserInfo();
		try {

			JSONObject json = (JSONObject) parser.parse(jsonString);
			String name = (String) json.get("name");
			user.setName(name);
			// TODO read values from json string using one by one
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return user;
	}

}