package com.money.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.money.model.Account;

public class TransferServiceTest extends TestService{

    @Test
	public void testTransferMoney() throws URISyntaxException, ClientProtocolException, IOException {
    	
    	//Transfer 100 TRY (default currency of User 1) from User 1 to User 2. 
	    URI uri = builder.setPath("/transfer/100/from/1/to/2").build();
	    HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();   
        assertEquals(200, statusCode);     
	}
}
