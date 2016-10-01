package jira.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tools.ProjectConfiguration;

import com.opencsv.CSVReader;


/**
 *
 */
public class DailyActivityReport
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final ProjectConfiguration ip = new ProjectConfiguration("DailyActivityReport.properties");
		final DateFormat dateFormat = new SimpleDateFormat("MMddyyHHmm");
		final String outputFileNm = ip.getPropertyValue("file.out.report") + "_" + dateFormat.format(new Date()) + ".xlsx";
		final String jira_config_file = ip.getPropertyValue("jira.config.file");

		final String csvFile = System.getProperty("user.dir") + ip.getPropertyValue("file.in.qaEntries");
		final CSVReader rdr = new CSVReader(new FileReader(csvFile), ';');
		final List<String[]> qaEntries = rdr.readAll();
		rdr.close();

		final XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet;

		for (final String[] qaEntry : qaEntries)
		{
			sheet = book.createSheet(qaEntry[0]);
			sheet = JqlToExcelSheet.writeReportToSheet(jira_config_file, sheet, qaEntry[1]);
			System.out.println("Completed fetching report for : " + qaEntry[0]);
		}

		final FileOutputStream out = new FileOutputStream(new File(outputFileNm));
		book.write(out);
		out.close();
		book.close();
		System.out.println("Completed writing book: " + outputFileNm);
	}
}
