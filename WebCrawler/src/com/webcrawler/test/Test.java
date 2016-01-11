package com.webcrawler.test;

public class Test {

	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		com.webcrawler.main.Crawler crawl=new com.webcrawler.main.Crawler();
		crawl.downloadEmails();
		System.out.println((System.currentTimeMillis()-startTime)/(1000*60));
	}

}
