package BPN;

import java.net.URL;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainPage {

	public static void main(String[] args) throws IOException {
		// FileReader fr = new FileReader("kimonoData_1.csv");
		// BufferedReader br = new BufferedReader(fr);
		//
		// String str = null;
		// String Data[][];
		// ArrayList tmpxList = new ArrayList();
		// ArrayList tmpyList = new ArrayList();
		// BufferedReader reader = new BufferedReader(new InputStreamReader(new
		// FileInputStream("house.TXT"), "UTF-8"));
		// while ((str = reader.readLine()) != null) {
		// System.out.println(str);
		// String tempArray[] = str.split("\\,");// 分割逗號
		// tmpxList.add(tempArray[0]);
		// tmpyList.add(tempArray[1]);
		// }
		// Data = new String[tmpxList.size()][2];
		// for (int i = 0; i < tmpxList.size(); i++) {
		// Data[i][0] = (String) tmpxList.get(i);
		// Data[i][1] = (String) tmpyList.get(i);
		// }
		// for (int i = 0; i < Data.length; i++) {
		// for (int j = 0; j < Data[0].length; j++)
		// System.out.print(i + "-" + j + " " + Data[i][j] + " ");
		//
		// }

		// URL url = new
		// URL("http://home.appledaily.com.tw/article/index/20150602/36583748/search/3%E9%83%BD%E5%BB%BA%E7%89%A9%E8%B2%B7%E8%B3%A3%E7%A7%BB%E8%BD%89%20%E5%B9%B4%E6%B8%9B3%E6%88%90");
		// Document xmlDoc = Jsoup.parse(url, 3000); //
		// Elements title = xmlDoc.select("p"); //要解析的tag元素為title
		// Elements happy = xmlDoc.select("td"); //要解析的tag元素為td
		// String newscontent ="";
		// for(int i = 0;i<title.size();i++)
		// {
		//
		// newscontent+=title.get(i).text();
		//
		// }
		// System.out.println(newscontent);
		System.out.println("1");
	}
}
