package com.webcrawler.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcrawler.config.Config;

public class Controller {
	static Logger log = Logger.getLogger(Page.class.getName());
	
	public void saveEmails(String base_url,String year){
		
		Page page=new Page();
		SaveXmlData saveData=new SaveXmlData();
		for(int i=12 ; i>0 ;i--){
			String absolute_url=base_url+"/"+year;
			if(i<10)
				absolute_url+="0";
			
			absolute_url+=i+".mbox/date";
			
			List<String> emailLinks=fetchEmailLinks(page.fetchPage(absolute_url));
			
			for(String emailLink : emailLinks){
				String result=page.fetchAjaxEmail(postFixInUrl(emailLink));
				//result="<!DOCTYPE xmlDoc [ <!ENTITY nbsp \"&#160;\"> ]>"+result;
				if(result==null)
					log.fatal("Skipping URL for fetching the result : "+emailLink);
				else
					saveData.saveXmlData(result);
			}
		}
		saveData.saveDataOnFile();
		
		log.info("Emails contents are written successfully to xml File(Location) : "+Config.output_file);
	}
	public List<String> fetchEmailLinks(Document doc){
		
        Elements links = doc.select("tr td");
        
        List<String> emailLinks=new ArrayList<String>();
        
        for(Element ele : links){
        	if(ele.hasClass("subject"))
        	{
        		Elements ele2=ele.select("a");
        		emailLinks.add(ele2.attr("abs:href"));
        		//System.out.println(ele2.attr("abs:href"));
        		
        	}
        }
        return emailLinks;
	}
	
	
	/*Add "ajax" keyword in URL*/
	public String postFixInUrl(String url){
		int index=url.lastIndexOf("/");
		return url.substring(0, index)+"/ajax/"+url.substring(index+1);
	}
	
}
