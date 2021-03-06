package jira.Rest.Client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;


/**
 * <p>
 * Provide Basic Authentication for Jira Login
 * </p>
 */
public class JiraClient
{
	private String userName;
	private String passWord;
	private String restAccessUrl;
	private String restAccessUrlFullIssues;
	private String restAccessUrlCustomField;
	PropertyReader config;

	/**
	 * @param jira_config_file
	 * @throws IOException
	 */
	public JiraClient(final String jira_config_file) throws IOException
	{
		config = new PropertyReader(jira_config_file);
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
		this.restAccessUrl = config.getPropertyValue("jira.url.rest") + config.getPropertyValue("jira.url.rest.search");
	}


	/**
	 * @return the restAccessUrlFullIssues
	 */
	public String getRestAccessUrlFullIssues()
	{
		this.setRestAccessUrlFullIssues();
		return restAccessUrlFullIssues;
	}

	/**
	 *
	 * the restAccessUrlFullIssues to set (returns full issues {costly})
	 */
	public void setRestAccessUrlFullIssues()
	{
		this.restAccessUrlFullIssues = config.getPropertyValue("jira.url.rest")
				+ config.getPropertyValue("jira.url.rest.searchIssues");
	}


	/**
	 * @param customField
	 * @return restAccessUrlCustomField
	 */
	public String getRestAccessUrlCustomField(final String customField)
	{
		this.setRestAccessUrlCustomField(customField);
		return restAccessUrlCustomField;
	}


	/**
	 * @param customField
	 */
	public void setRestAccessUrlCustomField(final String customField)
	{
		this.restAccessUrlCustomField = config.getPropertyValue("jira.url.rest") + "search?fields=" + customField
				+ "&maxResults=1000&jql=";
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
	 * @param fetchFullIssues
	 *           (false = just get the issue count of the jql ; true = get all the issue details {costly})
	 * @return response body
	 */
	public Response getRestResponse(final String issueAccessEndPoint, final boolean fetchFullIssues)
	{
		if (fetchFullIssues == false)
		{
			return this.authenticated().get(getRestAccessUrl() + issueAccessEndPoint);
		}
		else
		{
			return this.authenticated().get(getRestAccessUrlFullIssues() + issueAccessEndPoint);
		}

	}

	/**
	 * @param issueAccessEndPoint
	 * @param customField
	 * @return response body with just the requested custom field
	 */
	public Response getRestResponseCustomField(final String issueAccessEndPoint, final String customField)
	{
		return this.authenticated().get(getRestAccessUrlCustomField(customField) + issueAccessEndPoint);
	}


	/**
	 * @param jql
	 * @return List of Jira Issues (as defined) - {High Cost Query}
	 */
	public List<JiraIssue> getJiraIssues(final String jql)
	{
		final List<JiraIssue> jiraIssues = new ArrayList<JiraIssue>();
		final String resp = getRestResponse(jql, true).asString();
		final int totalIssues = JsonPath.from(resp).getInt("total");
		for (int i = 0; i < totalIssues; i++)
		{
			final JiraIssue ji = new JiraIssue(i);
			ji.setAssignee(resp);
			ji.setIssueType(resp);
			ji.setKey(resp);
			ji.setPriority(resp);
			ji.setReporter(resp);
			ji.setStatus(resp);
			ji.setSummary(resp);
			jiraIssues.add(ji);
		}
		return jiraIssues;
	}

	/**
	 * @param jql
	 * @param customField
	 * @param jsonPathFromFields
	 * @return List of Jira Issues (only for the requested custom field) - {High Cost Query}
	 */
	public List<JiraIssue> getJiraIssuesCustomField(final String jql, final String customField, final String jsonPathFromFields)
	{
		final List<JiraIssue> jiraIssues = new ArrayList<JiraIssue>();
		final String resp = getRestResponseCustomField(jql, customField).asString();
		final int totalIssues = JsonPath.from(resp).getInt("total");
		for (int i = 0; i < totalIssues; i++)
		{
			final JiraIssue ji = new JiraIssue(i);
			ji.setCustomfield(resp, jsonPathFromFields);
			jiraIssues.add(ji);
		}
		return jiraIssues;
	}

	/**
	 * @param jql
	 * @return issue count for the provided Jql
	 */
	public int getIssueCount(final String jql)
	{
		final String resp = this.getRestResponse(jql, false).asString();
		return JsonPath.from(resp).getInt("total");
	}

	/**
	 * @param jql
	 * @return search url
	 * @throws UnsupportedEncodingException
	 */
	public String getSearchUrl(final String jql) throws UnsupportedEncodingException
	{
		final String encodedUrl = URLEncoder.encode(jql, "UTF-8");
		return config.getPropertyValue("jira.url.search") + encodedUrl;
	}


}
