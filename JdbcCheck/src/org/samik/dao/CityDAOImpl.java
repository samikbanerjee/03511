/**
 *
 */
package org.samik.dao;

import java.util.List;

import javax.sql.DataSource;

import org.samik.model.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * @author Samik
 */
@Component
public class CityDAOImpl implements CityDAO
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
	 * @see org.samik.dao.CityDAO#createCity(org.samik.model.CityModel)
	 */
	@Override
	public void createCity(final CityModel city)
	{
		final String sql = "INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (?, ?, ?, ?, ?)";
		final int i = jdbcTemplate.update(sql, new Object[]
		{ city.getId(), city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation() });
		if (i != 0)
		{
			System.out.println("Created City with City ID = " + city.getId());
		}
		else
		{
			System.out.println("Failed to save city");
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.samik.dao.CityDAO#getCityById(int)
	 */
	@Override
	public CityModel getCityById(final int id)
	{
		final String sql = "SELECT ID, 	Name, CountryCode, District, Population FROM	city WHERE	ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[]
		{ id }, new CityModelMapper());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.samik.dao.CityDAO#getCitiesByCountryCode(java.lang.String)
	 */
	@Override
	public List<CityModel> getCitiesByCountryCode(final String countryCode)
	{
		final String sql = "SELECT ID, 	Name, CountryCode, District, Population FROM	city WHERE	CountryCode=?";
		return jdbcTemplate.query(sql, new Object[]
		{ countryCode }, new CityModelMapper());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.samik.dao.CityDAO#updateCity(org.samik.model.CityModel)
	 */
	@Override
	public void updateCity(final CityModel city)
	{
		final String sql = "UPDATE city SET NAME=?, CountryCode=?, District=?, Population=? WHERE ID=?";
		final int i = jdbcTemplate.update(sql, new Object[]
		{ city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation(), city.getId() });
		if (i != 0)
		{
			System.out.println("Saved City with City ID = " + city.getId());
		}
		else
		{
			System.out.println("Failed to save city");
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.samik.dao.CityDAO#deleteCityById(int)
	 */
	@Override
	public void deleteCityById(final int id)
	{
		final String sql = "DELETE FROM city WHERE ID=?";
		final int i = jdbcTemplate.update(sql, new Object[]
		{ id });
		if (i != 0)
		{
			System.out.println("Deleted City with City ID = " + id);
		}
		else
		{
			System.out.println("Failed to delete city");
		}

	}

}
