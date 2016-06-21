package jira.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jira.Rest.Client.JiraClient;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tools.ProjectConfiguration;

import com.jayway.restassured.path.json.JsonPath;
import com.opencsv.CSVReader;



/**
 *
 */
public class CountAnalysisReport
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final ProjectConfiguration ip = new ProjectConfiguration("CountAnalysisReport.properties");
		final DateFormat dateFormat = new SimpleDateFormat("MMddyyHHmm");
		final String outputFileNm = ip.getPropertyValue("file.out.report") + "_" + dateFormat.format(new Date()) + ".xlsx";
		final String jira_config_file = ip.getPropertyValue("jira.config.file");

		final String csvFile = System.getProperty("user.dir") + ip.getPropertyValue("file.in.qaEntries");
		final CSVReader rdr = new CSVReader(new FileReader(csvFile), ';');
		final List<String[]> qaEntries = rdr.readAll();
		rdr.close();

		final XSSFWorkbook book = new XSSFWorkbook();
		final XSSFSheet sheet = book.createSheet(ip.getPropertyValue("worksheet.name"));

		int rowId = 0;
		Cell cell;
		Row row;
		for (final String[] qaEntry : qaEntries)
		{
			row = sheet.createRow(rowId);
			cell = row.createCell(0);
			cell.setCellValue(qaEntry[0]);

			final JiraClient jc = new JiraClient(jira_config_file);
			final String endPointQuery = "search?jql=" + qaEntry[1];
			final String resp = jc.getRestResponse(endPointQuery).asString();
			final int Count = JsonPath.from(resp).getInt("total");

			cell = row.createCell(1);
			cell.setCellValue(Count);
			System.out.println("Completed fetching for :" + qaEntry[0]);

			rowId++;
		}


		final FileOutputStream out = new FileOutputStream(new File(outputFileNm));
		book.write(out);
		out.close();
		book.close();
		System.out.println("Completed writing book: " + outputFileNm);

	}
}
