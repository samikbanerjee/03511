package jira.Dashboard;

import java.io.IOException;
import java.util.List;

import jira.Dashboard.Reporting.tools.QueryDataObjects;
import jira.Dashboard.Reporting.tools.QueryObject;


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
		final QueryDataObjects qOs = new QueryDataObjects("test.csv");
		//final List<QueryObject> queries = qOs.getAllQueryObjects();
		final List<QueryObject> queries = qOs.getQueryObjectsByModule("c");
		for (final QueryObject queryObject : queries)
		{
			System.out.println(queryObject.getModule() + "--" + queryObject.getJql() + "--" + queryObject.getPositionX() + "--"
					+ queryObject.getPositionY());
		}

	}
}
