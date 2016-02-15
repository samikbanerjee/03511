package org.jdbc.world.countryDAO;

/**
 * @author samik
 */
public class CountryModel
{
	private String Code;
	private String Name;
	private String Continent;
	private String Region;
	private double SurfaceArea;
	private int IndepYear;
	private int Population;
	private double LifeExpectancy;
	private double GNP;
	private double GNPOld;
	private String LocalName;
	private String GovernmentForm;
	private String HeadOfState;
	private String Capital;
	private String Code2;

	@Override
	public String toString()
	{

		return getCode() + "--" + getName() + "--" + getContinent() + "--" + getRegion() + "--" + getSurfaceArea() + "--"
				+ getIndepYear() + "--" + getPopulation() + "--" + getLifeExpectancy() + "--" + getGNP() + "--" + getGNPOld() + "--"
				+ getLocalName() + "--" + getGovernmentForm() + "--" + getHeadOfState() + "--" + getCapital() + "--" + getCode2();
	}

	/**
	 * @return the code
	 */
	public String getCode()
	{
		return Code;
	}

	/**
	 * @param code
	 *           the code to set
	 */
	public void setCode(final String code)
	{
		Code = code;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return Name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		Name = name;
	}

	/**
	 * @return the continent
	 */
	public String getContinent()
	{
		return Continent;
	}

	/**
	 * @param continent
	 *           the continent to set
	 */
	public void setContinent(final String continent)
	{
		Continent = continent;
	}

	/**
	 * @return the region
	 */
	public String getRegion()
	{
		return Region;
	}

	/**
	 * @param region
	 *           the region to set
	 */
	public void setRegion(final String region)
	{
		Region = region;
	}

	/**
	 * @return the surfaceArea
	 */
	public double getSurfaceArea()
	{
		return SurfaceArea;
	}

	/**
	 * @param surfaceArea
	 *           the surfaceArea to set
	 */
	public void setSurfaceArea(final double surfaceArea)
	{
		SurfaceArea = surfaceArea;
	}

	/**
	 * @return the indepYear
	 */
	public int getIndepYear()
	{
		return IndepYear;
	}

	/**
	 * @param indepYear
	 *           the indepYear to set
	 */
	public void setIndepYear(final int indepYear)
	{
		IndepYear = indepYear;
	}

	/**
	 * @return the population
	 */
	public int getPopulation()
	{
		return Population;
	}

	/**
	 * @param population
	 *           the population to set
	 */
	public void setPopulation(final int population)
	{
		Population = population;
	}

	/**
	 * @return the lifeExpectancy
	 */
	public double getLifeExpectancy()
	{
		return LifeExpectancy;
	}

	/**
	 * @param lifeExpectancy
	 *           the lifeExpectancy to set
	 */
	public void setLifeExpectancy(final double lifeExpectancy)
	{
		LifeExpectancy = lifeExpectancy;
	}

	/**
	 * @return the gNP
	 */
	public double getGNP()
	{
		return GNP;
	}

	/**
	 * @param gNP
	 *           the gNP to set
	 */
	public void setGNP(final double gNP)
	{
		GNP = gNP;
	}

	/**
	 * @return the gNPOld
	 */
	public double getGNPOld()
	{
		return GNPOld;
	}

	/**
	 * @param gNPOld
	 *           the gNPOld to set
	 */
	public void setGNPOld(final double gNPOld)
	{
		GNPOld = gNPOld;
	}

	/**
	 * @return the localName
	 */
	public String getLocalName()
	{
		return LocalName;
	}

	/**
	 * @param localName
	 *           the localName to set
	 */
	public void setLocalName(final String localName)
	{
		LocalName = localName;
	}

	/**
	 * @return the governmentForm
	 */
	public String getGovernmentForm()
	{
		return GovernmentForm;
	}

	/**
	 * @param governmentForm
	 *           the governmentForm to set
	 */
	public void setGovernmentForm(final String governmentForm)
	{
		GovernmentForm = governmentForm;
	}

	/**
	 * @return the headOfState
	 */
	public String getHeadOfState()
	{
		return HeadOfState;
	}

	/**
	 * @param headOfState
	 *           the headOfState to set
	 */
	public void setHeadOfState(final String headOfState)
	{
		HeadOfState = headOfState;
	}

	/**
	 * @return the capital
	 */
	public String getCapital()
	{
		return Capital;
	}

	/**
	 * @param capital
	 *           the capital to set
	 */
	public void setCapital(final String capital)
	{
		Capital = capital;
	}

	/**
	 * @return the code2
	 */
	public String getCode2()
	{
		return Code2;
	}

	/**
	 * @param code2
	 *           the code2 to set
	 */
	public void setCode2(final String code2)
	{
		Code2 = code2;
	}




}
