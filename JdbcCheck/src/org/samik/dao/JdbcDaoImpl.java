package org.samik.dao;

import java.util.List;

import javax.sql.DataSource;

import org.samik.model.CityModel;
import org.samik.model.CountryLanguageModel;
import org.samik.model.CountryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component
public class JdbcDaoImpl
{
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource()
	{
		return dataSource;
	}

	/**
	 * @param dataSource
	 *           the dataSource to set
	 */
	public void setDataSource(final DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate
	 *           the jdbcTemplate to set
	 */
	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param countryCode
	 * @return getCountryByCode
	 */
	public CountryModel getCountryByCode(final String countryCode)
	{
		final String sql = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, "
				+ "LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 "
				+ "FROM COUNTRY WHERE Code=?";
		return jdbcTemplate.queryForObject(sql, new Object[]
		{ countryCode }, new CountryModelMapper());
	}

	/**
	 * @param continent
	 * @return getCountriesByContinent
	 */
	public List<CountryModel> getCountriesByContinent(final String continent)
	{
		final String sql = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, "
				+ "LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 "
				+ "FROM COUNTRY WHERE Continent=?";
		return jdbcTemplate.query(sql, new Object[]
		{ continent }, new CountryModelMapper());
	}


	/**
	 * @param id
	 * @return getCityById
	 */
	public CityModel getCityById(final int id)
	{
		final String sql = "SELECT ID, 	Name, CountryCode, District, Population FROM	city WHERE	ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[]
		{ id }, new CityModelMapper());
	}

	/**
	 * @param countryCode
	 * @return getCitiesByCountry
	 */
	public List<CityModel> getCitiesByCountryCode(final String countryCode)
	{
		final String sql = "SELECT ID, 	Name, CountryCode, District, Population FROM	city WHERE	CountryCode=?";
		return jdbcTemplate.query(sql, new Object[]
		{ countryCode }, new CityModelMapper());
	}

	/**
	 * @param countryCode
	 * @return getLanguagesByCountryCode
	 */
	public List<CountryLanguageModel> getLanguagesByCountryCode(final String countryCode)
	{
		final String sql = "SELECT CountryCode, Language, IsOfficial, Percentage FROM CountryLanguage WHERE CountryCode=?";
		return jdbcTemplate.query(sql, new Object[]
		{ countryCode }, new CountryLanguageModelMapper());
	}

}
