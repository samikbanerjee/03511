package jira.Dashboard.Reporting.tools;

/**
 *
 */
public class QueryObject
{
	/**
	 * @return the module
	 */
	public String getModule()
	{
		return module;
	}

	/**
	 * @param module
	 *           the module to set
	 */
	public void setModule(final String module)
	{
		this.module = module;
	}

	/**
	 * @return the jql
	 */
	public String getJql()
	{
		return jql;
	}

	/**
	 * @param jql
	 *           the jql to set
	 */
	public void setJql(final String jql)
	{
		this.jql = jql;
	}

	/**
	 * @return the positionX
	 */
	public int getPositionX()
	{
		return positionX;
	}

	/**
	 * @param positionX
	 *           the positionX to set
	 */
	public void setPositionX(final int positionX)
	{
		this.positionX = positionX;
	}

	/**
	 * @return the positionY
	 */
	public int getPositionY()
	{
		return positionY;
	}

	/**
	 * @param positionY
	 *           the positionY to set
	 */
	public void setPositionY(final int positionY)
	{
		this.positionY = positionY;
	}

	private String module;
	private String jql;
	private int positionX;
	private int positionY;
}
