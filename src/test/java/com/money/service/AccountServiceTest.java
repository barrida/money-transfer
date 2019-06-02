package com.money.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.money.dao.impl.AccountDaoImpl;
import com.money.model.Account;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AccountServiceTest extends TestService{


	@Test
	public void testGetAccount() throws URISyntaxException, ClientProtocolException, IOException {
	  	
	    URI uri = builder.setPath("/account/get/0").build();
	    HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);

        String jsonString = EntityUtils.toString(response.getEntity());
        Account account = mapper.readValue(jsonString, Account.class);
        assertEquals(3000, account.getBalance().intValue());
        
	}

	@Test
	public void testRemoveAccount() throws URISyntaxException, ClientProtocolException, IOException {
	    URI uri = builder.setPath("/account/remove").build();
	    HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        assertEquals(200, statusCode);
        AccountDaoImpl accountDao = new AccountDaoImpl();
        String jsonString = EntityUtils.toString(response.getEntity());
        assertEquals( "Last account remove. Total count: " + accountDao.getTotalAccountSize(), jsonString);        //assertEquals(4, account.getTotalAccountSize());
	}

	@Test
	public void testGetAccounts() throws URISyntaxException, ClientProtocolException, IOException {
	    URI uri = builder.setPath("/account/all").build();
	    HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);
        
        String jsonString = EntityUtils.toString(response.getEntity());
        Account[] accounts = mapper.readValue(jsonString, Account[].class);
        assertEquals(6, accounts.length);
	}

	@Test
	public void testSaveAccount() throws URISyntaxException, ClientProtocolException, IOException {

        URI uri = builder.setPath("/account/save").build();
        Account account = new Account(6, "XYZ", 32424255, 2354543, new BigDecimal(50000), "GBP");
        String jsonInString = mapper.writeValueAsString(account);
        StringEntity entity = new StringEntity(jsonInString);
        HttpPost request = new HttpPost(uri);
        request.setHeader("Content-type", "application/json");
        request.setEntity(entity);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertTrue(statusCode == 200);
        
        String jsonString = EntityUtils.toString(response.getEntity());
        assertEquals("Added Account with id=" + account.getAccountId(), jsonString);
 
	}

}
