package jira.reports.linkedIssuesReporting;

import java.io.IOException;

import jira.Rest.Client.JiraClient;

import com.jayway.restassured.response.Response;


/**
 *
 */
public class ATest
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final String qry = "issue/SHB2B-241";//SHB2B-337/MJB-1534";
		final String jira_Config_file = "PragitiJira.properties";
		final JiraClient jc = new JiraClient(jira_Config_file);
		final Response rsp = jc.getRestResponse(qry);
		final int issueLinks = rsp.jsonPath().getList("fields.issuelinks").size();
		for (int i = 0; i < issueLinks; i++)
		{
			System.out.print(rsp.jsonPath().getString("fields.issuelinks[" + i + "].type.inward"));
			System.out.println(rsp.jsonPath().getString("fields.issuelinks[" + i + "].inwardIssue.key"));
		}


	}
}
