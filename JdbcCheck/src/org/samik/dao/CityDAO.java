/**
 *
 */
package org.samik.dao;

import java.util.List;

import org.samik.model.CityModel;


/**
 * @author Samik
 */

public interface CityDAO
{
	/**
	 * Create
	 */
	public void createCity(CityModel city);

	/**
	 * Read
	 */
	public CityModel getCityById(int id);

	/**
	 * Read
	 */
	public List<CityModel> getCitiesByCountryCode(String countryCode);

	/**
	 * Update
	 */
	public void updateCity(CityModel city);

	/**
	 * Delete
	 */
	public void deleteCityById(final int id);


}
