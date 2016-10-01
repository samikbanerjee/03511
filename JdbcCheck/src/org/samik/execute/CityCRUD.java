/**
 *
 */
package org.samik.execute;

import org.samik.dao.CityDAOImpl;
import org.samik.model.CityModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 */
public class CityCRUD
{

	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-data.xml");
		final CityDAOImpl cityDAO = ctx.getBean("cityDAOImpl", CityDAOImpl.class);

		//Create
		//		final CityModel cityCreate = new CityModel();
		//		cityCreate.setCountryCode("IND");
		//		cityCreate.setDistrict("Maharashtra");
		//		cityCreate.setId(9002);
		//		cityCreate.setName("Bulla's city2");
		//		cityCreate.setPopulation(100);
		//		cityDAO.createCity(cityCreate);
		//		System.out.println("---------DONE--------------");


		//Read
		final CityModel c = cityDAO.getCityById(9002);
		System.out.println(c.getCountryCode() + "--" + c.getDistrict() + "--" + c.getId() + "--" + c.getName() + "--"
				+ c.getPopulation());
		System.out.println("---------BEFORE UPDATE--------------");


		//Update
		final CityModel cityUpdate = new CityModel();
		cityUpdate.setCountryCode("IND");
		cityUpdate.setDistrict("Maharashtra");
		cityUpdate.setId(9002);
		cityUpdate.setName("Bulla's city2 Updated");
		cityUpdate.setPopulation(100000);
		cityDAO.updateCity(cityUpdate);
		System.out.println("---------UPDATED--------------");


		//Read
		final CityModel c1 = cityDAO.getCityById(9002);
		System.out.println(c1.getCountryCode() + "--" + c1.getDistrict() + "--" + c1.getId() + "--" + c1.getName() + "--"
				+ c1.getPopulation());
		System.out.println("---------AFTER UPDATE--------------");



		//Delete
		cityDAO.deleteCityById(9002);
		System.out.println("---------DELETED--------------");

		ctx.close();
	}
}
