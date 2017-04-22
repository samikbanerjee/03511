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

import org.apache.poi.xssf.usermodel.XSSFSheet;


/**
 *
 */
public class AdHocQry
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final String workBook = "E:\\Cloud Shares\\Box Sync\\Box Sync\\PMO WSR Auto\\WSR Template _Test.xlsx";
		final String workSheet = "Data and Instructions Sheet";
		final String reportConfigFile = "test.csv";
		//final String jql = "";
		final String jiraConfigFile = "PragitiJira.properties";

		//Initiate Jira Client
		final JiraClient jc = new JiraClient(jiraConfigFile);

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
		System.out.println("Starting work on: Jira Board Snapshot");
		JiraBoardSnapshot.populateJiraBoard(sheet, jc, queryObjectsJBS);
		System.out.println("Completed: Jira Board Snapshot");

		System.out.println("Starting work on: Defects By Severity");
		AbsoluteTableUpdate.populateAbsoluteTable(sheet, jc, queryObjectsDBS);
		System.out.println("Completed: Defects By Severity");

		System.out.println("Starting work on : Defect Density");
		CumultiveTableUpdate.populateCumultiveTable(sheet, jc, queryObjectsDDTD);
		System.out.println("Completed : Defect Density");

		System.out.println("Starting work on : Reopens To Date");
		CumultiveTableUpdate.populateCumultiveTable(sheet, jc, queryObjectsRTD);
		System.out.println("Completed : Reopens To Date");

		System.out.println("Starting work on: Velocity Tracker");
		VelocityTrackerGen.populateSprintVelocities(sheet, jc, queryObjectsVT);
		System.out.println("Completed : Velocity Tracker");

		//Write to excel
		xl.writeToSheetAndClose();

		System.out.println("Completed Writing Report");
	}
}


//JIRA BOARD SNAPSHOT (Ticket counts)
//DEFECTS BY SEVERITY (Ticket counts)
//VELOCITY TRACKER (Sum of Story Points) -customfield_10004 story points
//NO OF RE-OPENS TO DATE (Ticket countss)
//Planned vs / actual resources