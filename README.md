
#Convert Java object to / from JSON (Gson)

PaseJsonUsingGson.java

Gson Dependency
<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.5</version>
		</dependency>
		
Convert Java object to JSON-
	public String parseToJson(UserInfo userInfoObject) {

		Gson gson = new Gson();
		String jsonString = gson.toJson(userInfoObject);
		
		return jsonString;

	}
	
Convert JSON to Java object
public UserInfo parseToPojo(String jsonString) {

		Gson gson = new Gson();
		UserInfo userInfo = gson.fromJson(jsonString, UserInfo.class);

		return userInfo;

	}


#Convert to jsong string using JSON/ parse JSON in Java

PaseJsonUsingJSON.java

Gson Dependency
<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
		<dependency>
			<groupId>com.googlecode.json-simple</groupId>
			<artifactId>json-simple</artifactId>
			<version>1.1.1</version>
		</dependency>
		
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
   
# Convert json string to Java pojo classes   
http://pojo.sodhanalibrary.com/

#Online view json - json formater

http://jsonviewer.stack.hu/