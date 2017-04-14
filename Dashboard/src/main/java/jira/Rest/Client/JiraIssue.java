package jira.Rest.Client;

import java.io.IOException;

import com.jayway.restassured.path.json.JsonPath;




/**
 *
 */
public class JiraIssue
{
	private String IssueType;
	private String Key;
	private String Summary;
	private String Assignee;
	private String Reporter;
	private String Priority;
	private String Status;
	private double StoryPoint;
	private final int n;

	/**
	 * @param jSonResponseOfjql
	 * @param issueNum
	 * @throws IOException
	 */
	public JiraIssue(final String jSonResponseOfjql, final int issueNum) throws IOException
	{
		this.n = issueNum;
		setIssueType(jSonResponseOfjql);
		setKey(jSonResponseOfjql);
		setSummary(jSonResponseOfjql);
		setAssignee(jSonResponseOfjql);
		setReporter(jSonResponseOfjql);
		setPriority(jSonResponseOfjql);
		setStatus(jSonResponseOfjql);
		setStoryPoint(jSonResponseOfjql);
	}

	/**
	 * @return the issueType
	 */
	public String getIssueType()
	{
		return IssueType;
	}


	/**
	 * @param jSonResponseOfjql
	 */
	public void setIssueType(final String jSonResponseOfjql)
	{
		IssueType = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].fields.issuetype.name", "IssueType Not Found");
	}


	/**
	 * @return the key
	 */
	public String getKey()
	{
		return Key;
	}


	/**
	 * @param jSonResponseOfjql
	 */
	public void setKey(final String jSonResponseOfjql)
	{
		Key = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].key", "Key Not Found");
	}


	/**
	 * @return the summary
	 */
	public String getSummary()
	{
		return Summary;
	}


	/**
	 * @param jSonResponseOfjql
	 */
	public void setSummary(final String jSonResponseOfjql)
	{
		Summary = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].fields.summary", "Summary Not Found");
	}


	/**
	 * @return the assignee
	 */
	public String getAssignee()
	{
		return Assignee;
	}


	/**
	 * @param jSonResponseOfjql
	 */
	public void setAssignee(final String jSonResponseOfjql)
	{
		Assignee = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].fields.assignee.name", "Assignee Not Found");
	}

	/**
	 * @return the reporter
	 */
	public String getReporter()
	{
		return Reporter;
	}


	/**
	 * @param jSonResponseOfjql
	 */
	public void setReporter(final String jSonResponseOfjql)
	{
		Reporter = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].fields.reporter.name", "Reporter Not Found");
	}


	/**
	 * @return the priority
	 */
	public String getPriority()
	{
		return Priority;
	}


	/**
	 * @param jSonResponseOfjql
	 *           the priority to set
	 */
	public void setPriority(final String jSonResponseOfjql)
	{
		Priority = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].fields.priority.name", "Priority Not Found");
	}


	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return Status;
	}


	/**
	 * @param jSonResponseOfjql
	 *           the status to set
	 */
	public void setStatus(final String jSonResponseOfjql)
	{
		Status = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].fields.status.name", "Status Not found");
	}


	/**
	 * @return the storyPoint
	 */
	public double getStoryPoint()
	{
		return StoryPoint;
	}


	/**
	 * @param jSonResponseOfjql
	 *           the storyPoint to set
	 */
	public void setStoryPoint(final String jSonResponseOfjql)
	{
		final String temp = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "].fields.customfield_10004", "0");
		StoryPoint = Double.parseDouble(temp);
	}

	private String checkJsonpathNotNull(final String jSonResponseOfjql, final String jsonPathToCheck,
			final String defaultValueIfNull)
	{
		if (JsonPath.from(jSonResponseOfjql).get(jsonPathToCheck) == null)
		{
			return defaultValueIfNull;
		}
		else
		{
			return JsonPath.from(jSonResponseOfjql).get(jsonPathToCheck).toString();
		}



	}
}
