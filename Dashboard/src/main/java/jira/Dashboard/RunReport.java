/**
 *
 */
package jira.Dashboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 *
 */
public class RunReport
{
	private static final String JIRA_CONFIG = "PragitiJira.properties";
	private static final String BUGREPORTWORKBOOK = "E:/Cloud Shares/Box Sync/Box Sync/PQG - Shared Resources/WSR/Template/test2/WSR - Temp_02152017.xlsx";
	private static final String CURRENT_DT = "15-Feb";

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	public static void main(final String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException
	{

		//For NVI
		BugReportCreator.createBugReport("NVI_Bug_Dashboard_Config.csv", BUGREPORTWORKBOOK, "Project Dashboard", JIRA_CONFIG);
		ExecutionTrendCreator.createTrendReport("NVI_ExecutionTrend.properties", BUGREPORTWORKBOOK, JIRA_CONFIG, CURRENT_DT);

		//For SB2B
		BugReportCreator.createBugReport("SB2B_Bug_Dashboard_Config.csv", BUGREPORTWORKBOOK, "Project Dashboard", JIRA_CONFIG);
		ExecutionTrendCreator.createTrendReport("SB2B_ExecutionTrend.properties", BUGREPORTWORKBOOK, JIRA_CONFIG, CURRENT_DT);

		//For Aristotle
		BugReportCreator.createBugReport("ARSTL_Bug_Dashboard_Config.csv", BUGREPORTWORKBOOK, "Project Dashboard", JIRA_CONFIG);
		ExecutionTrendCreator.createTrendReport("ARSTL_ExecutionTrend.properties", BUGREPORTWORKBOOK, JIRA_CONFIG, CURRENT_DT);

		//MJ Dev

		//MJ Sustenance

		//Shimano Sustenance
		BugReportCreator.createBugReport("SB2CS_Bug_Dashboard_Config.csv", BUGREPORTWORKBOOK, "Project Dashboard", JIRA_CONFIG);
		ExecutionTrendCreator.createTrendReport("SB2CS_ExecutionTrend.properties", BUGREPORTWORKBOOK, JIRA_CONFIG, CURRENT_DT);

		//Solstice
		BugReportCreator.createBugReport("SOL_Bug_Dashboard_Config.csv", BUGREPORTWORKBOOK, "Project Dashboard", JIRA_CONFIG);
		ExecutionTrendCreator.createTrendReport("SOL_ExecutionTrend.properties", BUGREPORTWORKBOOK, JIRA_CONFIG, CURRENT_DT);

	}

}
