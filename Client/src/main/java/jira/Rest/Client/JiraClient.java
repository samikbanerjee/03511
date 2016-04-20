package jira.Rest.Client;

import java.io.IOException;

import tools.ProjectConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;


/**
 * <p>
 * Provide Basic Authentication for Jira Login
 * </p>
 */
public class JiraClient
{
	private static final String JIRA_CONFIG_FILE = "PragitiJira.properties";
	private String userName;
	private String passWord;
	private String restAccessUrl;
	ProjectConfiguration config;

	/**
	 * @throws IOException
	 */
	public JiraClient() throws IOException
	{
		config = new ProjectConfiguration(JIRA_CONFIG_FILE);
	}

	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		this.setUserName();
		return userName;
	}

	/**
	 *
	 * the userName to set
	 */
	public void setUserName()
	{
		this.userName = config.getPropertyValue("jira.user");
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord()
	{
		this.setPassWord();
		return passWord;
	}

	/**
	 *
	 * the passWord to set
	 */
	public void setPassWord()
	{
		this.passWord = config.getPropertyValue("jira.password");
	}


	/**
	 * @return the restAccessUrl
	 */
	public String getRestAccessUrl()
	{
		this.setRestAccessUrl();
		return restAccessUrl;
	}

	/**
	 * the restAccessUrl to set
	 */
	public void setRestAccessUrl()
	{
		this.restAccessUrl = config.getPropertyValue("jira.url.main") + config.getPropertyValue("jira.url.rest");
	}


	/**
	 * @return Rest Assured authenticated request specification
	 */
	public RequestSpecification authenticated()
	{
		return RestAssured.given().auth().preemptive().basic(getUserName(), getPassWord());
	}


	/**
	 * @param issueAccessEndPoint
	 * @return response body
	 */
	public Response getRestResponse(final String issueAccessEndPoint)
	{
		return this.authenticated().get(getRestAccessUrl() + issueAccessEndPoint);
	}
}
