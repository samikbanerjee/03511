package jira.Rest.Client;

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
	private String customfield;
	private final int n;

	/**
	 * @param issueNum
	 */
	public JiraIssue(final int issueNum)
	{
		this.n = issueNum;
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
	 * @return the customfield
	 */
	public String getCustomfield()
	{
		return customfield;
	}

	/**
	 * @param jSonResponseOfjql
	 * @param jsonPathFromFields
	 */
	public void setCustomfield(final String jSonResponseOfjql, final String jsonPathFromFields)
	{
		customfield = checkJsonpathNotNull(jSonResponseOfjql, "issues[" + n + "]." + jsonPathFromFields, "Not Found");
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
