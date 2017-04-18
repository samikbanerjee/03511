package jira.Dashboard;

import java.io.IOException;
import java.util.List;

import jira.Rest.Client.JiraClient;
import jira.Rest.Client.JiraIssue;


/**
 *
 */
public class AdHocQry
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final String jira_config = "PragitiJira.properties";
		final String jql = "project = MJS AND Sprint = 352";

		double sp = 0.0;
		final JiraClient jc = new JiraClient(jira_config);

		final List<JiraIssue> jiraIssues = jc.getJiraIssues(jql);
		for (final JiraIssue ji : jiraIssues)
		{
			System.out.println(ji.getAssignee() + "--" + ji.getIssueType() + "--" + ji.getKey() + "--" + ji.getPriority() + "--"
					+ ji.getReporter() + "--" + ji.getStatus() + "--" + ji.getStoryPoint());
			sp = sp + ji.getStoryPoint();
		}
		System.out.println("Total Story points :" + sp);

	}
}


//JIRA BOARD SNAPSHOT (Ticket counts)
//DEFECTS BY SEVERITY (Ticket counts)
//VELOCITY TRACKER (Sum of Story Points) -customfield_10004 story points
//NO OF RE-OPENS TO DATE (Ticket countss)
//Planned vs / actual resources