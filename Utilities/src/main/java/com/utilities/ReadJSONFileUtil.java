package com.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJSONFileUtil {
	
	public Object parseObject(JSONObject json, String key) {
		return json.get(key);
	}

	public Object getKey(JSONObject json, String key) {
		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;
		Object value = null;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {
					if (json.get(nextKeys) instanceof JSONObject) {
						if (exists == false) {
							getKey(json.getJSONObject(nextKeys), key);

						} else if (json.get(nextKeys) instanceof JSONArray) {
							JSONArray jsonarray = json.getJSONArray(nextKeys);
							for (int i = 0; i < jsonarray.length(); i++) {
								String jsonarrayString = jsonarray.get(i).toString();
								JSONObject innerJSON = new JSONObject(jsonarrayString);
								if (exists == false) {
									getKey(innerJSON, key);
								}
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			value = parseObject(json, key);
		}
		return value;
		
	}
	
	public JSONObject JSONFile (String jsonFilePath) throws IOException {
		String inputJSON = "";
		inputJSON = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		JSONObject inputJSONObject = new JSONObject(inputJSON);
		return inputJSONObject;
	}	
	
	/*public static void main(String[] args) throws IOException {
		
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\simpleJSONFile.json";
		
		String inputJSON = "";
		inputJSON = new String(Files.readAllBytes(Paths.get(path)));
		JSONObject inputJSONObject = new JSONObject(inputJSON);
		getKey(inputJSONObject, "company");
	}*/
}
