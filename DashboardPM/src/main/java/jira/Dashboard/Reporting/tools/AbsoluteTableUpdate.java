package jira.Dashboard.Reporting.tools;

import java.io.IOException;
import java.util.List;

import jira.Rest.Client.JiraClient;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;


/**
 *
 */
public class AbsoluteTableUpdate
{
	/**
	 * @param sheet
	 * @param jc
	 * @param queryObjects
	 * @throws IOException
	 */
	public static void populateAbsoluteTable(final XSSFSheet sheet, final JiraClient jc, final List<QueryObject> queryObjects)
			throws IOException
	{


		//Loop through queries and update sheet
		for (final QueryObject qo : queryObjects)
		{
			final int i = qo.getPositionX() - 1;
			final int j = qo.getPositionY() - 1;
			final String jql = qo.getJql();
			System.out.println("Working on : " + jql);
			final int count = jc.getIssueCount(jql);
			final Cell cell = sheet.getRow(i).getCell(j);
			cell.setCellValue(count);

		}



	}
}
