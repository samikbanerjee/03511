package jira.reports;

import jira.Rest.Client.JiraClient;
import jira.Rest.Client.JiraIssue;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.jayway.restassured.path.json.JsonPath;


/**
 *
 */
public class JqlToExcelSheet
{

	/**
	 * @param jira_Config_file
	 * @param sheet
	 * @param jiraQuery
	 * @return wite the report in sheet in the workbook and returns it
	 */
	public static XSSFSheet writeReportToSheet(final String jira_Config_file, final XSSFSheet sheet, final String jiraQuery)
	{

		final String endPointQuery = "search?jql=" + jiraQuery;

		XSSFRow row;
		Cell cell;

		//Report Layout
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("IssueType");

		cell = row.createCell(1);
		cell.setCellValue("Key");

		cell = row.createCell(2);
		cell.setCellValue("Summary");

		cell = row.createCell(3);
		cell.setCellValue("Assignee");

		cell = row.createCell(4);
		cell.setCellValue("Reporter");

		cell = row.createCell(5);
		cell.setCellValue("Priority");

		cell = row.createCell(6);
		cell.setCellValue("Status");

		try
		{
			//Get The total Jira issues from jql
			final JiraClient jc = new JiraClient(jira_Config_file);
			final String response = jc.getRestResponse(endPointQuery).asString();
			final int Total = JsonPath.from(response).getInt("total");

			//Iterate though issues and print  them in rows
			for (int rowId = 0; rowId < Total; rowId++)
			{
				row = sheet.createRow(rowId + 1);
				final JiraIssue is = new JiraIssue(response, rowId);


				cell = row.createCell(0);
				cell.setCellValue(is.getIssueType());

				cell = row.createCell(1);
				cell.setCellValue(is.getKey());

				cell = row.createCell(2);
				cell.setCellValue(is.getSummary());

				cell = row.createCell(3);
				cell.setCellValue(is.getAssignee());

				cell = row.createCell(4);
				cell.setCellValue(is.getReporter());

				cell = row.createCell(5);
				cell.setCellValue(is.getPriority());

				cell = row.createCell(6);
				cell.setCellValue(is.getStatus());
			}
		}
		catch (final Exception e)
		{
			cell = sheet.createRow(1).createCell(0);
			cell.setCellValue("Unable To get Results from JQL");
			cell = sheet.createRow(2).createCell(0);
			cell.setCellValue(e.getMessage());
		}

		return sheet;
	}
}
