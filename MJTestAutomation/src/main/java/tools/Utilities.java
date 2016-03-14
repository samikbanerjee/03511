/**
 *
 */
package tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 */
public class Utilities
{
	/**
	 * @return Date Time Stamp
	 */
	public static String dateTimeStamp()
	{
		final DateFormat dateFormat = new SimpleDateFormat("MMddyyHHmmss");
		return dateFormat.format(new Date());
	}
}
