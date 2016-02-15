package org.jdbc.world.cityDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/**
 * @author samik
 */
public class CityModelMapper implements RowMapper<CityModel>
{

	public CityModel mapRow(final ResultSet rs, final int rownum) throws SQLException
	{
		final CityModel city = new CityModel();
		city.setID(rs.getInt("ID"));
		city.setCountryCode(rs.getString("CountryCode"));
		city.setDistrict(rs.getString("District"));
		city.setName(rs.getString("Name"));
		city.setPopulation(rs.getInt("Population"));
		return city;
	}

}
