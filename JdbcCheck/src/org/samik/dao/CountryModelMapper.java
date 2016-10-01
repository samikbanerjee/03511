package org.samik.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.samik.model.CountryModel;
import org.springframework.jdbc.core.RowMapper;


/**
 * @author samik
 */
public final class CountryModelMapper implements RowMapper<CountryModel>
{

	@Override
	public CountryModel mapRow(final ResultSet rs, final int rownum) throws SQLException
	{
		final CountryModel country = new CountryModel();
		country.setCode(rs.getString("Code"));
		country.setName(rs.getString("Name"));
		country.setContinent(rs.getString("Continent"));
		country.setRegion(rs.getString("Region"));
		country.setSurfaceArea(rs.getDouble("SurfaceArea"));
		country.setIndepYear(rs.getInt("IndepYear"));
		country.setPopulation(rs.getDouble("Population"));
		country.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
		country.setGnp(rs.getDouble("GNP"));
		country.setGnpOld(rs.getDouble("GNPOld"));
		country.setLocalName(rs.getString("LocalName"));
		country.setGovernmentForm(rs.getString("GovernmentForm"));
		country.setHeadOfState(rs.getString("HeadOfState"));
		country.setCapital(rs.getInt("Capital"));
		country.setCode2(rs.getString("Code2"));
		return country;
	}

}
