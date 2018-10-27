package jsonparsing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PaseJsonUsingJSON {

	public String writeJson() {
		JSONObject jo = new JSONObject();
		jo.put("name", "Mat");

		Map<String, String> m = new LinkedHashMap<String, String>(4);
		m.put("street", "C-73");
		jo.put("address", m);

		JSONArray ja = new JSONArray();

		m = new LinkedHashMap<String, String>(2);
		m.put("mobile", "898768****");
		ja.add(m);

		m = new LinkedHashMap<String, String>(2);
		m.put("mobile", "998763****");
		ja.add(m);

		jo.put("phoneNumbers", ja);

		String jsonString = jo.toJSONString();
		return jsonString;
	}
	
	public void readJson(String jsonString) {
		JSONParser parser = new JSONParser(); try {
			JSONObject json = (JSONObject) parser.parse(jsonString);
			//TODO read values from json string using one by one
			System.out.print("\n\nreadJson JSON \n" + jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}