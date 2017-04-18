/**
 *
 */
package jira.Dashboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import jira.Rest.Client.JiraClient;
import jira.Rest.Client.PropertyReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 */
public class ExecutionTrendCreator
{



	/**
	 * @param executionTrendProps
	 * @param bugReportWorkbook
	 * @param jiraConfig
	 * @param currentDT
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void createTrendReport(final String executionTrendProps, final String bugReportWorkbook,
			final String jiraConfig, final String currentDT) throws IOException, FileNotFoundException
	{
		//Open Properties File
		final PropertyReader prop = new PropertyReader(executionTrendProps);

		//Open the xlsx sheet for reading and updating
		final FileInputStream fsin = new FileInputStream(new File(bugReportWorkbook));
		final XSSFWorkbook wb = new XSSFWorkbook(fsin);
		final XSSFSheet sheet = wb.getSheet(prop.getPropertyValue("workbooksheet"));

		//Open the Jira Client for querying
		final JiraClient jc = new JiraClient(jiraConfig);

		//Find out Rows and cols to Write
		final int getStartRow = Integer.parseInt(prop.getPropertyValue("workbooksheet.startRow"));
		final int getStartColumn = getEmptyCell((getStartRow + 1), sheet);//go to next row and search for the first empty field

		//Update Date Field
		sheet.getRow(getStartRow).getCell(getStartColumn).setCellValue(currentDT);

		//Update Total Tickets
		final int totalTickets = jc.getIssueCount(prop.getPropertyValue("jql.totalTickets"));
		sheet.getRow(getStartRow + 1).getCell(getStartColumn).setCellValue(totalTickets);

		//Update Total Tickets assigned to QA
		final int ticketsInQAPlate = jc.getIssueCount(prop.getPropertyValue("jql.ticketsInQAPlate"));
		final int ticketsExecutedByQA = jc.getIssueCount(prop.getPropertyValue("jql.ticketsExecutedByQA"));
		final int ticketsAssignedToQA = ticketsInQAPlate + ticketsExecutedByQA;
		sheet.getRow(getStartRow + 2).getCell(getStartColumn).setCellValue(ticketsAssignedToQA);

		//Update Total Tickets Executed
		sheet.getRow(getStartRow + 3).getCell(getStartColumn).setCellValue(ticketsExecutedByQA);

		//Update Total Tickets Passed
		final int ticketsPassed = jc.getIssueCount(prop.getPropertyValue("jql.ticketsPassed"));
		sheet.getRow(getStartRow + 4).getCell(getStartColumn).setCellValue(ticketsPassed);




		//Write the sheet and close
		XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		fsin.close();
		final FileOutputStream fsout = new FileOutputStream(new File(bugReportWorkbook));
		wb.write(fsout);
		fsout.close();
		wb.close();
		System.out.println("completed writing execution trends for" + executionTrendProps);
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
