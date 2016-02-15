package org.jdbc.world.countryDAO;

import java.util.List;


/**
 * @author samik
 */
public interface CountryDAO
{
	/**
	 * Create
	 *
	 * @param country
	 * @return success /error message while creating country
	 */
	public String createCountry(CountryModel country);


	/**
	 * Read
	 *
	 * @param param
	 * @param paramvalue
	 * @return List of countries
	 */
	public List<CountryModel> getCountry(CountrySearchParams param, String paramvalue);

	/**
	 * Update
	 *
	 * @param country
	 * @return success /error message while updating country
	 */
	public String updateCountry(CountryModel country);


	/**
	 * Delete
	 * 
	 * @param param
	 * @param paramvalue
	 * @return success /error message while deleting country
	 */
	public String deleteCountries(CountrySearchParams param, String paramvalue);



}
