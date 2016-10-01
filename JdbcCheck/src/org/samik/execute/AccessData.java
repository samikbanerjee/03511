package org.samik.execute;

import java.util.List;

import org.samik.dao.JdbcDaoImpl;
import org.samik.model.CityModel;
import org.samik.model.CountryLanguageModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 */
public class AccessData
{
	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		final ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-data.xml");
		final JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

		final CityModel ct1 = dao.getCityById(1024);
		System.out.println(ct1.getName());

		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");

		final List<CityModel> cities = dao.getCitiesByCountryCode("IND");
		for (final CityModel cityModel : cities)
		{
			System.out.println(cityModel.getName() + "--" + cityModel.getPopulation());
		}

		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");

		final List<CountryLanguageModel> langs = dao.getLanguagesByCountryCode("IND");
		for (final CountryLanguageModel countryLanguageModel : langs)
		{
			System.out.println(countryLanguageModel.getLanguage() + "--" + countryLanguageModel.getIsOfficial() + "--"
					+ countryLanguageModel.getPercentage());
		}


	}


}
