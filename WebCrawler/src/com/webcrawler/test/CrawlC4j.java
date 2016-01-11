package com.webcrawler.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Example program to list links from a URL.
 */
public class CrawlC4j {
    public static void main(String[] args) throws IOException {
        String url = "http://mail-archives.apache.org/mod_mbox/maven-users/201403.mbox/date";
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("tr td");
        
        for(Element ele : links){
        	if(ele.hasClass("subject"))
        	{
        		Elements ele2=ele.select("a");
        		System.out.println(ele2.attr("abs:href"));
        	}
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
