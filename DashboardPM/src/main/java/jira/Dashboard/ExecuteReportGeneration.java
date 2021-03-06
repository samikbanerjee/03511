package jira.Dashboard;

import java.io.IOException;
import java.util.List;

import jira.Dashboard.Reporting.tools.AbsoluteTableUpdate;
import jira.Dashboard.Reporting.tools.CumultiveTableUpdate;
import jira.Dashboard.Reporting.tools.ExcelReportWriter;
import jira.Dashboard.Reporting.tools.JiraBoardSnapshot;
import jira.Dashboard.Reporting.tools.QueryDataObjects;
import jira.Dashboard.Reporting.tools.QueryObject;
import jira.Dashboard.Reporting.tools.VelocityTrackerGen;
import jira.Rest.Client.JiraClient;
import jira.Rest.Client.PropertyReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;


/**
 *
 */
public class ExecuteReportGeneration
{

	private static Logger log = LogManager.getLogger();
	private static final String BASE_PROPERTIES = "base.properties";

	/**
	 * @param args
	 */


	public static void main(final String[] args)
	{
		try
		{
			final PropertyReader prop = new PropertyReader(BASE_PROPERTIES);

			final String workBook = prop.getPropertyValue("report.excelbook");
			final String workSheet = prop.getPropertyValue("report.excelbook.worksheet");
			final String reportConfigFile = prop.getPropertyValue("report.query.config");

			//Initiate Jira Client
			final JiraClient jc = new JiraClient(BASE_PROPERTIES);

			//Load Queries
			final QueryDataObjects queryDataObjects = new QueryDataObjects(reportConfigFile);

			final List<QueryObject> queryObjectsVT = queryDataObjects.getQueryObjectsByModule("VT");
			final List<QueryObject> queryObjectsDDTD = queryDataObjects.getQueryObjectsByModule("DDTD");
			final List<QueryObject> queryObjectsRTD = queryDataObjects.getQueryObjectsByModule("RTD");
			final List<QueryObject> queryObjectsDBS = queryDataObjects.getQueryObjectsByModule("DBS");
			final List<QueryObject> queryObjectsJBS = queryDataObjects.getQueryObjectsByModule("JBS");


			//	Open excel file
			final ExcelReportWriter xl = new ExcelReportWriter(workBook, workSheet);
			xl.openExcelForEditing();
			final XSSFSheet sheet = xl.getSheet();

			//Write Report
			log.info("Starting work on: Jira Board Snapshot");
			JiraBoardSnapshot.populateJiraBoard(sheet, jc, queryObjectsJBS);
			log.info("Completed: Jira Board Snapshot");

			log.info("Starting work on: Defects By Severity");
			AbsoluteTableUpdate.populateAbsoluteTable(sheet, jc, queryObjectsDBS);
			log.info("Completed: Defects By Severity");

			log.info("Starting work on : Defect Density");
			CumultiveTableUpdate.populateCumultiveTable(sheet, jc, queryObjectsDDTD);
			log.info("Completed : Defect Density");

			log.info("Starting work on : Reopens To Date");
			CumultiveTableUpdate.populateCumultiveTable(sheet, jc, queryObjectsRTD);
			log.info("Completed : Reopens To Date");

			log.info("Starting work on: Velocity Tracker");
			VelocityTrackerGen.populateSprintVelocities(sheet, jc, queryObjectsVT);
			log.info("Completed : Velocity Tracker");

			//Write to excel
			xl.writeToSheetAndClose();

			log.info("Completed Writing Report");
		}
		catch (final IOException e)
		{
			log.fatal(e.getMessage());
			;
		}
	}
}
