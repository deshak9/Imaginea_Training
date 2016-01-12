package com.webcrawler.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.webcrawler.config.Config;

public class SaveXmlData {
	static Logger log = Logger.getLogger(Page.class.getName());
	
	private DocumentBuilder dBuilder =null;
	private Document xmlDoc=null;
	private Element rootElement=null;
	private DocumentBuilderFactory dbFactory=null;
	public SaveXmlData() {
		dbFactory=DocumentBuilderFactory.newInstance();
		try {
			dBuilder=dbFactory.newDocumentBuilder();
			xmlDoc=dBuilder.newDocument();
			rootElement=xmlDoc.createElement("mails");
			xmlDoc.appendChild(rootElement);
			
		} catch (ParserConfigurationException e) {
			log.error("Error creating DocumentBuilder");
			e.printStackTrace();
		}
		
	}
	public void saveXmlData(String xmlData){
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlData));
		try {
			
			Document firstDoc=dBuilder.parse(is);
			Node secondDocNode=firstDoc.getFirstChild();
			Node tempNode=xmlDoc.importNode(secondDocNode, true);
			rootElement.appendChild(tempNode);
			log.info("Child is appended");
			
			
		} catch (DOMException e) {
			log.debug("Error writing xml data");
			e.printStackTrace();
		} catch (SAXException e) {
			log.debug("Error writing xml data");
			e.printStackTrace();
		} catch (IOException e) {
			log.debug("Error writing xml data");
			e.printStackTrace();
		}
		
	}
	
	public void saveDataOnFile(){
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		try{
			Transformer transformer=transformerFactory.newTransformer();
			DOMSource source =new  DOMSource(xmlDoc);
			String targetFileName = Config.output_file+"/"+Config.year+"-emails.xml";
			File file = new File(targetFileName);
			StreamResult result=new StreamResult(file);
			transformer.transform(source, result);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
