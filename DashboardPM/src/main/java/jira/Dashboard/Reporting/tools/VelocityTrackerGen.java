/**
 *
 */
package jira.Dashboard.Reporting.tools;

import java.io.IOException;
import java.util.List;

import jira.Rest.Client.JiraClient;
import jira.Rest.Client.JiraIssue;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;


/**
 *
 */
public class VelocityTrackerGen
{

	private static final String customField = "customfield_10004";
	private static final String jsonPathFromFields = "fields.customfield_10004";

	/**
	 * @param sheet
	 * @param jc
	 * @param queryObjects
	 * @throws IOException
	 */
	public static void populateSprintVelocities(final XSSFSheet sheet, final JiraClient jc, final List<QueryObject> queryObjects)
			throws IOException
	{


		//Loop Through Queries and Write to Excel
		for (final QueryObject queryObject : queryObjects)
		{

			final String jql = queryObject.getJql();
			final int i = queryObject.getPositionX() - 1;
			final int j = queryObject.getPositionY() - 1;

			System.out.println("Working on :" + jql);

			final List<JiraIssue> jiraIssues = jc.getJiraIssuesCustomField(jql, customField, jsonPathFromFields);
			double sp = 0.0;

			for (final JiraIssue jiraIssue : jiraIssues)
			{
				double temp = 0.0;
				try
				{
					temp = Double.parseDouble(jiraIssue.getCustomfield());
				}
				catch (final Exception e)
				{
					temp = 0.0;
				}

				sp = sp + temp;
			}

			final Cell cl = sheet.getRow(i).getCell(j);
			cl.setCellValue(sp);
			System.out.println("Calculated Story Points for :" + jql);

		}


	}
}
