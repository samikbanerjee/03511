package jira.Rest.Client;

import java.io.IOException;

import com.jayway.restassured.path.json.JsonPath;


/**
 *
 */
public class JiraIssue
{
	private final String IssueType;
	private final String Key;
	private final String Summary;
	private final String Assignee;
	private final String Reporter;
	private final String Priority;
	private final String Status;
	private final int n;


	/**
	 * @param jSonResponseOfjql
	 * @param issueNum
	 * @throws IOException
	 */
	public JiraIssue(final String jSonResponseOfjql, final int issueNum) throws IOException
	{
		this.n = issueNum;
		IssueType = JsonPath.from(jSonResponseOfjql).get("issues[" + n + "].fields.issuetype.name").toString();
		Key = JsonPath.from(jSonResponseOfjql).get("issues[" + n + "].key").toString();
		Summary = JsonPath.from(jSonResponseOfjql).get("issues[" + n + "].fields.summary").toString();
		Assignee = JsonPath.from(jSonResponseOfjql).get("issues[" + n + "].fields.assignee.name").toString();
		Reporter = JsonPath.from(jSonResponseOfjql).get("issues[" + n + "].fields.reporter.name").toString();
		Priority = JsonPath.from(jSonResponseOfjql).get("issues[" + n + "].fields.priority.name").toString();
		Status = JsonPath.from(jSonResponseOfjql).get("issues[" + n + "].fields.status.name").toString();
	}



	/**
	 * @return the issueType
	 */
	public String getIssueType()
	{
		return IssueType;
	}

	/**
	 * @return the key
	 */
	public String getKey()
	{
		return Key;
	}

	/**
	 * @return the summary
	 */
	public String getSummary()
	{
		return Summary;
	}


	/**
	 * @return the assignee
	 */
	public String getAssignee()
	{
		return Assignee;
	}

	/**
	 * @return the reporter
	 */
	public String getReporter()
	{
		return Reporter;
	}

	/**
	 * @return the priority
	 */
	public String getPriority()
	{
		return Priority;
	}


	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return Status;
	}

}
