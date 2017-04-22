/**
 *
 */
package jira.Dashboard.Reporting.tools;

import java.io.IOException;
import java.util.List;

import jira.Rest.Client.JiraClient;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;


/**
 *
 */
public class CumultiveTableUpdate
{
	/**
	 * @param sheet
	 * @param jc
	 * @param queryObjects
	 * @throws IOException
	 */
	public static void populateCumultiveTable(final XSSFSheet sheet, final JiraClient jc, final List<QueryObject> queryObjects)
			throws IOException
	{

		for (final QueryObject queryObject : queryObjects)
		{

			final String jql = queryObject.getJql();
			final int i = queryObject.getPositionX() - 1;
			final int j = getEmptyCell(i, sheet);

			System.out.println("Working on : " + jql);
			final int issueCount = jc.getIssueCount(jql);
			final Cell cl = sheet.getRow(i).getCell(j);
			cl.setCellValue(issueCount);
		}

	}

	/**
	 * @param rowNum
	 * @param sheet
	 * @return first empty cell value
	 */
	private static int getEmptyCell(final int rowNum, final XSSFSheet sheet)
	{
		final Row row = sheet.getRow(rowNum);
		int maxCellVal = 0;
		for (final Cell cell : row)
		{
			if (!cell.toString().equals(""))
			{
				maxCellVal = cell.getColumnIndex();
			}
		}
		return ++maxCellVal;
	}
}
