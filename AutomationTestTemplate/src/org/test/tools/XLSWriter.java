/**
 *
 */
package org.test.tools;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * @author samik
 */
public class XLSWriter implements Closeable
{
	String xlsFile;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook workBook;
	XSSFSheet sheet;

	
	public enum CellProperties
	{
		HYPERLINK, COMMENTS
	}


	/**
	 * @param xlsFile
	 * @param sheetIndex
	 * @throws IOException
	 */
	public XLSWriter(final String xlsFile, final int sheetIndex) throws IOException
	{
		this.xlsFile = xlsFile;
		fis = new FileInputStream(new File(this.xlsFile));
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheetAt(sheetIndex);
	}

	/**
	 * @param xlsFile
	 * @param sheetName
	 * @throws IOException
	 */
	public XLSWriter(final String xlsFile, final String sheetName) throws IOException
	{
		this.xlsFile = xlsFile;
		fis = new FileInputStream(new File(this.xlsFile));
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
	}

	/**
	 * @param rowNum
	 * @param colNum
	 * @param ipString
	 * @throws IOException
	 */
	public void writeToCell(final int rowNum, final int colNum, final String ipString) throws IOException
	{
		sheet.getRow(rowNum).getCell(colNum).setCellValue(ipString);
	}

	/**
	 * @param rowNum
	 * @param colNum
	 * @param propertyType
	 * @param propertyValue
	 */
	public void setCellProperties(final int rowNum, final int colNum, final CellProperties propertyType, final String propertyValue)
	{
		final Cell cell = sheet.getRow(rowNum).getCell(colNum);

		switch (propertyType)
		{
			case HYPERLINK:
			{
				final XSSFHyperlink link = workBook.getCreationHelper().createHyperlink(Hyperlink.LINK_URL);
				link.setAddress(propertyValue);
				cell.setHyperlink(link);
			}

			case COMMENTS:
			{
				final XSSFComment comment = sheet.createDrawingPatriarch().createCellComment(
						workBook.getCreationHelper().createClientAnchor());
				comment.setString(propertyValue);
				cell.setCellComment(comment);
			}
			default:
				break;
		}
	}


	public void close() throws IOException
	{
		fis.close();
		fos = new FileOutputStream(this.xlsFile);
		workBook.write(fos);
		fos.close();

	}


}
