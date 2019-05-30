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

public class TransferServiceTest {
	protected static Server server = null;
    protected static PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
	protected static HttpClient client;
    protected URIBuilder builder = new URIBuilder().setScheme("http").setHost("localhost:8080");
    protected ObjectMapper mapper = new ObjectMapper();
	
    @BeforeClass
    public static void setup() throws Exception {
        
        startServer();
        connManager.setDefaultMaxPerRoute(100);
        connManager.setMaxTotal(200);
        client= HttpClients.custom()
                .setConnectionManager(connManager)
                .setConnectionManagerShared(true)
                .build();

    }

    @AfterClass
    public static void closeClient() throws Exception {
        //server.stop();
        HttpClientUtils.closeQuietly(client);
    }


    private static void startServer() throws Exception {
        if (server == null) {
            server = new Server(8080);
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            server.setHandler(context);
            ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
            servletHolder.setInitParameter("jersey.config.server.provider.classnames",
                    UserService.class.getCanonicalName() + "," +
                            TransferService.class.getCanonicalName() + "," +
                            AccountService.class.getCanonicalName());
            server.start();
        }
    }
    
    @Test
	public void testTransferMoney() throws URISyntaxException, ClientProtocolException, IOException {
    	
    	//Transfer 100 TRY (default currency of User 1) from User 1 to User 2. 
	    URI uri = builder.setPath("/transfer/100/from/1/to/2").build();
	    HttpPost request = new HttpPost(uri);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        assertEquals(200, statusCode);
        
        
	}
	
	

}
