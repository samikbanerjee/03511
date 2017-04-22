/**
 *
 */
package jira.Dashboard.Reporting.tools;

import java.io.IOException;
import java.util.List;

import jira.Rest.Client.JiraClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;


/**
 *
 */
public class JiraBoardSnapshot
{
	private static Logger log = LogManager.getLogger();

	/**
	 * @param sheet
	 * @param jc
	 * @param queryObjects
	 * @throws IOException
	 */
	public static void populateJiraBoard(final XSSFSheet sheet, final JiraClient jc, final List<QueryObject> queryObjects)
			throws IOException
	{
		//Copy - current  week to previous week
		for (final QueryObject queryObject : queryObjects)
		{
			final int currentWeekRow = queryObject.getPositionX() - 1;
			final int currentWeekCol = queryObject.getPositionY() - 1;
			final XSSFCell srcCell = sheet.getRow(currentWeekRow).getCell(currentWeekCol);

			final int previousWeekRow = currentWeekRow - 1;
			final int previousWeekCol = currentWeekCol;
			final XSSFCell tgtCell = sheet.getRow(previousWeekRow).getCell(previousWeekCol);
			tgtCell.copyCellFrom(srcCell, new CellCopyPolicy());
		}
		log.info("Completed copying 'current week data' to 'previous week data'");


		//Populate - current week
		AbsoluteTableUpdate.populateAbsoluteTable(sheet, jc, queryObjects);

	}
}
