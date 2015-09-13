
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ProjectUtils.EmotionUtils;
import ProjectUtils.News;
import ProjectUtils.SplitUtils;
import jxl.JXLException;
import jxl.read.biff.BiffException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainPage {

	public static void main(String[] args) throws Exception {

		// 從kimono爬出來的apple.xls去把對應網址的新聞抓出來
//		Excelhandler eh = new Excelhandler();
//		ArrayList<News> parsingList = eh
//				.getParsing("/Users/apple/Documents/workspace/graduateProject/src/appleNews_airport.xlsx");
//		ArrayList<News> apple_news = getContent＿apple(parsingList);
//	
		// housefun直接爬
		//ArrayList<String> house_fun_news = getContent＿housefun();
		// 輸出至excel檔
	//	eh.writeContent(apple_news,"apple");
		//eh.writeContent(house_fun_news,"housefun");
		
		
		Excelhandler ehtogetemotion = new Excelhandler();
		SplitUtils suti =new SplitUtils();
		ArrayList<News> splitList = ehtogetemotion.geteSplitWord("split_output_apple.xls");
		ArrayList<News> emotionList = suti.getSplitArray(splitList);
//		
		
		
		//System.out.println(emotionList.get(0).getAll_split_word().get(0).getKind());
//		
		EmotionUtils a = new EmotionUtils();
		a.checkSO(emotionList);
	}

	public static ArrayList<News> getContent＿apple(ArrayList<News> a) throws Exception {
		for (int i = 0; i < 133; i++) {
			String ssss = a.get(i).getUrl();
			URL url = new URL(ssss);
			Document xmlDoc = Jsoup.parse(url, 300000); //
			Elements title = xmlDoc.select("p"); // 要解析的tag元素為title
			String newscontent = "";
			for (int j = 0; j < title.size(); j++) {
				newscontent += title.get(j).text();
			}
			System.out.println("STILL PARSING APPLE CONTENT......");
			a.get(i).setContent(newscontent);
		}
		return a;
	}

	public static ArrayList<String> getContent＿housefun() throws Exception {
		ArrayList<String> urlList = new ArrayList<String>();
		ArrayList<String> newsList = new ArrayList<String>();

		URL url1;
		InputStream is = null;
		DataInputStream dis;
		String line;

		try {
			int a = 0;
			System.out.println("START PARSING HOUSEFUN URL==================");
			for (int J = 1; J < 50; J++) {

				URL url = new URL("http://news.housefun.com.tw/news/%E8%88%AA%E7%A9%BA%E5%9F%8E/" + J + "?od=0&osc=1");
				is = url.openStream(); // throws an IOException
				dis = new DataInputStream(new BufferedInputStream(is));

				while ((line = dis.readLine()) != null) {
					if (line.contains("news/article/"))
						if (line.contains("m_news_list_image")) {
							String newsurl = line.substring(26, 55);
							if (newsurl.contains("html"))
								urlList.add(newsurl);
							else if (newsurl.contains("htm"))
								urlList.add(newsurl + "l");
							else
								urlList.add(newsurl + "ml");
						}
				}
			}
			System.out.println("PARSING HOUSEFUN URL END==================.");
			System.out.println(urlList.size());
			for (int i = 0; i < urlList.size(); i++) {
				String ssss = "http://news.housefun.com.tw" + urlList.get(i);
				System.out.println(ssss);
				URL url = new URL(ssss);
				Document xmlDoc = Jsoup.parse(url, 300000);
				Elements link = xmlDoc.select("p");
				String news = "";
				System.out.println("STILL PARSING HOUSEFUN CONTENT......"+i);
				for (int q = 0; q < link.size(); q++) {
					news += link.get(q).text();
				}
				if (news.isEmpty()||news.length()<=20) {
					Document xmlDoc1 = Jsoup.parse(url, 300000);
					Elements link1 = xmlDoc.select("div");
					for (int q = 0; q < link1.size(); q++) {
						news += link1.get(q).text();
					}
				}
				newsList.add(news);
			}

		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException ioe) {

			}
		}
		return newsList;

	}

}
