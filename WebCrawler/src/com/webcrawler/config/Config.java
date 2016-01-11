package com.webcrawler.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public static String base_url=null;
	public static String year=null;
	public static String output_file=null;
	public static int reconnect_count;
	public Config() {
		Properties prop = new Properties();
		InputStream input=null;
		try{
			
			input =this.getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);
			Config.base_url=prop.getProperty("base_url");
			Config.year=prop.getProperty("year");
			Config.output_file=prop.getProperty("output_file");
			Config.reconnect_count=Integer.parseInt(prop.getProperty("reconnect_count"));
		}
		catch(IOException ioex){
			ioex.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
