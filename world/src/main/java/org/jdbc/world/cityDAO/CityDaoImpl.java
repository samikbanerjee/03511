/**
 *
 */
package org.jdbc.world.cityDAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * @author samik
 */
@Component
public class CityDaoImpl implements CityDao
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
	 * @see org.jdbc.world.city.CityDao#createCity(org.jdbc.world.city.CityModel)
	 */
	public String createCity(final CityModel city)
	{
		final String sql = "INSERT INTO City(ID, Name, CountryCode, District, Population) VALUES (?, ?, ?, ? ,?)";

		try
		{
			final int rows = jdbcTemplate.update(sql, new Object[]
			{ city.getID(), city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation() });
			return rows + " rows inserted..";
		}
		catch (final DataAccessException e)
		{
			return e.getMessage();
		}


	}

	/**
	 * @param paramName
	 * @param paramVal
	 * @return One City or List of Cities
	 */
	public List<CityModel> getCityByParam(final CitySearchParams paramName, final String paramVal)
	{
		final String sql = "SELECT `ID`, `Name`, `CountryCode`, `District`, `Population` FROM City WHERE " + paramName.toString()
				+ " =?";
		return jdbcTemplate.query(sql, new Object[]
		{ paramVal }, new CityModelMapper());

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.jdbc.world.city.CityDao#updateCity(org.jdbc.world.city.CityModel)
	 */
	public String updateCity(final CityModel city)
	{

		final String sql = "UPDATE City SET Name=?, CountryCode=?, District=?, Population=? FROM City WHERE ID=?";

		try
		{
			final int rows = jdbcTemplate.update(sql, new Object[]
			{ city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation(), city.getID() });
			return rows + " rows updated..";
		}
		catch (final DataAccessException e)
		{
			return e.getMessage();
		}
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see org.jdbc.world.city.CityDao#deleteCity
	 */
	public String deleteCity(final CitySearchParams paramName, final String paramValue)
	{
		final String sql = "DELETE FROM City WHERE " + paramName.toString() + " = ?";
		try
		{
			final int rows = jdbcTemplate.update(sql, new Object[]
			{ paramValue });
			return rows + " rows deleted..";
		}
		catch (final DataAccessException e)
		{
			return e.getMessage();
		}
	}

}
