package com.webcrawler.crawler;

import com.webcrawler.config.Config;
import com.webcrawler.util.Controller;

public class Crawler {
	public Crawler() {
	}
	
	public void loadConfiguration(){
		new Config();
	}
	public void downloadEmails(){
		Controller controller=new Controller();
		controller.saveEmails(Config.base_url,Config.year);
	}
	
	public void changeConfiguration(String[] arg){
		Config.year=arg[0];
	}
	
	public static void main(String[] arg){
		
		System.out.println("Log file is under : /tmp/logs");	
		Crawler crawl = new Crawler();
		crawl.loadConfiguration();	
		
		if(arg.length>0)
			crawl.changeConfiguration(arg);
		
		System.out.println("Downloading Emails for the year "+Config.year+" : it may take long time to down");
		
		crawl.downloadEmails();
		
		System.out.println("Downloading completed - Please reffer file : "+Config.output_file);
	}
	
	
}