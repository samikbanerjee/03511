/**
 *
 */
package org.jdbc.world.countryDAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * @author samik
 */
@Component
public class CountryDaoImpl implements CountryDAO
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

	/*
	 * (non-Javadoc)
	 *
	 * @see org.jdbc.world.countryDAO.CountryDAO#createCountry(org.jdbc.world.countryDAO.CountryModel)
	 */
	public String createCountry(final CountryModel country)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.jdbc.world.countryDAO.CountryDAO#getCountry(org.jdbc.world.countryDAO.CountrySearchParams,
	 * java.lang.String)
	 */
	public List<CountryModel> getCountry(final CountrySearchParams param, final String paramvalue)
	{
		final String SQL = "SELECT a1.Code, a1.Name, a1.Continent, a1.Region, a1.SurfaceArea, a1.IndepYear, a1.Population, a1.LifeExpectancy, a1.GNP, a1.GNPOld, a1.LocalName, a1.GovernmentForm, a1.HeadOfState, a2.Name as Capital, a1.Code2"
				+ " FROM magicDB.Country a1,  magicDB.City a2" + " WHERE a1.Capital=a2.ID AND " + param + " = ?";

		return jdbcTemplate.query(SQL, new Object[]
		{ paramvalue }, new CountryModelMapper());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.jdbc.world.countryDAO.CountryDAO#updateCountry(org.jdbc.world.countryDAO.CountryModel)
	 */
	public String updateCountry(final CountryModel country)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.jdbc.world.countryDAO.CountryDAO#deleteCountries(org.jdbc.world.countryDAO.CountrySearchParams,
	 * java.lang.String)
	 */
	public String deleteCountries(final CountrySearchParams param, final String paramvalue)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
