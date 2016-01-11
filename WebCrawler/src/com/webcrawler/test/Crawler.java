package com.webcrawler.test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Crawler {

		public static void main(String[] arg){
	URL url;
    InputStream is = null;
    DataInputStream dis;
    String line;

    try {
        url = new URL("http://mail-archives.apache.org/mod_mbox/maven-users/201402.mbox/date");
        is = url.openStream();  // throws an IOException
        dis = new DataInputStream(new BufferedInputStream(is));

        String thisurl="http://mail-archives.apache.org/mod_mbox/maven-users/201412.mbox/%3cCAMH6+axiVTGYTOGuTfOOp=Bgt4UQzT2-buSN_i2KexTXGBzPVQ@mail.gmail.com%3e";
        System.out.println(thisurl);
        int index=thisurl.lastIndexOf("/");
		System.out.println(thisurl.substring(0, index)+"/ajax/"+thisurl.substring(index+1));
		
        while ((line = dis.readLine()) != null) {
            //System.out.println(line);
        }
    } catch (MalformedURLException mue) {
         mue.printStackTrace();
    } catch (IOException ioe) {
         ioe.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here
        }
    }
		}

}
