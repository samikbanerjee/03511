package jira.Rest.Client;

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
public class HttpClientUtils
{
	HttpClient client;
	HttpResponse response;

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
		return new BufferedInputStream(response.getEntity().getContent());

	}

	/**
	 * @return response
	 */
	public HttpResponse getResponse()
	{
		return response;
	}

}
