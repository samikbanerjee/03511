/**
 *
 */
package jira.Dashboard.Reporting.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import jira.Rest.Client.JiraClient;
import jira.Rest.Client.JiraIssue;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 */
public class CopyOfVelocityTrackerGen
{

	private static final String customField = "customfield_10004";
	private static final String jsonPathFromFields = "fields.customfield_10004";

	/**
	 * @param workBook
	 * @param workSheet
	 * @param jiraConfigFile
	 * @param reportConfigFile
	 * @throws IOException
	 */
	public static void populateSprintVelocities(final String workBook, final String workSheet, final String jiraConfigFile,
			final String reportConfigFile) throws IOException
	{
		//Create a Jira CLient
		final JiraClient jc = new JiraClient(jiraConfigFile);

		//Open the xlsx sheet for reading and updating
		final FileInputStream fsin = new FileInputStream(new File(workBook));
		final XSSFWorkbook wb = new XSSFWorkbook(fsin);
		final XSSFSheet sheet = wb.getSheet(workSheet);

		//Load Query Objects
		final QueryDataObjects queryDataObjects = new QueryDataObjects(reportConfigFile);
		final List<QueryObject> queryObjects = queryDataObjects.getQueryObjectsByModule("VT");

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


		//Write the sheet and close
		XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		fsin.close();
		final FileOutputStream fsout = new FileOutputStream(new File(workBook));
		wb.write(fsout);
		fsout.close();
		wb.close();
		System.out.println("completed writing for --Velcoity Trackers");

	}
}
