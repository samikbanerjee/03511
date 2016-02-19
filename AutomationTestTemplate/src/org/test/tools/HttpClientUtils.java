package org.test.tools;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


/**
 * @author samik
 */
public class HttpClientUtils implements AutoCloseable
{
	HttpClient client;
	HttpResponse response;
	BufferedInputStream bis;

	/**
	 * @param uri
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpClientUtils(final String uri) throws ClientProtocolException, IOException
	{
		client = HttpClientBuilder.create().build();
		response = client.execute(new HttpGet(uri));
	}

	/**
	 * @return The requested page content in buffered Input Stream Format
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public BufferedInputStream getResponseForRequestURI() throws IllegalStateException, IOException
	{
		bis = new BufferedInputStream(response.getEntity().getContent());
		return bis;
	}

	/**
	 * @return response
	 */
	public HttpResponse getResponse()
	{
		return response;
	}

	public void close() throws Exception
	{
		bis.close();
	}

}
