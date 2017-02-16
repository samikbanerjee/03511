package jira.Rest.Client;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * @author samik
 */
public class XmlParser
{
	static Document doc;

	/**
	 * @param bis
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public XmlParser(final BufferedInputStream bis) throws SAXException, IOException, ParserConfigurationException
	{
		doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(bis);
	}

	/**
	 * @param xmlStr
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public XmlParser(final String xmlStr) throws SAXException, IOException, ParserConfigurationException
	{
		doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlStr);
	}

	/**
	 * @param xpathXpression
	 * @return the list of nodes for the provided xpath expression
	 * @throws XPathExpressionException
	 */
	public NodeList getNodes(final String xpathXpression) throws XPathExpressionException
	{
		final XPathExpression xpath = XPathFactory.newInstance().newXPath().compile(xpathXpression);
		return (NodeList) xpath.evaluate(doc, XPathConstants.NODESET);
	}

	/**
	 * @param xpathXpression
	 * @param n
	 * @return the value of the nth node
	 * @throws XPathExpressionException
	 */
	public String getNodeValue(final String xpathXpression, final int n) throws XPathExpressionException
	{
		if (getNodes(xpathXpression).getLength() > n)
		{
			return getNodes(xpathXpression).item(n).getTextContent().toString().trim();

		}
		else
		{
			return "No nodes exist";
		}

	}
}
