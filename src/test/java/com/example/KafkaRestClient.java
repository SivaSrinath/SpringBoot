package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class KafkaRestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// http://localhost:8080/RESTfulExample/json/product/post

		try {

			// https://www.opencodez.com/java/implement-2-way-authentication-using-ssl.htm
			System.setProperty("javax.net.debug", "all");
			System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
			System.setProperty("https.protocols", "TLSv1.2");
			System.setProperty("javax.net.ssl.trustStore", "c://core-jks//MyClient.jks");
			System.setProperty("javax.net.ssl.trustStorePassword", "password");
			System.setProperty("javax.net.ssl.keyStore", "c://core-jks//MyClient.jks");
			System.setProperty("javax.net.ssl.keyStorePassword", "password");

			URL url = new URL("http://localhost:8080/RESTfulExample/json/product/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"qty\":100,\"name\":\"iPad 4\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
