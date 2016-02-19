package org.test.tools;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;


/**
 * @author Samik
 */
public class ReadCSVDataFile implements Closeable
{

	CSVReader rdr;

	/**
	 * @param separator
	 * @param CSVFile
	 * @throws FileNotFoundException
	 */
	public ReadCSVDataFile(final char separator, final String CSVFile) throws FileNotFoundException
	{
		rdr = new CSVReader(new FileReader(CSVFile), separator);
	}


	/**
	 * @return A list of arrays where each array includes the column values
	 * @throws IOException
	 */
	public List<String[]> readAll() throws IOException
	{
		return rdr.readAll();
	}

	public void close() throws IOException
	{
		rdr.close();

	}
}
