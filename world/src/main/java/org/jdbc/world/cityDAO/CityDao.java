package org.jdbc.world.cityDAO;

import java.util.List;


/**
 * @author samik
 */
public interface CityDao
{
	/**
	 * Create city
	 *
	 * @param city
	 * @return success / error message
	 */
	public String createCity(CityModel city);


	/**
	 * Read
	 *
	 * @param paramName
	 * @param paramVal
	 * @return city
	 */
	public List<CityModel> getCityByParam(final CitySearchParams paramName, final String paramVal);


	/**
	 * Update
	 *
	 * @param city
	 * @return success / error message
	 */
	public String updateCity(CityModel city);


	/**
	 * @param paramName
	 * @param paramValue
	 * @return success / error message
	 */
	public String deleteCity(CitySearchParams paramName, String paramValue);
}
