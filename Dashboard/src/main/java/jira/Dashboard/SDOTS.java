package jira.Dashboard;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;


/**
 *
 */
public class SDOTS
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final String tsFile = "E:/Cloud Shares/Box Sync/Box Sync/Sustenance/SDO analysis/updated/ts/noida/Noida_ts_analysis.csv";
		final CSVReader rdr = new CSVReader(new FileReader(new File(tsFile)), ';');

		final List<String[]> lines = rdr.readAll();
		for (final String[] line : lines)
		{
			for (int i = 2; i < line.length; i++)
			{
				System.out.println(line[0] + ";" + line[1] + ";" + line[i]);
			}
		}
		rdr.close();

	}
}
