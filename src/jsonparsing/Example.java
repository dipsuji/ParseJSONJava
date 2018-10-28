package jsonparsing;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import jsonparsing.model.Address;
import jsonparsing.model.PhoneNumbers;
import jsonparsing.model.UserInfo;

/**
 * Example of converting json to java object, java object to json string,
 * writing on file, creating java object etc.
 * 
 * @author Suji
 *
 */
public class Example {

	public static void main(String[] args) {

		// very first i have java object
		UserInfo user = createDummyObject();

		// example using JSON
		// Step1 - a - convert java object to json string
		ParseJsonUsingJSON parserJson = new ParseJsonUsingJSON();
		String jsonString = parserJson.parseToJson(user);
		System.out.print("Using JSON - JSON as string....\n" + jsonString);

		// Step1 - b - convert jsong string to java object
		UserInfo originalObject = parserJson.parseToPojo(jsonString);
		System.out.println("\n\nUsing JSON - JSON to java pojo class....\\n" + originalObject);

		// Preferred approach- writing less code
		// example using google gson
		// Step2 a - java object to json string
		ParseJsonUsingGson parser = new ParseJsonUsingGson();
		String originalString = parser.parseToJson(user);
		System.out.print("\n\nUsing Gson JSON as string....\n" + originalString);

		// Step2 - b - convert jsong string to java object
		UserInfo userInfo = parser.parseToPojo(jsonString);
		System.out.print("\n\nUsing Gson JSON to java pojo class....\n" + userInfo);

		// just to save on file of json structure
		// writing josn on file
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter("json_example.json");
			printWriter.write(jsonString);
			printWriter.flush();
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create user dummy object
	 * 
	 * @return
	 */
	private static UserInfo createDummyObject() {
		UserInfo userInfo = new UserInfo();
		userInfo.setName("Harada");

		Address address = new Address();
		address.setStreet("B-453");
		userInfo.setAddress(address);

		PhoneNumbers[] phoneNumbers = new PhoneNumbers[2];
		PhoneNumbers ph = new PhoneNumbers();
		ph.setMobile("99887766**");
		phoneNumbers[0] = ph;
		ph = new PhoneNumbers();
		ph.setMobile("88007766**");
		phoneNumbers[1] = ph;
		userInfo.setPhoneNumbers(phoneNumbers);

		return userInfo;
	}
}
