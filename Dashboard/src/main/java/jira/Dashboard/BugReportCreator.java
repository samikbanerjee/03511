/**
 *
 */
package jira.Dashboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import jira.Rest.Client.JiraClient;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;


/**
 *
 */
public class BugReportCreator
{


	/**
	 * @param bugReportConfigFile
	 * @param bugReportWorkbook
	 * @param bugReportSheet
	 * @param jiraConfig
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void createBugReport(final String bugReportConfigFile, final String bugReportWorkbook,
			final String bugReportSheet, final String jiraConfig) throws IOException, FileNotFoundException,
			UnsupportedEncodingException
	{
		// Load the jql queries
		final List<String[]> jqlDataSet = loadQueryDataSet(bugReportConfigFile);

		//Open the xlsx sheet for reading and updating
		final FileInputStream fsin = new FileInputStream(new File(bugReportWorkbook));
		final XSSFWorkbook wb = new XSSFWorkbook(fsin);
		final XSSFSheet sheet = wb.getSheet(bugReportSheet);

		//Open the Jira Client for querying
		final JiraClient jc = new JiraClient(jiraConfig);

		//Loop through the queries and update the excel sheet
		for (final String[] jqlDataLine : jqlDataSet)
		{
			updateCell(wb, sheet, jc, jqlDataLine);
		}

		//Write the sheet and close
		XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		fsin.close();
		final FileOutputStream fsout = new FileOutputStream(new File(bugReportWorkbook));
		wb.write(fsout);
		fsout.close();
		wb.close();
		System.out.println("completed writing for --" + bugReportConfigFile);
	}

	/**
	 * @param wb
	 * @param sheet
	 * @param jc
	 * @param jqlDataLine
	 * @throws UnsupportedEncodingException
	 */
	private static void updateCell(final XSSFWorkbook wb, final XSSFSheet sheet, final JiraClient jc, final String[] jqlDataLine)
			throws UnsupportedEncodingException
	{
		final String jql = jqlDataLine[0];
		final int i = Integer.parseInt(jqlDataLine[1]);
		final int j = Integer.parseInt(jqlDataLine[2]);
		final Cell cl = sheet.getRow(i).getCell(j);

		final int cnt = jc.getIssueCount(jql);
		final String searchUrl = jc.getSearchUrl(jql);

		cl.setCellValue(cnt);
		final Hyperlink hl = wb.getCreationHelper().createHyperlink(Hyperlink.LINK_URL);
		hl.setAddress(searchUrl);
		cl.setHyperlink(hl);
		System.out.println("complelted cell ->(" + i + "," + j + ")");
	}

	/**
	 * @param bugReportConfigFile
	 * @return Load and Return the Query Data Set
	 * @throws IOException
	 */
	private static List<String[]> loadQueryDataSet(final String bugReportConfigFile) throws IOException
	{
		final String file = System.getProperty("user.dir") + "/resources/" + bugReportConfigFile;
		final Reader reader = new FileReader(new File(file));
		final CSVReader rdr = new CSVReader(reader, ';');
		final List<String[]> dataSet = rdr.readAll();
		rdr.close();
		return dataSet;
	}

}
