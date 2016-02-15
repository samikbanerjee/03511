/**
 *
 */
package org.jdbc.world.countryDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/**
 * @author samik
 */
public class CountryModelMapper implements RowMapper<CountryModel>
{

	public CountryModel mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final CountryModel country = new CountryModel();
		// , , , , , , , , , , , , ,
		country.setCode(rs.getString("Code"));
		country.setName(rs.getString("Name"));
		country.setContinent(rs.getString("Continent"));
		country.setRegion(rs.getString("Region"));
		country.setSurfaceArea(rs.getDouble("SurfaceArea"));
		country.setIndepYear(rs.getInt("IndepYear"));
		country.setPopulation(rs.getInt("Population"));
		country.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
		country.setGNP(rs.getDouble("GNP"));
		country.setGNPOld(rs.getDouble("GNPOld"));
		country.setLocalName(rs.getString("LocalName"));
		country.setGovernmentForm(rs.getString("GovernmentForm"));
		country.setHeadOfState(rs.getString("HeadOfState"));
		country.setCapital(rs.getString("Capital"));
		country.setCode2(rs.getString("Code2"));
		return country;
	}

}
