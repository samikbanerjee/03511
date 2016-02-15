package org.jdbc.world;

import java.util.List;

import org.jdbc.world.cityDAO.CityDaoImpl;
import org.jdbc.world.cityDAO.CityModel;
import org.jdbc.world.cityDAO.CitySearchParams;
import org.jdbc.world.countryDAO.CountryDaoImpl;
import org.jdbc.world.countryDAO.CountryModel;
import org.jdbc.world.countryDAO.CountrySearchParams;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App
{
	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-data.xml");

		final CityDaoImpl cityDA = ctx.getBean("cityDaoImpl", CityDaoImpl.class);
		final List<CityModel> cts = cityDA.getCityByParam(CitySearchParams.ID, "1");
		for (final CityModel ct : cts)
		{
			System.out.println(ct.toString());
		}

		final CountryDaoImpl countryDA = ctx.getBean("countryDaoImpl", CountryDaoImpl.class);
		final List<CountryModel> ctries = countryDA.getCountry(CountrySearchParams.Code, "ABW");
		for (final CountryModel ctr : ctries)
		{
			System.out.println(ctr.toString());
		}

		ctx.close();



	}
}
