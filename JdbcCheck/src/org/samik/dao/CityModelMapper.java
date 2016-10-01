package org.samik.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.samik.model.CityModel;
import org.springframework.jdbc.core.RowMapper;


/**
 * @author samik
 */
public final class CityModelMapper implements RowMapper<CityModel>
{

	@Override
	public CityModel mapRow(final ResultSet rs, final int rownum) throws SQLException
	{
		final CityModel city = new CityModel();
		city.setId(rs.getInt("ID"));
		city.setName(rs.getString("Name"));
		city.setCountryCode(rs.getString("CountryCode"));
		city.setDistrict(rs.getString("District"));
		city.setPopulation(rs.getInt("Population"));
		return city;
	}
}
