/**
 *
 */
package other.rep.sustenance;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 */
public class CollateExcel
{
	public static final String ipDir = "E:\\Samik\\Projects\\04 Projects\\08-Sustenance\\WSR\\Input";
	public static final String ipFile = "Sustenance WSR_Aug_1.xlsx";
	public static final String ipSheet = "Developer Quality KPI";


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		final String path = ipDir + File.separatorChar + ipFile;

		final XSSFWorkbook book = new XSSFWorkbook(path);
		final XSSFSheet sheet = book.getSheet(ipSheet);

		System.out.println(sheet.getRow(7).getCell(7).getStringCellValue());

		book.close();
	}
}
