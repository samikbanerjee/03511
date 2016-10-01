package org.samik.model;

/**
 * @author Samik
 */
public class CountryLanguageModel
{
	private String countryCode;
	private String language;
	private String isOfficial;
	private double percentage;

	/**
	 * @return the countryCode
	 */
	public String getCountryCode()
	{
		return countryCode;
	}

	/**
	 * @param countryCode
	 *           the countryCode to set
	 */
	public void setCountryCode(final String countryCode)
	{
		this.countryCode = countryCode;
	}

	/**
	 * @return the language
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * @param language
	 *           the language to set
	 */
	public void setLanguage(final String language)
	{
		this.language = language;
	}

	/**
	 * @return the isOfficial
	 */
	public String getIsOfficial()
	{
		return isOfficial;
	}

	/**
	 * @param isOfficial
	 *           the isOfficial to set
	 */
	public void setIsOfficial(final String isOfficial)
	{
		this.isOfficial = isOfficial;
	}

	/**
	 * @return the percentage
	 */
	public double getPercentage()
	{
		return percentage;
	}

	/**
	 * @param percentage
	 *           the percentage to set
	 */
	public void setPercentage(final double percentage)
	{
		this.percentage = percentage;
	}

}
