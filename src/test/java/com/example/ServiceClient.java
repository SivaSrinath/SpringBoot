package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			for (int i = 0; i < 20; i++) {
				URL url = new URL("http://localhost:9091/produce/jsonmessage");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");

				int min = 100;
				int max = 40000000;
				// Generate random double value from 200 to 400

				double random = Math.random() * (max - min + 1) + min;
				long number = (new Double(random)).longValue();
				System.out.println("Unique ID of the message is" + number);
				String input = "{\"id\":" + number + ",\"name\":\"some..\",\"rollnumber\":\"some..\"}";

				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();

				if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n for Message Number " + i);

				conn.disconnect();

			}

		} catch (Exception e) {

		}

	}

}
