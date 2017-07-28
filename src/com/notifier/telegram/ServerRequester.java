package com.notifier.telegram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.notifier.main.Main;

public class ServerRequester {
	
	private final String USER_AGENT = "Mozilla/5.0";
	private final Main plugin = new Main();
	
	public String requestJSON(String JSON , String server) throws IOException {
		String url = server + "/json=" + JSON;
		
		plugin.logger.Log("Sendind Request...");

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		//int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		plugin.logger.Log("Request Sended");
		return response.toString();
	}
}
