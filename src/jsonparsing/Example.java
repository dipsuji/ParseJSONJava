package jsonparsing;

import jsonparsing.model.UserInfo;

public class Example {

	public static void main(String[] args) {

		PaseJsonUsingJSON parserJson = new PaseJsonUsingJSON();
		String jsonString = parserJson.writeJson();
		System.out.print("JSON as string....\n" + jsonString);
		parserJson.readJson(jsonString);
		
		// using google gson
		PaseJsonUsingGson parser = new PaseJsonUsingGson();
		UserInfo userInfo = parser.parseToPojo(jsonString);
		System.out.print("\n\nJSON to java pojo class....\n" + userInfo);

		String originalString = parser.parseToJson(userInfo);
		System.out.print("\n\nJava to JSON as string....\n" + originalString);

	}
}
