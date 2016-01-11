package com.webcrawler.main;

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
	
	
}
