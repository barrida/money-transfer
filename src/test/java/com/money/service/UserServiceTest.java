package com.money.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.money.model.Account;
import com.money.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest extends TestService{

	@Test
	public void testGetUser() throws URISyntaxException, ClientProtocolException, IOException {
	    URI uri = builder.setPath("/user/get/0").build();
	    HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);

        String jsonString = EntityUtils.toString(response.getEntity());
        User user = mapper.readValue(jsonString, User.class);
        assertEquals("Suleyman", user.getName());

	}

	@Test
	public void testRemoveUser() throws URISyntaxException, ClientProtocolException, IOException {
	    URI uri = builder.setPath("/user/remove").build();
	    HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);

        String jsonString = EntityUtils.toString(response.getEntity());        
        assertEquals("Last user remove. Total count: 1", jsonString);
	}

	@Test
	public void testGetUsers() throws URISyntaxException, ClientProtocolException, IOException {
	    URI uri = builder.setPath("/user/all").build();
	    HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);

        String jsonString = EntityUtils.toString(response.getEntity());
        User[] user = mapper.readValue(jsonString, User[].class);
        assertTrue(user.length == 2);
	}

	@Test
	public void testSaveUser() throws URISyntaxException, ClientProtocolException, IOException{
	    URI uri = builder.setPath("/user/save").build();
	    User user = new User(3, "Tomis", "Yildirim", "2015", "asdasd", "Turkey", "35456", "dummy address", "userNew@hotmail.com");
	    String jsonInString = mapper.writeValueAsString(user);
        StringEntity entity = new StringEntity(jsonInString);
        HttpPost request = new HttpPost(uri);
        request.setHeader("Content-type", "application/json");
        request.setEntity(entity);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();    
        assertTrue(statusCode == 200);
 
        String jsonString = EntityUtils.toString(response.getEntity());
        assertEquals("Added User with id=" + user.getUserId(), jsonString);

	}

}
