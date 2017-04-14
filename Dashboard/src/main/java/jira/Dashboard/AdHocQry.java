package jira.Dashboard;

import java.io.IOException;

import jira.Rest.Client.JiraClient;

import com.jayway.restassured.path.json.JsonPath;


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
		//		final String JQL = "project = SB2CS AND priority = Blocker AND status in (Open, \"In Progress\", Reopened, \"Request for input\", Blocked, Review, \"New ticket\", \"Issue Approval\", \"Ready for Build\", \"Pragiti QA\") AND priority = Blocker";
		//		final String last_updated = "30m";



		final String JQL_Act = "project = BZL";
		final JiraClient jc = new JiraClient("AmwayJira.properties");
		final int total = jc.getIssueCount(JQL_Act);
		final String resp = jc.getRestResponse(JQL_Act).asString();
		System.out.println(total);
		for (int i = 0; i < total; i++)
		{
			final String Key = JsonPath.from(resp).get("issues[" + i + "].key").toString();
			System.out.println(Key);
		}


	}
}
