/**
 *
 */
package org.test.tools;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * @author Samik
 */
public class XLSReader implements Closeable
{
	FileInputStream fis;
	XSSFWorkbook workBook;
	XSSFSheet sheet;

	/**
	 * @param xlsFile
	 * @param sheetIndex
	 * @throws IOException
	 */
	public XLSReader(final String xlsFile, final int sheetIndex) throws IOException
	{
		fis = new FileInputStream(new File(xlsFile));
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheetAt(sheetIndex);
	}

	/**
	 * @param xlsFile
	 * @param sheetName
	 * @throws IOException
	 */
	public XLSReader(final String xlsFile, final String sheetName) throws IOException
	{
		fis = new FileInputStream(new File(xlsFile));
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
	}

	/**
	 * @param rownum
	 * @return returns the XSSF Row
	 */
	public XSSFRow getRow(final int rownum)
	{
		return sheet.getRow(rownum);
	}


	/**
	 * @param rownum
	 * @param cellnum
	 * @return returns the XSSF Cell Value
	 */
	public XSSFCell getCell(final int rownum, final int cellnum)
	{
		return sheet.getRow(rownum).getCell(cellnum);
	}

	/**
	 * @param colNum
	 * @return All Values within the given column
	 */
	public List<String> getValuesOfColumn(final int colNum)
	{
		final List<String> rowValues = new ArrayList<String>();
		final Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			final Row row = rows.next();
			rowValues.add(row.getCell(colNum).toString());
		}
		return rowValues;
	}


	/**
	 * @param rowNum
	 * @return All Values within the given column
	 */
	public List<String> getValuesOfRow(final int rowNum)
	{
		final List<String> colValues = new ArrayList<String>();
		final Iterator<Cell> cells = sheet.getRow(rowNum).cellIterator();
		while (cells.hasNext())
		{
			final Cell cell = cells.next();
			colValues.add(cell.toString());
		}
		return colValues;
	}

	/**
	 * @param searchString
	 * @param colWhereToSearch
	 * @return Row Numbers where string was found
	 */
	public List<Integer> getRowNumsContainingString(final String searchString, final int colWhereToSearch)
	{
		final List<Integer> rowNums = new ArrayList<Integer>();
		final Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			final Row row = rows.next();
			if (row.getCell(colWhereToSearch).toString().trim().equalsIgnoreCase(searchString))
			{
				rowNums.add(row.getRowNum());
			}
		}
		return rowNums;
	}

	/**
	 * @param searchString
	 * @param rowWhereToSearch
	 * @return Column Numbers where string was found
	 */
	public List<Integer> getColNumsContainingString(final String searchString, final int rowWhereToSearch)
	{
		final List<Integer> colNums = new ArrayList<Integer>();
		final Iterator<Cell> cells = sheet.getRow(rowWhereToSearch).cellIterator();
		while (cells.hasNext())
		{
			final Cell cell = cells.next();
			if (cell.toString().trim().equalsIgnoreCase(searchString))
			{
				colNums.add(cell.getColumnIndex());
			}
		}
		return colNums;
	}

	public void close() throws IOException
	{
		fis.close();
	}

}
