/**
 *
 */
package org.samik.model;

/**
 *
 */
public class CityModel
{
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(final int id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode()
	{
		return countryCode;
	}

	/**
	 * @param countryCode
	 *           the countryCode to set
	 */
	public void setCountryCode(final String countryCode)
	{
		this.countryCode = countryCode;
	}

	/**
	 * @return the district
	 */
	public String getDistrict()
	{
		return district;
	}

	/**
	 * @param district
	 *           the district to set
	 */
	public void setDistrict(final String district)
	{
		this.district = district;
	}

	/**
	 * @return the population
	 */
	public int getPopulation()
	{
		return population;
	}

	/**
	 * @param population
	 *           the population to set
	 */
	public void setPopulation(final int population)
	{
		this.population = population;
	}

}
