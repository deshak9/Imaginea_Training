package com.webcrawler.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.webcrawler.config.Config;

public class Page {
	
	static Logger logger = Logger.getLogger(Page.class.getName());
	private int currectConnectionCount;
	
	public Document fetchPage(String url){
		currectConnectionCount++;
		Document doc=null;
		try{
			doc= Jsoup.connect(url).get();
			logger.info("Fetched URL : "+url);
			currectConnectionCount=0;
		}
		
		catch(IOException ex){
			doc=null;
			ex.printStackTrace();
			logger.error("IO Error in connecting to URL "+url);
			/*if(currectConnectionCount<Config.reconnect_count)
				doc=fetchPage(url);*/
		}
		catch (Exception e) {
			doc=null;
			e.printStackTrace();
			logger.error("Error in connecting to URL "+url);
		}
		return doc;
	}
	
	/*Fetches XML data for each email
	 *URL Ex: - http://mail-archives.apache.org/mod_mbox/maven-users/201402.mbox/ajax/%3C037401cf1f42$73279430$5976bc90$@berthonneau.com%3E
	 **/ 
	public String fetchAjaxEmail(String url){
		Document doc = fetchPage(url);
		if(doc==null)
			return null;
		
		return doc.html();
	}
}
