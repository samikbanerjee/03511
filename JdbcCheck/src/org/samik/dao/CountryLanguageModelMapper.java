package org.samik.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.samik.model.CountryLanguageModel;
import org.springframework.jdbc.core.RowMapper;


/**
 * @author samik
 */
public final class CountryLanguageModelMapper implements RowMapper<CountryLanguageModel>
{

	@Override
	public CountryLanguageModel mapRow(final ResultSet rs, final int rownum) throws SQLException
	{
		final CountryLanguageModel language = new CountryLanguageModel();
		language.setCountryCode(rs.getString("CountryCode"));
		language.setLanguage(rs.getString("Language"));
		language.setIsOfficial(rs.getString("IsOfficial"));
		language.setPercentage(rs.getDouble("Percentage"));
		return language;
	}
}
