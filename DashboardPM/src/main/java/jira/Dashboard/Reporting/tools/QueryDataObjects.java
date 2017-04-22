package jira.Dashboard.Reporting.tools;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;


/**
 *
 */
public class QueryDataObjects
{
	private final Reader reader;
	private List<QueryObject> queryObjects;

	/**
	 * @param reportConfigFile
	 * @throws IOException
	 */
	public QueryDataObjects(final String reportConfigFile) throws IOException
	{
		final String file = System.getProperty("user.dir") + "/resources/" + reportConfigFile;
		reader = new FileReader(new File(file));
		this.setQueryObjects();
	}


	/**
	 * @param module
	 * @return List of Query objects - by module name
	 * @throws IOException
	 */
	public List<QueryObject> getQueryObjectsByModule(final String module) throws IOException
	{
		final List<QueryObject> queryObjects = this.getQueryObjects();
		final List<QueryObject> qO = new ArrayList<QueryObject>();
		for (final QueryObject queryObject : queryObjects)
		{
			if (queryObject.getModule().equalsIgnoreCase(module))
			{
				qO.add(queryObject);
			}
		}
		return qO;
	}

	/**
	 * @return the queryObjects
	 * @throws IOException
	 */
	public List<QueryObject> getQueryObjects() throws IOException
	{
		return this.queryObjects;
	}

	/**
	 * @throws IOException
	 */

	public void setQueryObjects() throws IOException
	{
		final CSVReader rdr = new CSVReader(reader, ';');
		final List<String[]> dataSet = rdr.readAll();
		rdr.close();
		final List<QueryObject> queryObjects = new ArrayList<QueryObject>();
		for (final String[] dataline : dataSet)
		{
			final QueryObject obj = new QueryObject();
			obj.setModule(dataline[0]);
			obj.setJql(dataline[1]);
			obj.setPositionX(Integer.parseInt(dataline[2]));
			obj.setPositionY(Integer.parseInt(dataline[3]));
			queryObjects.add(obj);
		}

		this.queryObjects = queryObjects;

	}
}
