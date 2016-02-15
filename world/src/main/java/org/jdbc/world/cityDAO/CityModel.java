/**
 *
 */
package org.jdbc.world.cityDAO;

/**
 * @author samik
 */
public class CityModel
{
	private int ID;
	private String Name;
	private String CountryCode;
	private String District;
	private int Population;

	/**
	 * @return the iD
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * @param iD
	 *           the iD to set
	 */
	public void setID(final int iD)
	{
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return Name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		Name = name;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode()
	{
		return CountryCode;
	}

	/**
	 * @param countryCode
	 *           the countryCode to set
	 */
	public void setCountryCode(final String countryCode)
	{
		CountryCode = countryCode;
	}

	/**
	 * @return the district
	 */
	public String getDistrict()
	{
		return District;
	}

	/**
	 * @param district
	 *           the district to set
	 */
	public void setDistrict(final String district)
	{
		District = district;
	}

	/**
	 * @return the population
	 */
	public int getPopulation()
	{
		return Population;
	}

	/**
	 * @param population
	 *           the population to set
	 */
	public void setPopulation(final int population)
	{
		Population = population;
	}


	@Override
	public String toString()
	{
		return getID() + "--" + getCountryCode() + "--" + getDistrict() + "--" + getName() + "--" + getPopulation();
	}

}
