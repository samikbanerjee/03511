package jira.Dashboard.Reporting.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 */
public class ExcelReportWriter
{
	private FileInputStream fsin;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;

	private final String workBook;
	private final String workSheet;

	/**
	 * @param workBook
	 * @param workSheet
	 */
	public ExcelReportWriter(final String workBook, final String workSheet)
	{
		this.workBook = workBook;
		this.workSheet = workSheet;
	}


	/**
	 * @throws IOException
	 *            Open the xlsx sheet for reading and updating
	 */
	public void openExcelForEditing() throws IOException
	{

		fsin = new FileInputStream(new File(workBook));
		wb = new XSSFWorkbook(fsin);
		sheet = wb.getSheet(workSheet);
	}

	/**
	 * @return Sheet to read / write / update
	 */
	public XSSFSheet getSheet()
	{
		return sheet;
	}

	/**
	 * @throws IOException
	 *            Write to the sheet and close
	 */
	public void writeToSheetAndClose() throws IOException
	{
		XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		fsin.close();
		final FileOutputStream fsout = new FileOutputStream(new File(workBook));
		wb.write(fsout);
		fsout.close();
		wb.close();
	}
}
