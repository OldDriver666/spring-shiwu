package com.etoak.crawl.main.zlzp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLTest2 {
	public static void main(String args[]) throws Exception {
		lianjie();
	}

	public static void lianjie() throws Exception {
//		String charSet;
//		URL url = new URL("http://www.amazon.cn/");
//
//		URLConnection conn = url.openConnection();
//		String contenttype = conn.getContentType();
//		charSet = getCharset(contenttype);
		File file = new File("C:\\Users\\tany\\Desktop\\111.htm");
		
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
		BufferedReader bufin = new BufferedReader(isr);
		String line;
		String mailreg = "<a(?:\\s+.)*?\\s+href=\"([^\"]*?)\"";

		Pattern p = Pattern.compile(mailreg);
		while ((line = bufin.readLine()) != null) {
			Matcher m = p.matcher(line);
			while (m.find()) {
				String url = m.group();
				if (url.split("jobs.zhaopin.com").length >1 ) {
					String link = m.group().replaceAll("<a href=\"", "").replaceAll("\"", "");
//					System.out.println(link);
					WebPageSource.getJob(link);
				}
				
			}
		}
	}

	private static String getCharset(String str) {
		Pattern pattern = Pattern.compile("charset=.*");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find())
			return matcher.group(0).split("charset=")[1];
		return null;
	}
}