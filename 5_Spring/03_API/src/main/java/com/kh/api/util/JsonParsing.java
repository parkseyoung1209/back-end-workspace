package com.kh.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsing {

	public static void main(String[] args) throws Exception {
		String serviceKey = "MOmc4pnuSb6E4R1i%2FJgiyDjUfl9B1M4bj7Nm70gfN1ix4FVXqM3bTSrvJAXYnXRKsqx4CVXGNxC%2BMmSpoN%2FwtA%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey="+ serviceKey+ "&pageNo=1&numOfRows=10&resultType=json";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line = null;
		
		StringBuffer responseBuffer = new StringBuffer();
		
		while((line = br.readLine())!=null) {
			responseBuffer.append(line);
		}
		br.close();
		urlConnection.disconnect();
		
		String responseData = responseBuffer.toString();
		System.out.println(responseData);
		
		JSONObject jsonResponse = new JSONObject(responseData);
		
		JSONObject jsonData = jsonResponse.getJSONObject("getFoodKr");
		System.out.println(jsonData);
		
		JSONArray items = jsonData.getJSONArray("item");
		
		for(int i =0; i <items.length(); i++) {
			JSONObject result = items.getJSONObject(i);
			System.out.println(result.getString("MAIN_TITLE"));
			System.out.println(result.getDouble("LNG"));
			System.out.println(result.getDouble("LAT"));
		}
	}

}
