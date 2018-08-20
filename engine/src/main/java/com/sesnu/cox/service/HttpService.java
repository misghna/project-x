package com.sesnu.cox.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class HttpService {

	
	public String getData(String url) throws ClientProtocolException, IOException{
		StringBuffer result = new StringBuffer();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
//		HttpResponse response = client.execute(request,getHttpContext());
		HttpResponse response = client.execute(request);
		
		if(response.getStatusLine().getStatusCode()==200){
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			Header[] head = response.getAllHeaders();
//			for (Header header : head) {
//				System.out.println(header.getName() + "-" + (header.getValue()));
//			}
		}
		return result.toString();
	}
	
	private HttpContext getHttpContext(){
		CookieStore cookieStore = new BasicCookieStore(); 
		BasicClientCookie cookie = new BasicClientCookie("cookie", "B=9c43969d7v7l1&b=3&s=hj");
		cookie.setDomain("finance.yahoo.com");
		cookie.setPath("/");
		cookie.setAttribute(ClientCookie.DOMAIN_ATTR, "true");
		
		cookieStore.addCookie(cookie); 
		HttpContext localContext = new BasicHttpContext();
		localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
		return localContext;
	}
	
}
