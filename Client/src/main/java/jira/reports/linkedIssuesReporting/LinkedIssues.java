package jira.reports.linkedIssuesReporting;

import java.util.List;


/**
 *
 */
public class LinkedIssues
{
	private String issueId;
	private String issueSummary;
	private List<String> linkedIssues;

	/**
	 * @return the issueId
	 */
	public String getIssueId()
	{
		return issueId;
	}

	/**
	 * @param issueId
	 *           the issueId to set
	 */
	public void setIssueId(final String issueId)
	{
		this.issueId = issueId;
	}

	/**
	 * @return the issueSummary
	 */
	public String getIssueSummary()
	{
		return issueSummary;
	}

	/**
	 * @param issueSummary
	 *           the issueSummary to set
	 */
	public void setIssueSummary(final String issueSummary)
	{
		this.issueSummary = issueSummary;
	}

	/**
	 * @return the linkedIssues
	 */
	public List<String> getLinkedIssues()
	{
		return linkedIssues;
	}

	/**
	 * @param linkedIssues
	 *           the linkedIssues to set
	 */
	public void setLinkedIssues(final List<String> linkedIssues)
	{
		this.linkedIssues = linkedIssues;
	}
}
