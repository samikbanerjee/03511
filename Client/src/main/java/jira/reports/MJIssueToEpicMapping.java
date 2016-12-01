/**
 *
 */
package jira.reports;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jira.Rest.Client.JiraClient;
import tools.ProjectConfiguration;

import com.jayway.restassured.path.json.JsonPath;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


/**
 *
 */
public class MJIssueToEpicMapping
{



	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final ProjectConfiguration ip = new ProjectConfiguration("IssueToEpicMapping.properties");

		final String jira_config_file = ip.getPropertyValue("jira_config_file");
		final String inputFile = ip.getPropertyValue("inputFile");
		final String outputFile = ip.getPropertyValue("outputFile");

		final List<String> issueKeys = populateIssueKeyListFromCSV(inputFile);

		final Map<String, String> iE = getIssueToEpic(jira_config_file, issueKeys);

		final List<String[]> outEntries = new ArrayList<String[]>();
		final List<String> issueKeySet = new ArrayList<String>(iE.keySet());
		Collections.sort(issueKeySet);
		for (final String issueKey : issueKeySet)
		{
			final String epic = iE.get(issueKey);
			final String mjStream = lookUpMJStream(epic);
			final String[] outEntry =
			{ issueKey, epic, mjStream };
			outEntries.add(outEntry);
		}

		printIssueEpicListToCSV(outputFile, outEntries);
		System.out.println("completed");

	}

	/**
	 * @param outputFile
	 * @param outEntries
	 * @throws IOException
	 */
	public static void printIssueEpicListToCSV(final String outputFile, final List<String[]> outEntries) throws IOException
	{
		final CSVWriter writer = new CSVWriter(new FileWriter(outputFile), '\t', CSVWriter.NO_QUOTE_CHARACTER);
		writer.writeAll(outEntries);
		writer.close();
	}

	/**
	 * @param inputFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return List of issue keys
	 */
	public static List<String> populateIssueKeyListFromCSV(final String inputFile) throws FileNotFoundException, IOException
	{
		final CSVReader rdr = new CSVReader(new FileReader(inputFile));
		final List<String> issueKeys = new ArrayList<String>();
		String[] nextLine;
		while ((nextLine = rdr.readNext()) != null)
		{
			issueKeys.add(nextLine[0]);
		}
		rdr.close();
		return issueKeys;
	}

	/**
	 * @param jira_config_file
	 * @param issueKeys
	 * @return Issue (Key) / Epic (Value)
	 * @throws IOException
	 */
	public static Map<String, String> getIssueToEpic(final String jira_config_file, final List<String> issueKeys)
			throws IOException
	{
		final Map<String, String> issueEpic = new HashMap<String, String>();
		final JiraClient jc = new JiraClient(jira_config_file);
		final String issuesStr = issueKeys.toString().replace("[", "").replace("]", "").trim();
		final String searchQry = "search?maxResults=1000&jql=Key in (" + issuesStr + ")";

		final String resp = jc.getRestResponse(searchQry).asString();
		final int count = JsonPath.from(resp).getInt("total");

		for (int i = 0; i < count; i++)
		{
			final String issueKey = JsonPath.from(resp).getString("issues[" + i + "].key");
			String epicValue = JsonPath.from(resp).getString("issues[" + i + "].fields.customfield_10200");
			if (epicValue == null)
			{
				epicValue = "null";
			}
			issueEpic.put(issueKey, epicValue);
		}
		return issueEpic;
	}

	/**
	 * @param epicKey
	 * @return MJ Stream
	 * @throws IOException
	 */
	public static String lookUpMJStream(final String epicKey) throws IOException
	{
		final ProjectConfiguration ip = new ProjectConfiguration("MJLookupStream.properties");
		final String stream = ip.getPropertyValue(epicKey, "Regular");
		return stream;
	}
}
