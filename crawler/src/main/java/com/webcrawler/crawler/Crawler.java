package com.webcrawler.crawler;

import com.webcrawler.config.Config;
import com.webcrawler.util.Controller;

public class Crawler {
	public Crawler() {
		new Config();
	}
	public void downloadEmails(){
		Controller controller=new Controller();
		controller.saveEmails(Config.base_url,Config.year);
	}
	
	public static void main(String[] arg){
		System.out.println("Downloading Emails : it may take long time to down");
		System.out.println("Log file is under : /tmp/logs");
		new Crawler().downloadEmails();
		System.out.println("Downloading completed - Please reffer file : "+Config.output_file);
	}
	
	
}